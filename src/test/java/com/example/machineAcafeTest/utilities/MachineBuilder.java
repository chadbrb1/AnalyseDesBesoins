package com.example.machineAcafeTest.utilities;

import com.example.machineAcafeTest.Machine;
import com.example.machineAcafeTest.Ressource;
import com.example.machineAcafeTest.RessourceInfinie;
import com.example.machineAcafeTest.interop.ModulePrelevementAutomatique;
import com.example.machineAcafeTest.interop.ModuleSansContact;

import java.util.HashMap;
import java.util.Map;

//
//import com.example.machineAcafeTest.Machine;
//
//public class MachineBuilder {
//    private int _nombreDosesCafe = 2;
//    private int _nombreGobelets = 2;
//    private int _stockInitialSucre = 1;
//
//    public static Machine Default() {
//        return new MachineBuilder().Build();
//    }
//
//    public Machine Build()
//    {
//        var machine = new Machine();
//
//        if(_nombreDosesCafe == 0){
//            machine.Inserer(0.40);
//            machine.ReapprovisionnerGobelet();
//        }
//
//        if(_nombreGobelets == 0){
//            machine.Inserer(0.40);
//            machine.ReapprovisionnerCafe();
//        }
//
//        if(_stockInitialSucre == 0){
//            machine.SucrerCafe();
//            machine.Inserer(0.40);
//            machine.ReapprovisionnerCafe();
//            machine.ReapprovisionnerGobelet();
//        }
//
//        for (var dosesCafeDansLaMachine = 1; dosesCafeDansLaMachine < _nombreDosesCafe; dosesCafeDansLaMachine ++)
//            machine.ReapprovisionnerCafe();
//
//        for (var gobeletsDansLaMachine = 1; gobeletsDansLaMachine < _nombreGobelets; gobeletsDansLaMachine ++)
//            machine.ReapprovisionnerGobelet();
//
//        for (var sucreDansLaMachine = 1; sucreDansLaMachine < _stockInitialSucre; sucreDansLaMachine ++)
//            machine.ReapprovisionnerSucre();
//
//        return machine;
//    }
//
//    public MachineBuilder SansGobelets() {
//        return AyantXGobelets(0);
//    }
//
//    public MachineBuilder SansCafe() {
//        return AyantYDosesDeCafe(0);
//    }
//
//    public MachineBuilder AyantXGobelets(int x) {
//        _nombreGobelets = x;
//        return this;
//    }
//
//    public MachineBuilder AyantYDosesDeCafe(int y) {
//        _nombreDosesCafe = y;
//        return this;
//    }
//
//    public MachineBuilder SansSucre() {
//        _stockInitialSucre = 0;
//        return this;
//    }
//
//    public MachineBuilder AyantUnModuleDePaiement(ModulePrelevementAutomatique modulePaiement) {
//        _modulePrélèvementAutomatique = modulePaiement;
//        return this;
//    }
//}





//public class MachineBuilder {
//    private int _nombreDosesCafé = 2;
//    private int _nombreGobelets = 2;
//    private int _stockInitialSucre = 1;
//    private ModulePrelevementAutomatique _modulePrélèvementAutomatique = null;
//
//    public static Machine Default() {
//        return new MachineBuilder().Build();
//    }
//
//    public Machine Build()
//    {
//        var machine = _modulePrélèvementAutomatique == null
//                ? new Machine()
//                : new Machine(_modulePrélèvementAutomatique);
//
//        if(_nombreDosesCafé == 0){
//            machine.PayerEnEspece(0.40);
//            machine.RéapprovisionnerGobelet();
//        }
//
//        if(_nombreGobelets == 0){
//            machine.PayerEnEspece(0.40);
//            machine.RéapprovisionnerCafé();
//        }
//
//        if(_stockInitialSucre == 0){
//            machine.SucrerCafé();
//            machine.PayerEnEspece(0.40);
//            machine.RéapprovisionnerCafé();
//            machine.RéapprovisionnerGobelet();
//        }
//
//        for (var dosesCaféDansLaMachine = 1; dosesCaféDansLaMachine < _nombreDosesCafé; dosesCaféDansLaMachine ++)
//            machine.RéapprovisionnerCafé();
//
//        for (var gobeletsDansLaMachine = 1; gobeletsDansLaMachine < _nombreGobelets; gobeletsDansLaMachine ++)
//            machine.RéapprovisionnerGobelet();
//
//        for (var sucreDansLaMachine = 1; sucreDansLaMachine < _stockInitialSucre; sucreDansLaMachine ++)
//            machine.RéapprovisionnerSucre();
//
//        return machine;
//    }
//
//    public MachineBuilder SansGobelets() {
//        return AyantXGobelets(0);
//    }
//
//    public MachineBuilder SansCafé() {
//        return AyantYDosesDeCafé(0);
//    }
//
//    public MachineBuilder AyantXGobelets(int x) {
//        _nombreGobelets = x;
//        return this;
//    }
//
//    public MachineBuilder AyantYDosesDeCafé(int y) {
//        _nombreDosesCafé = y;
//        return this;
//    }
//
//    public MachineBuilder SansSucre() {
//        _stockInitialSucre = 0;
//        return this;
//    }
//
//    public MachineBuilder AyantUnModuleDePaiement(ModulePrelevementAutomatique modulePaiement) {
//        _modulePrélèvementAutomatique = modulePaiement;
//        return this;
//    }
//
//    public MachineBuilder SansTouillette() {
//    }
//}

public class MachineBuilder {
    private int _nombreDosesCafé = 2;
    private int _nombreGobelets = 2;
    private int _stockInitialSucre = 1;
    private int _stockInitialTouillette = 1;
    private Ressource _eau = new RessourceInfinie(true);
    ;
    private ModulePrelevementAutomatique _modulePrélèvementAutomatique = null;
    private ModuleSansContact _moduleSansContact = null;

    private Map<String, Double> boissons = new HashMap<>();

    public static Machine Default() {
        return new MachineBuilder().Build();
    }

    public Machine Build() {
        var machine = _modulePrélèvementAutomatique == null
                ? new Machine()
                : new Machine(_modulePrélèvementAutomatique,_moduleSansContact);

        if (_nombreDosesCafé == 0) {
            machine.PayerEnEspece(0.40);
            machine.RéapprovisionnerGobelet();
        }

        if (_nombreGobelets == 0) {
            machine.PayerEnEspece(0.40);
            machine.RéapprovisionnerCafé();
        }

        if (_stockInitialSucre == 0) {
            machine.SucrerCafé();
            machine.PayerEnEspece(0.40);
            machine.RéapprovisionnerCafé();
            machine.RéapprovisionnerGobelet();
        }

        for (var dosesCaféDansLaMachine = 1; dosesCaféDansLaMachine < _nombreDosesCafé; dosesCaféDansLaMachine++)
            machine.RéapprovisionnerCafé();

        for (var gobeletsDansLaMachine = 1; gobeletsDansLaMachine < _nombreGobelets; gobeletsDansLaMachine++)
            machine.RéapprovisionnerGobelet();

        for (var sucreDansLaMachine = 1; sucreDansLaMachine < _stockInitialSucre; sucreDansLaMachine++)
            machine.RéapprovisionnerSucre();

        // On crée nos boissons, associées à la machine
        machine.creerBoissons();

        return machine;
    }


    public MachineBuilder SansGobelets() {
        return AyantXGobelets(0);
    }

    public MachineBuilder SansCafé() {
        return AyantYDosesDeCafé(0);
    }

    public MachineBuilder AyantXGobelets(int x) {
        _nombreGobelets = x;
        return this;
    }

    public MachineBuilder AyantYDosesDeCafé(int y) {
        _nombreDosesCafé = y;
        return this;
    }

    public MachineBuilder SansSucre() {
        _stockInitialSucre = 0;
        return this;
    }

    public MachineBuilder SansRessource() {
        _eau = new RessourceInfinie(false);
        return this;
    }

    public MachineBuilder SansTouillette() {
        _stockInitialTouillette = 0;
        return this;
    }

    public MachineBuilder AyantUnModuleDePaiement(ModulePrelevementAutomatique modulePaiement) {
        _modulePrélèvementAutomatique = modulePaiement;
        return this;
    }
    public MachineBuilder AyantUnModuleDePaiementSansContact(ModuleSansContact modulePaiement) {
        _moduleSansContact = modulePaiement;
        return this;
    }
}
