package com.example.machineAcafeTest;

//class RessourceStockee implements Ressource {
//    private int _stock;
//
//    public RessourceStockee(int stockInitial){
//        _stock = stockInitial;
//    }
//
//    public void Consommer(){
//        _stock --;
//    }
//
//    void Reapprovisionner(){
//        _stock ++;
//    }
//
//    public boolean EstPresente(){
//        return _stock > 0;
//    }
//
//    int GetStock(){return _stock;}
//}

class RessourceStockee implements Ressource {
    private int _stock;

    public RessourceStockee(int stockInitial){
        _stock = stockInitial;
    }

    public void Consommer(){
        _stock --;
    }

    void Réapprovisionner(){
        _stock ++;
    }

    public boolean EstPrésente(){
        return _stock > 0;
    }

    int GetStock(){return _stock;}
}
