package com.example.machineAcafeTest;

import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SucreTest {
    @Test
    @DisplayName("ETANT DONNE une machine n'ayant plus de sucre " +
            "ET un appui sur le bouton sucre" +
            "QUAND on insère 40 cts " +
            "ALORS aucun café ne coule " +
            "ET l'argent est remboursé")
    public void Test_Pas_De_Cafe_Si_Plus_De_Suce(){
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
    @DisplayName("ETANT DONNE une machine ET un appui sur le bouton sucre QUAND on met 40cts ALORS un cafe coule ET une dose de sucre est consommée")
    public void Test_Cafe_Coule_Avec_Sucre(){
        // ETANT DONNE une machine
        Machine machine = MachineBuilder.Default();
        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();

        //ET un appui sur le bouton sucre
        boolean sucre = true ;
        int qte_sucre_initiale = machine.getNombreSucreMachine();

        // QUAND on met 40cts
        double sommeInseree = 0.40;
        machine.Inserer(sommeInseree,sucre);

        // ALORS un cafe coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux + 1, nombreCafesFinaux);

        // ET une dose de sucre est consommée
        int qte_sucre_finale = machine.getNombreSucreMachine();
        assertEquals(qte_sucre_initiale-1, qte_sucre_finale);
    }
}
