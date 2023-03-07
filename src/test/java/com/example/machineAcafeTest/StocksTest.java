package com.example.machineAcafeTest;
//import com.example.machineAcafeTest.utilities.MachineBuilder;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class StocksTest {
//    @Test
//    @DisplayName("ETANT DONNE une machine ayant un seul gobelet " +
//            "QUAND on insère deux fois 40 cts " +
//            "ALORS seul un cafe coule " +
//            "ET l'argent du second cafe est rendu")
//    public void Decrementation_Gobelets(){
//        // ETANT DONNE une machine ayant un seul gobelet
//        Machine machine = new MachineBuilder()
//                .AyantXGobelets(1)
//                .Build();
//
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//        double sommeInseree = 0.40;
//
//        // QUAND on insère deux fois 40 cts
//        machine.Inserer(sommeInseree);
//        machine.Inserer(sommeInseree);
//
//        // ALORS seul un cafe coule
//        int nombreCafesFinaux = machine.GetNombreCafesServis();
//        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);
//
//        // ET l'argent du second cafe est rendu
//        double argentEncaisseFinal = machine.GetArgentEncaisse();
//        assertEquals(argentEncaisseInitial + sommeInseree, argentEncaisseFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine ayant une seule dose de cafe " +
//            "ET au moins 2 gobelets" +
//            "QUAND on insère deux fois 40 cts " +
//            "ALORS seul un cafe coule " +
//            "ET l'argent du second cafe est rendu")
//    public void Decrementation_Cafe(){
//        // ETANT DONNE une machine ayant une seule dose de cafe
//        Machine machine = new MachineBuilder()
//                .AyantYDosesDeCafe(1)
//                .AyantXGobelets(2)
//                .Build();
//
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//
//        // QUAND on insère deux fois 40 cts
//        double sommeInseree = 0.40;
//        machine.Inserer(sommeInseree);
//        machine.Inserer(sommeInseree);
//
//        // ALORS seul un cafe coule
//        int nombreCafesFinaux = machine.GetNombreCafesServis();
//        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);
//
//        // ET l'argent du second cafe est rendu
//        double argentEncaisseFinal = machine.GetArgentEncaisse();
//        assertEquals(argentEncaisseInitial + sommeInseree, argentEncaisseFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine " +
//            "ALORS le stock initial de sucre est de 1")
//    public void StockInitialSucre(){
//        // ETANT DONNE une machine
//        var machine = new Machine();
//
//        // ALORS le stock initial de sucre est de 1
//        assertEquals(1, machine.GetStockSucre());
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine n'ayant pas de cafe " +
//            "ET un appui du technicien sur Reappro Cafe " +
//            "QUAND on insère 40cts 2 fois " +
//            "ALORS un seul cafe est servi")
//    public void TestReapproCafe(){
//        // ETANT DONNE une machine n'ayant pas de cafe
//        var machine = new MachineBuilder().SansCafe().Build();
//        int cafesServisInitiaux = machine.GetNombreCafesServis();
//
//        // ET un appui du technicien sur Reappro Cafe
//        machine.ReapprovisionnerCafe();
//
//        // QUAND on insère deux fois 40 cts
//        double sommeInseree = 0.40;
//        machine.Inserer(sommeInseree);
//        machine.Inserer(sommeInseree);
//
//        // ALORS un seul cafe est servi
//        int cafesServisFinaux = machine.GetNombreCafesServis();
//        assertEquals(cafesServisInitiaux + 1, cafesServisFinaux);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine n'ayant pas de gobelet " +
//            "ET un appui du technicien sur Reappro Cafe " +
//            "QUAND on insère 40cts 2 fois " +
//            "ALORS un seul cafe est servi")
//    public void TestReapproGobelet(){
//        // ETANT DONNE une machine n'ayant pas de gobelet
//        var machine = new MachineBuilder().SansGobelets().Build();
//        int cafesServisInitiaux = machine.GetNombreCafesServis();
//
//        // ET un appui du technicien sur Reappro Gobelet
//        machine.ReapprovisionnerGobelet();
//
//        // QUAND on insère deux fois 40 cts
//        double sommeInseree = 0.40;
//        machine.Inserer(sommeInseree);
//        machine.Inserer(sommeInseree);
//
//        // ALORS un seul cafe est servi
//        int cafesServisFinaux = machine.GetNombreCafesServis();
//        assertEquals(cafesServisInitiaux + 1, cafesServisFinaux);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine n'ayant pas de sucre " +
//            "ET un appui du technicien sur Reappro Sucre " +
//            "QUAND on insère 40cts 2 fois en ayant appuye sur Sucrer Cafe au prealable" +
//            "ALORS un seul cafe est servi")
//    public void TestReapproSucre(){
//        // ETANT DONNE une machine n'ayant pas de sucre
//        var machine = new MachineBuilder().SansSucre().Build();
//        int cafesServisInitiaux = machine.GetNombreCafesServis();
//
//        // ET un appui du technicien sur Reappro Sucre
//        machine.ReapprovisionnerSucre();
//
//        // QUAND on insère 40cts 2 fois en ayant appuye sur Sucrer Cafe au prealable
//        double sommeInseree = 0.40;
//
//        machine.SucrerCafe();
//        machine.Inserer(sommeInseree);
//
//        machine.SucrerCafe();
//        machine.Inserer(sommeInseree);
//
//        // ALORS un seul cafe est servi
//        int cafesServisFinaux = machine.GetNombreCafesServis();
//        assertEquals(cafesServisInitiaux + 1, cafesServisFinaux);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine " +
//            "ALORS le stock initial de cafe est de 1")
//    public void StockInitialCafe(){
//        // ETANT DONNE une machine
//        var machine = new Machine();
//        int cafesServisInitiaux = machine.GetNombreCafesServis();
//
//        // ALORS le stock initial de cafe de 1
//        machine.Inserer(0.40);
//
//        machine.ReapprovisionnerGobelet(); // Reappro Gobelet afin de s'assurer que la defaillance eventuelle vient bien du manque de cafe
//        machine.Inserer(0.40);
//
//        int cafesServisFinaux = machine.GetNombreCafesServis();
//        assertEquals(cafesServisInitiaux + 1, cafesServisFinaux);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine " +
//            "ALORS le stock initial de gobelets de 1")
//    public void StockInitialGobelets(){
//        // ETANT DONNE une machine
//        var machine = new Machine();
//        int cafesServisInitiaux = machine.GetNombreCafesServis();
//
//        // ALORS le stock initial de Gobelets est de 1
//        machine.Inserer(0.40);
//
//        machine.ReapprovisionnerCafe(); // Reappro Cafe afin de s'assurer que la defaillance eventuelle vient bien du manque de gobelets
//        machine.Inserer(0.40);
//
//        int cafesServisFinaux = machine.GetNombreCafesServis();
//        assertEquals(cafesServisInitiaux + 1, cafesServisFinaux);
//    }
//}


import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StocksTest {
    @Test
    @DisplayName("ETANT DONNE une machine ayant un seul gobelet " +
            "QUAND on insère deux fois 40 cts " +
            "ALORS seul un café coule " +
            "ET l'argent du second café est rendu")
    public void Decrementation_Gobelets(){
        // ETANT DONNE une machine ayant un seul gobelet
        Machine machine = new MachineBuilder()
                .AyantXGobelets(1)
                .Build();

        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();
        double sommeInsérée = 0.40;

        // QUAND on insère deux fois 40 cts
        machine.PayerEnEspece(sommeInsérée);
        machine.PayerEnEspece(sommeInsérée);

        // ALORS seul un café coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);

        // ET l'argent du second café est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial + sommeInsérée, argentEncaisséFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine ayant une seule dose de café " +
            "ET au moins 2 gobelets" +
            "QUAND on insère deux fois 40 cts " +
            "ALORS seul un café coule " +
            "ET l'argent du second café est rendu")
    public void Decrementation_Café(){
        // ETANT DONNE une machine ayant une seule dose de café
        Machine machine = new MachineBuilder()
                .AyantYDosesDeCafé(1)
                .AyantXGobelets(2)
                .Build();

        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();

        // QUAND on insère deux fois 40 cts
        double sommeInsérée = 0.40;
        machine.PayerEnEspece(sommeInsérée);
        machine.PayerEnEspece(sommeInsérée);

        // ALORS seul un café coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);

        // ET l'argent du second café est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial + sommeInsérée, argentEncaisséFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine " +
            "ALORS le stock initial de sucre est de 1")
    public void StockInitialSucre(){
        // ETANT DONNE une machine
        var machine = new Machine();

        // ALORS le stock initial de sucre est de 1
        assertEquals(1, machine.GetStockSucre());
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de café " +
            "ET un appui du technicien sur Reappro Café " +
            "QUAND on insère 40cts 2 fois " +
            "ALORS un seul café est servi")
    public void TestReapproCafé(){
        // ETANT DONNE une machine n'ayant pas de café
        var machine = new MachineBuilder().SansCafé().Build();
        int cafésServisInitiaux = machine.GetNombreCafésServis();

        // ET un appui du technicien sur Reappro Café
        machine.RéapprovisionnerCafé();

        // QUAND on insère deux fois 40 cts
        double sommeInsérée = 0.40;
        machine.PayerEnEspece(sommeInsérée);
        machine.PayerEnEspece(sommeInsérée);

        // ALORS un seul café est servi
        int cafésServisFinaux = machine.GetNombreCafésServis();
        assertEquals(cafésServisInitiaux + 1, cafésServisFinaux);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de gobelet " +
            "ET un appui du technicien sur Reappro Café " +
            "QUAND on insère 40cts 2 fois " +
            "ALORS un seul café est servi")
    public void TestReapproGobelet(){
        // ETANT DONNE une machine n'ayant pas de gobelet
        var machine = new MachineBuilder().SansGobelets().Build();
        int cafésServisInitiaux = machine.GetNombreCafésServis();

        // ET un appui du technicien sur Reappro Gobelet
        machine.RéapprovisionnerGobelet();

        // QUAND on insère deux fois 40 cts
        double sommeInsérée = 0.40;
        machine.PayerEnEspece(sommeInsérée);
        machine.PayerEnEspece(sommeInsérée);

        // ALORS un seul café est servi
        int cafésServisFinaux = machine.GetNombreCafésServis();
        assertEquals(cafésServisInitiaux + 1, cafésServisFinaux);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de sucre " +
            "ET un appui du technicien sur Reappro Sucre " +
            "QUAND on insère 40cts 2 fois en ayant appuyé sur Sucrer Café au préalable" +
            "ALORS un seul café est servi")
    public void TestReapproSucre(){
        // ETANT DONNE une machine n'ayant pas de sucre
        var machine = new MachineBuilder().SansSucre().Build();
        int cafésServisInitiaux = machine.GetNombreCafésServis();

        // ET un appui du technicien sur Reappro Sucre
        machine.RéapprovisionnerSucre();

        // QUAND on insère 40cts 2 fois en ayant appuyé sur Sucrer Café au préalable
        double sommeInsérée = 0.40;

        machine.SucrerCafé();
        machine.PayerEnEspece(sommeInsérée);

        machine.SucrerCafé();
        machine.PayerEnEspece(sommeInsérée);

        // ALORS un seul café est servi
        int cafésServisFinaux = machine.GetNombreCafésServis();
        assertEquals(cafésServisInitiaux + 1, cafésServisFinaux);
    }

    @Test
    @DisplayName("ETANT DONNE une machine " +
            "ALORS le stock initial de café est de 1")
    public void StockInitialCafé(){
        // ETANT DONNE une machine
        var machine = new Machine();
        int cafésServisInitiaux = machine.GetNombreCafésServis();

        // ALORS le stock initial de café de 1
        machine.PayerEnEspece(0.40);

        machine.RéapprovisionnerGobelet(); // Réappro Gobelet afin de s'assurer que la défaillance éventuelle vient bien du manque de café
        machine.PayerEnEspece(0.40);

        int cafésServisFinaux = machine.GetNombreCafésServis();
        assertEquals(cafésServisInitiaux + 1, cafésServisFinaux);
    }

    @Test
    @DisplayName("ETANT DONNE une machine " +
            "ALORS le stock initial de gobelets de 1")
    public void StockInitialGobelets(){
        // ETANT DONNE une machine
        var machine = new Machine();
        int cafésServisInitiaux = machine.GetNombreCafésServis();

        // ALORS le stock initial de Gobelets est de 1
        machine.PayerEnEspece(0.40);

        machine.RéapprovisionnerCafé(); // Réappro Café afin de s'assurer que la défaillance éventuelle vient bien du manque de gobelets
        machine.PayerEnEspece(0.40);

        int cafésServisFinaux = machine.GetNombreCafésServis();
        assertEquals(cafésServisInitiaux + 1, cafésServisFinaux);
    }
}
