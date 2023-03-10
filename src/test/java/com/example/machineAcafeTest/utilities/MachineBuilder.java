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
//        _modulePr??l??vementAutomatique = modulePaiement;
//        return this;
//    }
//}





//public class MachineBuilder {
//    private int _nombreDosesCaf?? = 2;
//    private int _nombreGobelets = 2;
//    private int _stockInitialSucre = 1;
//    private ModulePrelevementAutomatique _modulePr??l??vementAutomatique = null;
//
//    public static Machine Default() {
//        return new MachineBuilder().Build();
//    }
//
//    public Machine Build()
//    {
//        var machine = _modulePr??l??vementAutomatique == null
//                ? new Machine()
//                : new Machine(_modulePr??l??vementAutomatique);
//
//        if(_nombreDosesCaf?? == 0){
//            machine.PayerEnEspece(0.40);
//            machine.R??approvisionnerGobelet();
//        }
//
//        if(_nombreGobelets == 0){
//            machine.PayerEnEspece(0.40);
//            machine.R??approvisionnerCaf??();
//        }
//
//        if(_stockInitialSucre == 0){
//            machine.SucrerCaf??();
//            machine.PayerEnEspece(0.40);
//            machine.R??approvisionnerCaf??();
//            machine.R??approvisionnerGobelet();
//        }
//
//        for (var dosesCaf??DansLaMachine = 1; dosesCaf??DansLaMachine < _nombreDosesCaf??; dosesCaf??DansLaMachine ++)
//            machine.R??approvisionnerCaf??();
//
//        for (var gobeletsDansLaMachine = 1; gobeletsDansLaMachine < _nombreGobelets; gobeletsDansLaMachine ++)
//            machine.R??approvisionnerGobelet();
//
//        for (var sucreDansLaMachine = 1; sucreDansLaMachine < _stockInitialSucre; sucreDansLaMachine ++)
//            machine.R??approvisionnerSucre();
//
//        return machine;
//    }
//
//    public MachineBuilder SansGobelets() {
//        return AyantXGobelets(0);
//    }
//
//    public MachineBuilder SansCaf??() {
//        return AyantYDosesDeCaf??(0);
//    }
//
//    public MachineBuilder AyantXGobelets(int x) {
//        _nombreGobelets = x;
//        return this;
//    }
//
//    public MachineBuilder AyantYDosesDeCaf??(int y) {
//        _nombreDosesCaf?? = y;
//        return this;
//    }
//
//    public MachineBuilder SansSucre() {
//        _stockInitialSucre = 0;
//        return this;
//    }
//
//    public MachineBuilder AyantUnModuleDePaiement(ModulePrelevementAutomatique modulePaiement) {
//        _modulePr??l??vementAutomatique = modulePaiement;
//        return this;
//    }
//
//    public MachineBuilder SansTouillette() {
//    }
//}

public class MachineBuilder {
    private int _nombreDosesCaf?? = 2;
    private int _nombreGobelets = 2;
    private int _stockInitialSucre = 1;
    private int _stockInitialTouillette = 1;
    private Ressource _eau = new RessourceInfinie(true);
    ;
    private ModulePrelevementAutomatique _modulePr??l??vementAutomatique = null;
    private ModuleSansContact _moduleSansContact = null;

    private Map<String, Double> boissons = new HashMap<>();

    public static Machine Default() {
        return new MachineBuilder().Build();
    }

    public Machine Build() {
        var machine = _modulePr??l??vementAutomatique == null
                ? new Machine()
                : new Machine(_modulePr??l??vementAutomatique,_moduleSansContact);

        if (_nombreDosesCaf?? == 0) {
            machine.PayerEnEspece(0.40);
            machine.R??approvisionnerGobelet();
        }

        if (_nombreGobelets == 0) {
            machine.PayerEnEspece(0.40);
            machine.R??approvisionnerCaf??();
        }

        if (_stockInitialSucre == 0) {
            machine.SucrerCaf??();
            machine.PayerEnEspece(0.40);
            machine.R??approvisionnerCaf??();
            machine.R??approvisionnerGobelet();
        }

        for (var dosesCaf??DansLaMachine = 1; dosesCaf??DansLaMachine < _nombreDosesCaf??; dosesCaf??DansLaMachine++)
            machine.R??approvisionnerCaf??();

        for (var gobeletsDansLaMachine = 1; gobeletsDansLaMachine < _nombreGobelets; gobeletsDansLaMachine++)
            machine.R??approvisionnerGobelet();

        for (var sucreDansLaMachine = 1; sucreDansLaMachine < _stockInitialSucre; sucreDansLaMachine++)
            machine.R??approvisionnerSucre();

        // On cr??e nos boissons, associ??es ?? la machine
        machine.creerBoissons();

        return machine;
    }


    public MachineBuilder SansGobelets() {
        return AyantXGobelets(0);
    }

    public MachineBuilder SansCaf??() {
        return AyantYDosesDeCaf??(0);
    }

    public MachineBuilder AyantXGobelets(int x) {
        _nombreGobelets = x;
        return this;
    }

    public MachineBuilder AyantYDosesDeCaf??(int y) {
        _nombreDosesCaf?? = y;
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
        _modulePr??l??vementAutomatique = modulePaiement;
        return this;
    }
    public MachineBuilder AyantUnModuleDePaiementSansContact(ModuleSansContact modulePaiement) {
        _moduleSansContact = modulePaiement;
        return this;
    }
}
