package com.example.machineAcafeTest;

import com.example.machineAcafeTest.Machine;
import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TouillettesTest {
    @Test
    @DisplayName("ETANT DONNE une machine ayant un stock de touillettes vide " +
            "QUAND l'utilisateur paie pour un café avec du sucre " +
            "ALORS le café est servie, mais sans touillette")
    public void Cafe_Sucre_Sans_Touillette(){
        // ETANT DONNE une machine ayant un stock de touillettes vide
        Machine machine = new MachineBuilder()
                .SansTouillette()
                .Build();

        int stockTouillettesInitial = machine.GetStockTouillettes();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();

        // QUAND l'utilisateur paie pour un café avec du sucre
        machine.PayerEnEspece(0.40);
        machine.SucrerCafé();

        // ALORS le café est servi, mais sans touillette
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);

        int stockTouillettesFinal = machine.GetStockTouillettes();
        assertEquals(stockTouillettesInitial, stockTouillettesFinal);
    }

    @Test
    @DisplayName("ETANT DONNE une machine" +
            "QUAND l'utilisateur paie pour un café avec du sucre" +
            "ALORS le café est servi avec une touillette")
    public void Sers_cafe_avec_sucre_avec_touillette_(){
        // ETANT DONNE une machine
        Machine machine = new MachineBuilder()
                .Build();

        double sommeInsérée = 0.40;

        int stockTouilletteInitial = machine.GetStockTouillettes();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();

        // QUAND l'utilisateur paie pour un café avec du sucre
        machine.SucrerCafé();
        machine.PayerEnEspece(sommeInsérée);

        // ALORS le café est servi avec une touillette
        double stockTouilletteFinal = machine.GetStockTouillettes();
        assertEquals(stockTouilletteInitial - 1, stockTouilletteFinal);
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);
    }

    @Test
    @DisplayName("ETANT DONNE  une machine avec le stock de sucre vide" +
            "quand l'utilisateur paie pour une boisson avec du sucre " +
            "ALORS aucune boisson ne coule " )
    public void Stock_sucre_vide(){
        // ETANT DONNE une machine avec le stock de sucre vide
        Machine machine = new MachineBuilder().SansSucre().Build();
        int nombreCaféInitiaux = machine.GetNombreCafésServis();
        double argentEncaisséInitial = machine.GetArgentEncaissé();

        // quand l'utilisateur paie pour une boisson avec du sucre

        double sommeInsérée = 0.40;
        machine.SucrerCafé();
        machine.PayerEnEspece(sommeInsérée);

        // ALORS aucun café ne coule
        int nombreCafésFinaux = machine.GetNombreCafésServis();
        assertEquals(nombreCaféInitiaux, nombreCafésFinaux);


    }
}
