package com.example.machineAcafeTest;

import com.example.machineAcafeTest.interop.ModuleSansContact;
import com.example.machineAcafeTest.utilities.MachineBuilder;
import com.example.machineAcafeTest.utilities.ModulePaiementMock;
import com.example.machineAcafeTest.utilities.ModulePaiementSpy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaiementCBTest {
    @Test
    @DisplayName("ETANT DONNÉ une machine dont le stock d’une Ressource nécessaire est vide" +
            "ET que l’utilisateur a sélectionné une boisson" +
            "QUAND l’utilisateur paye en CB " +
            "ALORS aucune boisson ne coule" +
            "ET le paiement est annulé")
    public void TestCaféCB(){
        // ETANT DONNE une machine dont le stock d’une Ressource nécessaire est vide ET que l’utilisateur a sélectionné une boisson
        var modulePaiement = new ModuleSansContact();

        var machine = new MachineBuilder()
                .AyantUnModuleDePaiementSansContact(modulePaiement)
                .SansRessource()
                .Build();

        double argentEncaisséInitial = machine.GetArgentEncaissé();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double somme = 0.40;
        // QUAND on appuie sur le bouton CB
        machine.PayerEnCBBanque(somme);

        // ALORS le module est interrogé
        assertTrue(modulePaiement.AEteAppeleAvecLeMontant(0.4));

        // ET un café coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);

        // ET 40cts sont encaissés
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial + 0.40, argentEncaisséFinal);
    }
}
