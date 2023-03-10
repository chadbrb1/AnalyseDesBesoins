package com.example.machineAcafeTest;
//
//import com.example.machineAcafeTest.utilities.MachineBuilder;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class MachineAcafeTest {
//    @ParameterizedTest
//    @DisplayName("QUAND on met au moins 40cts ALORS un cafe coule ET l'argent est encaisse")
//    @ValueSource(doubles = {0.40, 0.41})
//    public void Test_Cafe_Coule(double sommeInseree){
//        // ETANT DONNE une machine
//        Machine machine = MachineBuilder.Default();
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//
//        // QUAND on met 40cts
//        machine.Inserer(sommeInseree);
//
//        // ALORS un cafe coule
//        int nombreCafesFinaux = machine.GetNombreCafesServis();
//        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);
//
//        // ET l'argent est encaisse
//        double argentEncaisseFinal = machine.GetArgentEncaisse();
//        assertEquals(argentEncaisseInitial + sommeInseree, argentEncaisseFinal);
//    }
//
//    @Test
//    @DisplayName("QUAND on met moins de 40cts ALORS aucun cafe ne coule ET l'argent est rendu")
//    public void Test_Pas_Assez_Argent(){
//        // ETANT DONNE une machine
//        Machine machine = MachineBuilder.Default();
//        int nombreCafeInitiaux = machine.GetNombreCafesServis();
//        double argentEncaisseInitial = machine.GetArgentEncaisse();
//        double sommeInsuffisante = 0.39;
//
//        // QUAND on met moins de 40cts
//        machine.Inserer(sommeInsuffisante);
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
//}


import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

public class MachineAcafeTest {
    @ParameterizedTest
    @DisplayName("QUAND on met au moins 40cts ALORS un caf?? coule ET l'argent est encaiss??")
    @ValueSource(doubles = {0.40, 0.41})
    public void Test_Cafe_Coule(double sommeIns??r??e){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCaf??Initiaux = machine.GetNombreCaf??sServis();
        double argentEncaiss??Initial = machine.GetArgentEncaiss??();

        // QUAND on met 40cts
        machine.PayerEnEspece(sommeIns??r??e);

        // ALORS un caf?? coule
        int nombreCaf??sFinaux = machine.GetNombreCaf??sServis();
        assertEquals(nombreCaf??Initiaux + 1, nombreCaf??sFinaux);

        // ET l'argent est encaiss??
        double argentEncaiss??Final = machine.GetArgentEncaiss??();
        assertEquals(argentEncaiss??Initial + sommeIns??r??e, argentEncaiss??Final);
    }

    @Test
    @DisplayName("QUAND on met moins de 40cts ALORS aucun caf?? ne coule ET l'argent est rendu")
    public void Test_Pas_Assez_Argent(){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCaf??Initiaux = machine.GetNombreCaf??sServis();
        double argentEncaiss??Initial = machine.GetArgentEncaiss??();
        double sommeInsuffisante = 0.39;

        // QUAND on met moins de 40cts
        machine.PayerEnEspece(sommeInsuffisante);

        // ALORS aucun caf?? ne coule
        int nombreCaf??sFinaux = machine.GetNombreCaf??sServis();
        assertEquals(nombreCaf??Initiaux, nombreCaf??sFinaux);

        // ET l'argent est rendu
        double argentEncaiss??Final = machine.GetArgentEncaiss??();
        assertEquals(argentEncaiss??Initial, argentEncaiss??Final);
    }
}
