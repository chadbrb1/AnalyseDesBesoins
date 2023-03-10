package com.example.machineAcafeTest.recette;


import com.example.machineAcafeTest.Machine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Demo20230103 {
    @Test
    public void DemoCafesAssortis(){
        var machine = new Machine();

        machine.RéapprovisionnerGobelet();
        machine.RéapprovisionnerGobelet();
        machine.RéapprovisionnerGobelet();

        machine.RéapprovisionnerSucre();

        machine.RéapprovisionnerCafé();
        machine.RéapprovisionnerCafé();
        machine.RéapprovisionnerCafé();

        //Café simple
        machine.PayerEnEspece(0.40);

        //Cafés sucrés
        machine.SucrerCafé();
        machine.PayerEnEspece(0.40);

        machine.SucrerCafé();
        machine.PayerEnEspece(0.40);

        // Café simple
        machine.PayerEnEspece(0.40);

        // Café en échec
        machine.PayerEnEspece(0.40);

        assertEquals(4, machine.GetNombreCafésServis());
        assertEquals(0, machine.GetStockSucre());
        assertEquals(1.6, machine.GetArgentEncaissé());
    }
}
