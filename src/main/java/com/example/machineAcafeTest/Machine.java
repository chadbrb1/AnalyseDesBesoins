package com.example.machineAcafeTest;


//public class Machine {
//    private int _nombreCafesServis = 0;
//    private double _argentEncaisse = 0;
//    private Ressource _eau;
//    private final RessourceStockee _gobelets;
//    private final RessourceStockee _cafe;
//    private final RessourceStockee _sucre;
//    private boolean _boutonSucreAppuye = false;
//
//    public Machine(){
//        _gobelets = new RessourceStockee(1);
//        _cafe = new RessourceStockee(1);
//        _sucre = new RessourceStockee(1);
//        _eau = new RessourceInfinie(true);
//    }
//
//    private boolean PeutFaireUnCafeSimple(double somme){
//        return somme >= 0.4 && _eau.EstPresente() && _gobelets.EstPresente() && _cafe.EstPresente();
//    }
//
//    private boolean PeutFaireUnCafeSucre(double somme){
//        return PeutFaireUnCafeSimple(somme) && _sucre.EstPresente();
//    }
//
//    public void Inserer(double somme) {
//        if(_boutonSucreAppuye ? PeutFaireUnCafeSucre(somme) : PeutFaireUnCafeSimple(somme)){
//            _argentEncaisse += somme;
//            _nombreCafesServis ++;
//            _gobelets.Consommer();
//            _cafe.Consommer();
//
//            if(_boutonSucreAppuye){
//                _sucre.Consommer();
//            }
//        }
//
//        _boutonSucreAppuye = false;
//    }
//
//    public int GetNombreCafesServis() {
//        return _nombreCafesServis;
//    }
//    public double GetArgentEncaisse() {
//        return _argentEncaisse;
//    }
//    public int GetStockSucre() { return _sucre.GetStock(); }
//
//    public void CouperEau() {
//        _eau = new RessourceInfinie(false);
//    }
//    public void SucrerCafe() { _boutonSucreAppuye = true; }
//
//    public void ReapprovisionnerCafe() {
//        _cafe.Reapprovisionner();
//    }
//
//    public void ReapprovisionnerGobelet() {
//        _gobelets.Reapprovisionner();
//    }
//
//    public void ReapprovisionnerSucre() {
//        _sucre.Reapprovisionner();
//    }
//}

import com.example.machineAcafeTest.interop.*;

import java.util.HashMap;
import java.util.Map;

public class Machine {
    private int _nombreCafésServis = 0;
    private double _argentEncaissé = 0;
    private Ressource _eau;
    private final RessourceStockee _gobelets;
    private final RessourceStockee _café;
    private final RessourceStockee _sucre;
    private final RessourceStockee _touillette;
    private boolean _boutonSucreAppuyé = false;

    private ModulePrelevementAutomatique _modulePrelevementAutomatique = null;
    private ModuleSansContact _moduleSansContact = null;

    private Map<String,Double> boissons = new HashMap<>();

    public Machine(){
        _gobelets = new RessourceStockee(1);
        _café = new RessourceStockee(1);
        _sucre = new RessourceStockee(1);
        _eau = new RessourceInfinie(true);
        _touillette = new RessourceStockee(10);
    }

    public Machine(ModulePrelevementAutomatique module,ModuleSansContact moduleSansContact){
        this();
        _modulePrelevementAutomatique = module;
        _moduleSansContact = moduleSansContact;
    }

    public Machine(ModulePrelevementAutomatique module){
        this();
        _modulePrelevementAutomatique = module;
    }
    public void creerBoissons() {
        boissons.put("Café",0.4);
        boissons.put("Allongé",0.4);
        boissons.put("Latté",0.45);
        boissons.put("Choco",0.4);
        boissons.put("Choco-lait",0.45);
        boissons.put("Cappuccino",0.5);
    }

    private boolean PeutFaireUnCaféSimple(double somme){
        return somme >= 0.4 && _eau.EstPrésente() && _gobelets.EstPrésente() && _café.EstPrésente();
    }

    private boolean PeutFaireUnCaféSucré(double somme){
        return PeutFaireUnCaféSimple(somme) && _sucre.EstPrésente();
    }

    public void PayerEnEspece(double somme) {
        if(_boutonSucreAppuyé ? PeutFaireUnCaféSucré(somme) : PeutFaireUnCaféSimple(somme)){
            _argentEncaissé += somme;
            _nombreCafésServis ++;
            _gobelets.Consommer();
            _café.Consommer();

            if(_boutonSucreAppuyé){
                _sucre.Consommer();
                _touillette.Consommer();
            }
        }

        _boutonSucreAppuyé = false;
    }



    public int GetNombreCafésServis() {
        return _nombreCafésServis;
    }
    public double GetArgentEncaissé() {
        return _argentEncaissé;
    }
    public int GetStockSucre() { return _sucre.GetStock(); }
    public int GetStockTouillettes() { return _touillette.GetStock(); }

    public void CouperEau() {_eau = new RessourceInfinie(false);}
    public void SucrerCafé() { _boutonSucreAppuyé = true; }

    public void RéapprovisionnerCafé() {
        _café.Réapprovisionner();
    }

    public void RéapprovisionnerGobelet() {
        _gobelets.Réapprovisionner();
    }

    public void RéapprovisionnerSucre() {_sucre.Réapprovisionner();}

    //public void RéapprovisionnerTouillette() {_touillette.Réapprovisionner();}

    public void PayerEnCB() {
        var somme = 0.40;
        var paiementRéussi = _modulePrelevementAutomatique.Prelever(somme);
        if (paiementRéussi) this.PayerEnEspece(somme);
    }

    public void PayerEnCBBanque(double somme) {
        var paiement = this._moduleSansContact.Prelever(somme);
        if (paiement) this.PayerEnEspece(somme);
    }

    public double ChoisirBoisson(String nomBoisson){
        return boissons.get(nomBoisson);
    }
}
