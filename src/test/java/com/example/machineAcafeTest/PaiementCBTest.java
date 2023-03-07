//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import utilities.MachineBuilder;
//import machineacafe.Machine;
//import utilities.ModulePaiementMock;
//import utilities.ModulePaiementSpy;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class PaiementCBTest {
//    @Test
//    @DisplayName("ETANT DONNÉ une machine" +
//            "ET que l’utilisateur a sélectionné une boisson" +
//            "QUAND l’utilisateur paye en CB" +
//            "ET que le paiement est refusé au niveau de la banque " +
//            "ALORS aucune boisson ne coule" +
//    "ET la somme demandée à la banque est bien celle correspondante à la boisson ")
//    public void TestPaiementRefuse(){
//        // ETANT DONNE une machine dont le stock d’une Ressource nécessaire est vide ET que l’utilisateur a sélectionné une boisson
//        var modulePaiement = new ModulePaiementSpy(new ModulePaiementMock(false));
//
//        var machine = new MachineBuilder()
//                .AyantUnModuleDePaiement(modulePaiement)
//                .Build();
//
//        double argentEncaisséInitial = machine.GetArgentEncaissé();
//        int nombreCaféInitiaux = machine.GetNombreCafésServis();
//        double somme = 0.40;
//        // QUAND on appuie sur le bouton CB
//        machine.PayerEnCBBanque(somme);
//
//        // ALORS le module est interrogé
//        assertTrue(modulePaiement.AEteAppeleAvecLeMontant(0.4));
//
//        // ET un café coule
//        int nombreCafésFinaux = machine.GetNombreCafésServis();
//        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);
//
//        // ET 40cts sont encaissés
//        double argentEncaisséFinal = machine.GetArgentEncaissé();
//        assertEquals(argentEncaisséInitial + 0.40, argentEncaisséFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNÉ une machine dont le stock d’une Ressource nécessaire est vide" +
//            "ET que l’utilisateur a sélectionné une boisson" +
//            "QUAND l’utilisateur paye en CB " +
//            "ALORS aucune boisson ne coule" +
//            "ET le paiement est annulé")
//    public void TestRessourceNecessaireVide(){
//        // ETANT DONNE une machine dont le stock d’une Ressource nécessaire est vide ET que l’utilisateur a sélectionné une boisson
//        var modulePaiement = new ModulePaiementSpy(new ModulePaiementMock(false));
//
//        var machine = new MachineBuilder()
//                .AyantUnModuleDePaiement(modulePaiement)
//                .Build();
//
//        double argentEncaisséInitial = machine.GetArgentEncaissé();
//        int nombreCaféInitiaux = machine.GetNombreCafésServis();
//        double somme = 0.40;
//        // QUAND on appuie sur le bouton CB
//        machine.PayerEnCBBanque(somme);
//
//        // ALORS le module est interrogé
//        assertTrue(modulePaiement.AEteAppeleAvecLeMontant(0.4));
//
//        // ET un café coule
//        int nombreCafésFinaux = machine.GetNombreCafésServis();
//        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);
//
//        // ET 40cts sont encaissés
//        double argentEncaisséFinal = machine.GetArgentEncaissé();
//        assertEquals(argentEncaisséInitial + 0.40, argentEncaisséFinal);
//    }
//
//    @Test
//    @DisplayName("ETANT DONNÉ une machine dont le stock d’une Ressource nécessaire est vide" +
//            "ET que l’utilisateur a sélectionné une boisson" +
//            "QUAND l’utilisateur paye en CB " +
//            "ALORS aucune boisson ne coule" +
//            "ET le paiement est annulé")
//    public void TestPaiementValide(){
//        // ETANT DONNE une machine dont le stock d’une Ressource nécessaire est vide ET que l’utilisateur a sélectionné une boisson
//        var modulePaiement = new ModulePaiementSpy(new ModulePaiementMock(false));
//
//        var machine = new MachineBuilder()
//                .AyantUnModuleDePaiement(modulePaiement)
//                .Build();
//
//        double argentEncaisséInitial = machine.GetArgentEncaissé();
//        int nombreCaféInitiaux = machine.GetNombreCafésServis();
//        double somme = 0.40;
//        // QUAND on appuie sur le bouton CB
//        machine.PayerEnCBBanque(somme);
//
//        // ALORS le module est interrogé
//        assertTrue(modulePaiement.AEteAppeleAvecLeMontant(0.4));
//
//        // ET un café coule
//        int nombreCafésFinaux = machine.GetNombreCafésServis();
//        assertEquals(nombreCaféInitiaux + 1, nombreCafésFinaux);
//
//        // ET 40cts sont encaissés
//        double argentEncaisséFinal = machine.GetArgentEncaissé();
//        assertEquals(argentEncaisséInitial + 0.40, argentEncaisséFinal);
//    }
//}
