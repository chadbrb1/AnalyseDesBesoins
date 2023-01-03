package com.example.machineAcafeTest;

public class Machine {
    private int _nombreCafesServis = 0;
    private double _argentEncaisse = 0;
    private boolean _eauDisponible = true;
    private int _nombreGobelets;
    private int _cafeEnStock;

    private int _sucreEnStock;


    public Machine(int nombreGobeletsInitial, int dosesCafeInitiales, int _nombreDosesSucre) {
        _nombreGobelets = nombreGobeletsInitial;
        _cafeEnStock = dosesCafeInitiales;
        _sucreEnStock = _nombreDosesSucre;
    }

    public void consoSucre(boolean sucre){
        if (sucre){
            _sucreEnStock --;
        }
    }

    public int getNombreSucreMachine(){
        return this._sucreEnStock;
    }
    public void Inserer(double somme,boolean sucre) {
        if (sucre) {
            if (_sucreEnStock > 0 ){
                consoSucre(sucre);
            }
        }
        if(somme >= 0.4 && _eauDisponible && _nombreGobelets > 0 && _cafeEnStock > 0){
            _argentEncaisse += somme;
            _nombreCafesServis ++;
            _nombreGobelets --;
        }

    }

    public void Reappro() {
        this._cafeEnStock ++;
    }

    public int GetCafeEnStock(){
        return _cafeEnStock ;
    }

    public int GetNombreCafesServis() {
        return _nombreCafesServis;
    }

    public double GetArgentEncaisse() {
        return _argentEncaisse;
    }

    public void CouperEau() {
        _eauDisponible = false;
    }
}