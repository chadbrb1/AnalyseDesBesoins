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
    @DisplayName("QUAND on met au moins 40cts ALORS un café coule ET l'argent est encaissé")
    @ValueSource(doubles = {0.40, 0.41})
    public void Test_Cafe_Coule(double sommeInsérée){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();

        // QUAND on met 40cts
        machine.PayerEnEspece(sommeInsérée);

        // ALORS un café coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);

        // ET l'argent est encaissé
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial + sommeInsérée, argentEncaisséFinal);
    }

    @Test
    @DisplayName("QUAND on met moins de 40cts ALORS aucun café ne coule ET l'argent est rendu")
    public void Test_Pas_Assez_Argent(){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();
        double sommeInsuffisante = 0.39;

        // QUAND on met moins de 40cts
        machine.PayerEnEspece(sommeInsuffisante);

        // ALORS aucun café ne coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);

        // ET l'argent est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial, argentEncaisséFinal);
    }
}
