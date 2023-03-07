//package com.example.machineAcafeTest;
//import com.example.machineAcafeTest.utilities.MachineBuilder;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class ReapproTest {
//    @Test
//    @DisplayName("Etant donné une machine à café, QUAND on appuie sur un bouton ALORS on augmente le stock de dosettes")
//    public void Test_Reappro(){
//        // ETANT DONNE une machine à café
//        Machine machine = new MachineBuilder()
//                .AyantYDosesDeCafe(3)
//                .Build();
//
//        int nombreDosetteInitial = machine.GetCafeEnStock();
//        // QUAND reapprovisionne 1 fois
//        machine.Reappro("cafe");
//
//        // ALORS on augmente le stock de dosettes
//        int nombreDosetteFinal = machine.GetCafeEnStock();
//        assertEquals(nombreDosetteInitial+1, nombreDosetteFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT donnée une machine dont le stock d'une Ressource est plein " +
//                 "QUAND on appuie sur le bouton de reapprovisionnement de cette RESSOURCE " +
//                 "ALORS le stock n'augmente pas")
//    public void Test_Reappro_Plein(){
//        String typeRessource = "cafe";//TODO Faire général
//        //ETANT DONNE une machine dont le stock d'une Ressource est plein
//        Machine machine = new MachineBuilder().AyantStockRessourcesPlein().Build();
//
//        int nombreRessourceInitial = 0;
//        switch (typeRessource){
//            case "cafe" : nombreRessourceInitial = machine.GetCafeEnStock();
//            case "sucre" : nombreRessourceInitial = machine.getNombreSucreMachine();
//            case "gobelet" : nombreRessourceInitial = machine.GetNombreGobelet();
//        }
//        //QUAND on appuie sur le bouton de reapprovisionnement de cette RESSOURCE
//        machine.Reappro(typeRessource);
//
//        //ALORS le stock n'augmente pas
//        int nombreRessourceFinal = 0;
//        switch (typeRessource){
//            case "cafe" : nombreRessourceFinal = machine.GetCafeEnStock();
//            case "sucre" : nombreRessourceFinal = machine.getNombreSucreMachine();
//            case "gobelet" : nombreRessourceFinal = machine.GetNombreGobelet();
//        }
//        assertEquals(nombreRessourceInitial, nombreRessourceFinal);
//
//    }
//
//    @Test
//    @DisplayName("ETANT DONNE une machine dont le stock d'une ressource necessaire est vide" +
//            "ET qu'on appuie sur le bouton de reapprovisionnement de cette ressource" +
//            "QUAND on met 40cts " +
//            "ALORS le café coule")
//    public void Test_Reappro_et_Cafe_Coule(){
//
//    }
//}