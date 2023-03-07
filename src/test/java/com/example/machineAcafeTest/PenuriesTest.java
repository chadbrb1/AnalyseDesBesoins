package com.example.machineAcafeTest;
import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
//public class PenuriesTest {
//    @Test
//    @DisplayName("ETANT DONNE une machine n'ayant plus d'eau " +
//            "QUAND on met 40cts " +
//            "ALORS aucun cafe ne coule " +
//            "ET l'argent est rendu")
//    public void Test_Sans_Eau(){
//        // ETANT DONNE une machine n'ayant plus d'eau
//        Machine machine = MachineBuilder.Default();
//        machine.CouperEau();
//
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//
//        // QUAND on met 40cts
//        machine.Inserer(0.40);
//
//        // ALORS aucun cafe ne coule
//        int nombreCafesFinaux = machine.GetNombreCafesServis();
//        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);
//
//        // ET l'argent est rendu
//        double argentEncaisseFinal = machine.GetArgentEncaisse();
//        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine n'ayant pas de gobelets " +
//            "QUAND on met 40cts " +
//            "ALORS aucun cafe ne coule " +
//            "ET l'argent est rendu")
//    public void Test_Sans_Gobelet(){
//        // ETANT DONNE une machine n'ayant pas de gobelets
//        Machine machine = new MachineBuilder()
//                .SansGobelets()
//                .Build();
//
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//
//        // QUAND on met 40cts
//        machine.Inserer(0.40);
//
//        // ALORS aucun cafe ne coule
//        int nombreCafesFinaux = machine.GetNombreCafesServis();
//        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);
//
//        // ET l'argent est rendu
//        double argentEncaisseFinal = machine.GetArgentEncaisse();
//        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine n'ayant pas de cafe " +
//            "QUAND on met 40cts " +
//            "ALORS aucun cafe ne coule " +
//            "ET l'argent est rendu")
//    public void Test_Sans_Cafe(){
//        // ETANT DONNE une machine n'ayant pas de cafe
//        Machine machine = new MachineBuilder()
//                .SansCafe()
//                .Build();
//
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//
//        // QUAND on met 40cts
//        machine.Inserer(0.40);
//
//        // ALORS aucun cafe ne coule
//        int nombreCafesFinaux = machine.GetNombreCafesServis();
//        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);
//
//        // ET l'argent est rendu
//        double argentEncaisseFinal = machine.GetArgentEncaisse();
//        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine n'ayant pas de sucre " +
//            "ET un appui sur le bouton sucre " +
//            "QUAND on insère 40 cts " +
//            "ALORS aucun cafe ne coule " +
//            "ET l'argent est rembourse")
//    public void Decrementation_Cafe(){
//        // ETANT DONNE une machine n'ayant plus de sucre
//        Machine machine = new MachineBuilder().SansSucre().Build();
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//
//        // ET un appui sur le bouton sucre
//        machine.SucrerCafe();
//
//        // QUAND on insère 40 cts
//        double sommeInseree = 0.40;
//        machine.Inserer(sommeInseree);
//
//        // ALORS aucun cafe ne coule
//        int nombreCafesFinaux = machine.GetNombreCafesServis();
//        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);
//
//        // ET l'argent est rendu
//        double argentEncaisseFinal = machine.GetArgentEncaisse();
//        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
//    }
//}

@SpringBootTest
public class PenuriesTest {
    @Test
    @DisplayName("ETANT DONNE une machine n'ayant plus d'eau " +
            "QUAND on met 40cts " +
            "ALORS aucun café ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Eau(){
        // ETANT DONNE une machine n'ayant plus d'eau
        Machine machine = MachineBuilder.Default();
        machine.CouperEau();

        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();

        // QUAND on met 40cts
        machine.PayerEnEspece(0.40);

        // ALORS aucun café ne coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);

        // ET l'argent est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial, argentEncaisséFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de gobelets " +
            "QUAND on met 40cts " +
            "ALORS aucun café ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Gobelet(){
        // ETANT DONNE une machine n'ayant pas de gobelets
        Machine machine = new MachineBuilder()
                .SansGobelets()
                .Build();

        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();

        // QUAND on met 40cts
        machine.PayerEnEspece(0.40);

        // ALORS aucun café ne coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);

        // ET l'argent est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial, argentEncaisséFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de café " +
            "QUAND on met 40cts " +
            "ALORS aucun café ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Café(){
        // ETANT DONNE une machine n'ayant pas de café
        Machine machine = new MachineBuilder()
                .SansCafé()
                .Build();

        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();

        // QUAND on met 40cts
        machine.PayerEnEspece(0.40);

        // ALORS aucun café ne coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);

        // ET l'argent est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial, argentEncaisséFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de sucre " +
            "ET un appui sur le bouton sucre " +
            "QUAND on insère 40 cts " +
            "ALORS aucun café ne coule " +
            "ET l'argent est remboursé")
    public void Decrementation_Café(){
        // ETANT DONNE une machine n'ayant plus de sucre
        Machine machine = new MachineBuilder().SansSucre().Build();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();

        // ET un appui sur le bouton sucre
        machine.SucrerCafé();

        // QUAND on insère 40 cts
        double sommeInsérée = 0.40;
        machine.PayerEnEspece(sommeInsérée);

        // ALORS aucun café ne coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);

        // ET l'argent est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial, argentEncaisséFinal);
    }
}
