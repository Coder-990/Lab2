package main.java.hr.java.covidportal.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Bolest extends ImenovaniEntitet {

    Simptom[] simptomi;

    public Bolest(String naziv, Simptom[] simptomi) {
        super(naziv);
        this.naziv = naziv;
        this.simptomi = simptomi;
    }
/*
    public Simptom[] getSimptomi() {
        return simptomi;
    }

    public void setSimptomi(Simptom[] simptomi) {
        this.simptomi = simptomi;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


 */
}
