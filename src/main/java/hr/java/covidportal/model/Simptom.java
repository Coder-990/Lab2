package main.java.hr.java.covidportal.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Simptom extends ImenovaniEntitet{

    String vrijednost;

    public Simptom(String naziv, String vrijednost) {
        super(naziv);
        this.naziv = naziv;
        this.vrijednost = vrijednost;
    }
/*
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrijednost() {
        return vrijednost;
    }

    public void setVrijednost(String vrijednost) {
        this.vrijednost = vrijednost;
    }

     */

}
