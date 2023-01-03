package com.example.machineAcafeTest.utilities;


import com.example.machineAcafeTest.Machine;

public class MachineBuilder {
    private int _nombreDosesCafe = 1;
    private int _nombreGobelets = 1;

    private int _nombreDosesSucre = 1 ;
    private boolean _stockSucrePlein = true;
    private boolean _stockGobeletsPlein = true;
    private boolean _stockDosesCafePlein = true;


    public static Machine Default() {
        return new MachineBuilder().Build();
    }

    public Machine Build()
    {
        return new Machine(_nombreGobelets, _nombreDosesCafe,_nombreDosesSucre);
    }

    public MachineBuilder SansGobelets() {
        return AyantXGobelets(0);
    }

    public MachineBuilder SansSucre() {
        return AyantZDosesSucres(0);
    }

    public MachineBuilder SansCafe() {
        return AyantYDosesDeCafe(0);
    }


    public MachineBuilder AyantXGobelets(int x) {
        _nombreGobelets = x;
        return this;
    }

    public MachineBuilder AyantYDosesDeCafe(int y) {
        _nombreDosesCafe = y;
        return this;
    }

    public MachineBuilder AyantZDosesSucres(int x) {
        _nombreDosesSucre = x;
        return this;
    }

    public MachineBuilder AyantStockRessourcesPlein(){
        private boolean _stockSucrePlein = true;
        private boolean _stockGobeletsPlein = true;
        private boolean _stockDosesCafePlein = true;
        return this;
    }
}
