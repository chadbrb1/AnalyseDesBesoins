package com.example.machineAcafeTest;

import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SucreTest {
    @Test
    @DisplayName("ETANT DONNE une machine " +
            "ET un appui sur le bouton sucre " +
            "QUAND on insère 40 cts " +
            "ALORS un cafe coule " +
            "ET une dose de sucre est consommee")
    public void Decrementation_Cafe(){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCafeInitiaux = machine.GetNombreCafésServis();
        int stockSucreInitial = machine.GetStockSucre();

        // ET un appui sur le bouton sucre
        machine.SucrerCafé();

        double sommeInseree = 0.40;

        // QUAND on insère 40 cts
        machine.PayerEnEspece(sommeInseree);

        // ALORS le cafe coule
        int nombreCafesFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);

        // ET une dose de sucre est consommee
        int stockSucreFinal = machine.GetStockSucre();
        assertEquals(stockSucreInitial - 1, stockSucreFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine " +
            "ET un appui sur le bouton sucre " +
            "QUAND on insère 40 cts deux fois" +
            "ALORS deux cafes coulent " +
            "ET une seule dose de sucre est consommee")
    public void RaZ_Bouton_Sucre(){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCafeInitiaux = machine.GetNombreCafésServis();
        int stockSucreInitial = machine.GetStockSucre();

        // ET un appui sur le bouton sucre
        machine.SucrerCafé();

        // QUAND on insère 40 cts deux fois
        double sommeInseree = 0.40;
        machine.PayerEnEspece(sommeInseree);
        machine.PayerEnEspece(sommeInseree);

        // ALORS deux cafes coulent
        int nombreCafesFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCafeInitiaux + 2, nombreCafesFinaux);

        // ET une dose de sucre est consommee
        int stockSucreFinal = machine.GetStockSucre();
        assertEquals(stockSucreInitial - 1, stockSucreFinal);
    }
}