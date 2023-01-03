package com.example.machineAcafeTest;

import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MachineAcafeTest {
    @ParameterizedTest
    @DisplayName("QUAND on met au moins 40cts ALORS un cafe coule ET l'argent est encaisse")
    @ValueSource(doubles = {0.40, 0.41})
    public void Test_Cafe_Coule(double sommeInseree){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();
        boolean sucre = false ;
        // QUAND on met 40cts
        machine.Inserer(sommeInseree,sucre);

        // ALORS un cafe coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);

        // ET l'argent est encaisse
        double argentEncaisseFinal = machine.GetArgentEncaisse();
        assertEquals(argentEncaisseInitial + sommeInseree, argentEncaisseFinal);
    }

    @Test
    @DisplayName("QUAND on met moins de 40cts ALORS aucun cafe ne coule ET l'argent est rendu")
    public void Test_Pas_Assez_Argent(){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();
        double sommeInsuffisante = 0.39;

        // QUAND on met moins de 40cts
        boolean sucre = false ;
        machine.Inserer(sommeInsuffisante,sucre);

        // ALORS aucun cafe ne coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);

        // ET l'argent est rendu
        double argentEncaisseFinal = machine.GetArgentEncaisse();
        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
    }

}
