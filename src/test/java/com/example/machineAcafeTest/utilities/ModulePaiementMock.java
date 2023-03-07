package com.example.machineAcafeTest.utilities;

//import net.bank.interop.ModulePrelevementAutomatique;
//
//public class ModulePaiementMock implements ModulePrelevementAutomatique {
//
//    private final boolean _réponseAFournirDansTousLesCas;
//
//    public ModulePaiementMock(boolean réponseAFournirDansTousLesCas){
//
//        _réponseAFournirDansTousLesCas = réponseAFournirDansTousLesCas;
//    }
//    @Override
//    public boolean Prelever(double montantEnEuros) {
//        return _réponseAFournirDansTousLesCas;
//    }
//}


import com.example.machineAcafeTest.interop.ModulePrelevementAutomatique;

public class ModulePaiementMock implements ModulePrelevementAutomatique {

    private final boolean _réponseAFournirDansTousLesCas;

    public ModulePaiementMock(boolean réponseAFournirDansTousLesCas){

        _réponseAFournirDansTousLesCas = réponseAFournirDansTousLesCas;
    }
    @Override
    public boolean Prelever(double montantEnEuros) {
        return _réponseAFournirDansTousLesCas;
    }
}
