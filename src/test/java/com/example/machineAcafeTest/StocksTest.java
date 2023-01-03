package com.example.machineAcafeTest;
import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StocksTest {
    @Test
    @DisplayName("ETANT DONNE une machine ayant un seul gobelet " +
            "QUAND on insère deux fois 40 cts " +
            "ALORS seul un cafe coule " +
            "ET l'argent du second cafe est rendu")
    public void Decrementation_Gobelets(){
        // ETANT DONNE une machine ayant un seul gobelet
        Machine machine = new MachineBuilder()
                .AyantXGobelets(1)
                .Build();

        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();
        double sommeInseree = 0.40;
        boolean sucre = false ;
        // QUAND on insère deux fois 40 cts
        machine.Inserer(sommeInseree,sucre);
        machine.Inserer(sommeInseree,sucre);

        // ALORS seul un cafe coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);

        // ET l'argent du second cafe est rendu
        double argentEncaisseFinal = machine.GetArgentEncaisse();
        assertEquals(argentEncaisseInitial + sommeInseree, argentEncaisseFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine ayant une seule dose de cafe " +
            "QUAND on insère deux fois 40 cts " +
            "ALORS seul un cafe coule " +
            "ET l'argent du second cafe est rendu")
    public void Decrementation_Cafe(){
        // ETANT DONNE une machine ayant une seule dose de cafe
        Machine machine = new MachineBuilder()
                .AyantYDosesDeCafe(1)
                .Build();

        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();
        double sommeInseree = 0.40;
        boolean sucre = false ;
        // QUAND on insère deux fois 40 cts
        machine.Inserer(sommeInseree,sucre);
        machine.Inserer(sommeInseree,sucre);

        // ALORS seul un cafe coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);

        // ET l'argent du second cafe est rendu
        double argentEncaisseFinal = machine.GetArgentEncaisse();
        assertEquals(argentEncaisseInitial + sommeInseree, argentEncaisseFinal);
    }
}