package com.example.machineAcafeTest;

import com.example.machineAcafeTest.Machine;
import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class PrixVariableTest {
    @Test
    @DisplayName("ETANT DONNE une machine " +
            "QUAND l'utilisateur choisi une des boissons " +
            "ET qu'il paie le prix associé " +
            "ALORS la boisson est servie")
    public void Paie_prix_associe(){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        String nomBoisson = "Café";
        Double prixBoisson = machine.ChoisirBoisson(nomBoisson);
        double sommeInsérée = 0.40;


        int nombreCaféInitiaux = machine.GetNombreCafésServis();

        // QUAND l'utilisateur choisi une des boissons ET qu'il paie le prix associé
        machine.PayerEnEspece(sommeInsérée);

        // ALORS la boisson est servie
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        // Un café a bien été servi
        assertEquals(nombreCaféInitiaux +1 , nombreCafésFinaux);
        assertEquals(sommeInsérée, prixBoisson);
    }

    @Test
    @DisplayName("ETANT DONNE une machine" +
            "QUAND l'utilisateur choisi une des boissons" +
            "Et qu'il paie avec des pièces" +
            "ET qu'il paie plus que le que le prix associé" +
            "Alors la boisson est servie " +
            "Et le surplus de monnaie est rendu ")
    public void Paie_plus_que_le_prix_associe(){
        // ETANT DONNE une machine
        Machine machine = new MachineBuilder()
                .Build();

        String nomBoisson = "Café";
        double prixBoisson = machine.ChoisirBoisson(nomBoisson);
        double sommeInsérée = 0.80;

        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        // ET l'argent du second café est rendu
        double argentEncaisséInitial = machine.GetArgentEncaissé();
        // QUAND on insère 80 cts
        machine.PayerEnEspece(sommeInsérée);

        // Alors la boisson est servie
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);

        // Et le surplus de monnaie est rendu
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertNotEquals(sommeInsérée,prixBoisson);
        assertEquals(argentEncaisséInitial + sommeInsérée, argentEncaisséFinal);
    }


    @Test
    @DisplayName("ETANT DONNE une machine" +
            "QUAND l'utilisateur choisi une des boissons" +
            "ET qu'il paie avec des pièces" +
            "ET qu'il paie moins que le prix associé" +
            "ALORS la boisson n'est pas servie" +
            "ET aucun argent n'est encaissé")
    public void Paie_moins_que_le_prix_associe(){
        // ETANT DONNE une machine
        Machine machine = new MachineBuilder()
                .AyantXGobelets(100)
                .AyantYDosesDeCafé(100)
                .Build();

        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();
        double sommeInsérée = 0.30;
        String nomBoisson = "Café";
        double prixBoisson = 0.40;

        // QUAND l'utilisateur choisi une des boissons
        machine.ChoisirBoisson(nomBoisson);

        // ET qu'il paie avec des pièces
        // ET qu'il paie moins que le prix associé
        machine.PayerEnEspece(sommeInsérée);


        // ALORS la boisson n'est pas servie
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);

        // ET aucun argent n'est encaissé
        double argentEncaisséFinal = machine.GetArgentEncaissé();
        assertEquals(argentEncaisséInitial, argentEncaisséFinal);
        assertNotEquals(sommeInsérée, prixBoisson);
    }
}

