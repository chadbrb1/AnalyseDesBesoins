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
//            "QUAND on ins??re 40 cts " +
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
//        // QUAND on ins??re 40 cts
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
            "ALORS aucun caf?? ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Eau(){
        // ETANT DONNE une machine n'ayant plus d'eau
        Machine machine = MachineBuilder.Default();
        machine.CouperEau();

        int nombreCaf??Initiaux = machine.GetNombreCaf??sServis();
        double argentEncaiss??Initial = machine.GetArgentEncaiss??();

        // QUAND on met 40cts
        machine.PayerEnEspece(0.40);

        // ALORS aucun caf?? ne coule
        int nombreCaf??sFinaux = machine.GetNombreCaf??sServis();
        assertEquals(nombreCaf??Initiaux, nombreCaf??sFinaux);

        // ET l'argent est rendu
        double argentEncaiss??Final = machine.GetArgentEncaiss??();
        assertEquals(argentEncaiss??Initial, argentEncaiss??Final);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de gobelets " +
            "QUAND on met 40cts " +
            "ALORS aucun caf?? ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Gobelet(){
        // ETANT DONNE une machine n'ayant pas de gobelets
        Machine machine = new MachineBuilder()
                .SansGobelets()
                .Build();

        int nombreCaf??Initiaux = machine.GetNombreCaf??sServis();
        double argentEncaiss??Initial = machine.GetArgentEncaiss??();

        // QUAND on met 40cts
        machine.PayerEnEspece(0.40);

        // ALORS aucun caf?? ne coule
        int nombreCaf??sFinaux = machine.GetNombreCaf??sServis();
        assertEquals(nombreCaf??Initiaux, nombreCaf??sFinaux);

        // ET l'argent est rendu
        double argentEncaiss??Final = machine.GetArgentEncaiss??();
        assertEquals(argentEncaiss??Initial, argentEncaiss??Final);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de caf?? " +
            "QUAND on met 40cts " +
            "ALORS aucun caf?? ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Caf??(){
        // ETANT DONNE une machine n'ayant pas de caf??
        Machine machine = new MachineBuilder()
                .SansCaf??()
                .Build();

        int nombreCaf??Initiaux = machine.GetNombreCaf??sServis();
        double argentEncaiss??Initial = machine.GetArgentEncaiss??();

        // QUAND on met 40cts
        machine.PayerEnEspece(0.40);

        // ALORS aucun caf?? ne coule
        int nombreCaf??sFinaux = machine.GetNombreCaf??sServis();
        assertEquals(nombreCaf??Initiaux, nombreCaf??sFinaux);

        // ET l'argent est rendu
        double argentEncaiss??Final = machine.GetArgentEncaiss??();
        assertEquals(argentEncaiss??Initial, argentEncaiss??Final);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de sucre " +
            "ET un appui sur le bouton sucre " +
            "QUAND on ins??re 40 cts " +
            "ALORS aucun caf?? ne coule " +
            "ET l'argent est rembours??")
    public void Decrementation_Caf??(){
        // ETANT DONNE une machine n'ayant plus de sucre
        Machine machine = new MachineBuilder().SansSucre().Build();
        int nombreCaf??Initiaux = machine.GetNombreCaf??sServis();
        double argentEncaiss??Initial = machine.GetArgentEncaiss??();

        // ET un appui sur le bouton sucre
        machine.SucrerCaf??();

        // QUAND on ins??re 40 cts
        double sommeIns??r??e = 0.40;
        machine.PayerEnEspece(sommeIns??r??e);

        // ALORS aucun caf?? ne coule
        int nombreCaf??sFinaux = machine.GetNombreCaf??sServis();
        assertEquals(nombreCaf??Initiaux, nombreCaf??sFinaux);

        // ET l'argent est rendu
        double argentEncaiss??Final = machine.GetArgentEncaiss??();
        assertEquals(argentEncaiss??Initial, argentEncaiss??Final);
    }
}
