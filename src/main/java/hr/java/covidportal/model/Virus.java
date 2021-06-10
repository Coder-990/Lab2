package main.java.hr.java.covidportal.model;

import lombok.Data;

@Data
public class Virus extends Bolest implements Zarazno{

    public Virus(String naziv, Simptom[] simptomi) {
        super(naziv, simptomi);
    }

    public void prelazakZarazeNaOsobu(Osoba osoba) {

        osoba.setZarazenBolescu(this);
    }
}
