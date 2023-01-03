package com.example.machineAcafeTest;
import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PenuriesTest {
    @Test
    @DisplayName("ETANT DONNE une machine n'ayant plus d'eau " +
            "QUAND on met 40cts " +
            "ALORS aucun cafe ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Eau(){
        // ETANT DONNE une machine n'ayant plus d'eau
        Machine machine = MachineBuilder.Default();
        machine.CouperEau();

        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();
        boolean sucre = false ;
        // QUAND on met 40cts
        machine.Inserer(0.40,sucre);

        // ALORS aucun cafe ne coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);

        // ET l'argent est rendu
        double argentEncaisseFinal = machine.GetArgentEncaisse();
        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de gobelets " +
            "QUAND on met 40cts " +
            "ALORS aucun cafe ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Gobelet(){
        // ETANT DONNE une machine n'ayant pas de gobelets
        Machine machine = new MachineBuilder()
                .SansGobelets()
                .Build();

        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();
        boolean sucre = false ;
        // QUAND on met 40cts
        machine.Inserer(0.40,sucre);

        // ALORS aucun cafe ne coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);

        // ET l'argent est rendu
        double argentEncaisseFinal = machine.GetArgentEncaisse();
        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine n'ayant pas de cafe " +
            "QUAND on met 40cts " +
            "ALORS aucun cafe ne coule " +
            "ET l'argent est rendu")
    public void Test_Sans_Cafe(){
        // ETANT DONNE une machine n'ayant pas de cafe
        Machine machine = new MachineBuilder()
                .SansCafe()
                .Build();

        int nombreCafeInitiaux = machine.GetNombreCafesServis();
        double argentEncaisseInitial = machine.GetArgentEncaisse();
        boolean sucre = false ;
        // QUAND on met 40cts
        machine.Inserer(0.40,sucre);

        // ALORS aucun cafe ne coule
        int nombreCafesFinaux = machine.GetNombreCafesServis();
        assertEquals(nombreCafeInitiaux, nombreCafesFinaux);

        // ET l'argent est rendu
        double argentEncaisseFinal = machine.GetArgentEncaisse();
        assertEquals(argentEncaisseInitial, argentEncaisseFinal);
    }
}