package com.example.machineAcafeTest;

//class RessourceInfinie implements Ressource {
//    private final boolean _estPresente;
//
//    public boolean EstPresente(){
//        return _estPresente;
//    }
//
//    public void Consommer(){
//    }
//
//    public RessourceInfinie(boolean estPresente){
//
//        _estPresente = estPresente;
//    }
//}

public class RessourceInfinie implements Ressource {
    private final boolean _estPrésente;

    public boolean EstPrésente(){
        return _estPrésente;
    }

    public void Consommer(){
    }

    public RessourceInfinie(boolean estPrésente){

        _estPrésente = estPrésente;
    }
}
