package com.example.machineAcafeTest;
import com.example.machineAcafeTest.utilities.MachineBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ReapproTest {
    @Test
    @DisplayName("Etant donné une machine à café, QUAND on appuie sur un bouton ALORS on augmente le stock de dosettes")
    public void Test_Reappro(){
        // ETANT DONNE une machine à café
        Machine machine = new MachineBuilder()
                .AyantYDosesDeCafe(3)
                .Build();

        int nombreDosetteInitial = machine.GetCafeEnStock();
        // QUAND reapprovisionne 1 fois
        machine.Reappro();

        // ALORS on augmente le stock de dosettes
        int nombreDosetteFinal = machine.GetCafeEnStock();
        assertEquals(nombreDosetteInitial+1, nombreDosetteFinal);
    }

    @Test
    @DisplayName("ETANT donnée une machine dont le stock d'une Ressource est plein " +
                 "QUAND on appuie sur le bouton de reapprovisionnement de cette RESSOURCE " +
                 "ALORS le stock n'augmente pas")
    public void Test_Reappro_Plein(){
        //ETANT DONNE une machine dont le stock d'une Ressource est plein
        Machine machine = new MachineBuilder().AyantStockRessourcesPlein().Build();


        //QUAND on appuie sur le bouton de reapprovisionnement de cette RESSOURCE
        machine.Reappro();


        //ALORS le stock n'augmente pas

    }

    @Test
    @DisplayName("ETANT DONNE une machine dont le stock d'une ressource necessaire est vide" +
            "ET qu'on appuie sur le bouton de reapprovisionnement de cette ressource" +
            "QUAND on met 40cts " +
            "ALORS le café coule")
    public void Test_Reappro_et_Cafe_Coule(){

    }
}