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
    private int _nombreCaf??sServis = 0;
    private double _argentEncaiss?? = 0;
    private Ressource _eau;
    private final RessourceStockee _gobelets;
    private final RessourceStockee _caf??;
    private final RessourceStockee _sucre;
    private final RessourceStockee _touillette;
    private boolean _boutonSucreAppuy?? = false;

    private ModulePrelevementAutomatique _modulePrelevementAutomatique = null;
    private ModuleSansContact _moduleSansContact = null;

    private Map<String,Double> boissons = new HashMap<>();

    public Machine(){
        _gobelets = new RessourceStockee(1);
        _caf?? = new RessourceStockee(1);
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
        boissons.put("Caf??",0.4);
        boissons.put("Allong??",0.4);
        boissons.put("Latt??",0.45);
        boissons.put("Choco",0.4);
        boissons.put("Choco-lait",0.45);
        boissons.put("Cappuccino",0.5);
    }

    private boolean PeutFaireUnCaf??Simple(double somme){
        return somme >= 0.4 && _eau.EstPr??sente() && _gobelets.EstPr??sente() && _caf??.EstPr??sente();
    }

    private boolean PeutFaireUnCaf??Sucr??(double somme){
        return PeutFaireUnCaf??Simple(somme) && _sucre.EstPr??sente();
    }

    public void PayerEnEspece(double somme) {
        if(_boutonSucreAppuy?? ? PeutFaireUnCaf??Sucr??(somme) : PeutFaireUnCaf??Simple(somme)){
            _argentEncaiss?? += somme;
            _nombreCaf??sServis ++;
            _gobelets.Consommer();
            _caf??.Consommer();

            if(_boutonSucreAppuy??){
                _sucre.Consommer();
                _touillette.Consommer();
            }
        }

        _boutonSucreAppuy?? = false;
    }



    public int GetNombreCaf??sServis() {
        return _nombreCaf??sServis;
    }
    public double GetArgentEncaiss??() {
        return _argentEncaiss??;
    }
    public int GetStockSucre() { return _sucre.GetStock(); }
    public int GetStockTouillettes() { return _touillette.GetStock(); }

    public void CouperEau() {_eau = new RessourceInfinie(false);}
    public void SucrerCaf??() { _boutonSucreAppuy?? = true; }

    public void R??approvisionnerCaf??() {
        _caf??.R??approvisionner();
    }

    public void R??approvisionnerGobelet() {
        _gobelets.R??approvisionner();
    }

    public void R??approvisionnerSucre() {_sucre.R??approvisionner();}

    //public void R??approvisionnerTouillette() {_touillette.R??approvisionner();}

    public void PayerEnCB() {
        var somme = 0.40;
        var paiementR??ussi = _modulePrelevementAutomatique.Prelever(somme);
        if (paiementR??ussi) this.PayerEnEspece(somme);
    }

    public void PayerEnCBBanque(double somme) {
        var paiement = this._moduleSansContact.Prelever(somme);
        if (paiement) this.PayerEnEspece(somme);
    }

    public double ChoisirBoisson(String nomBoisson){
        return boissons.get(nomBoisson);
    }
}
