package main.java.hr.java.covidportal.model;

import lombok.Data;

import java.util.Arrays;
import java.util.Optional;

@Data
public class Osoba {

    String ime, prezime;
    Integer starost;
    Zupanija zupanija;
    Bolest zarazenBolescu;
    Osoba[] kontaktiraneOsobe;

//    public Osoba(String ime, String prezime, Integer starost, Zupanija zupanija, Bolest zarazenBolescu, Osoba[] kontaktiraneOsobe) {
//        this.ime = ime;
//        this.prezime = prezime;
//        this.starost = starost;
//        this.zupanija = zupanija;
//        this.zarazenBolescu = zarazenBolescu;
//        this.kontaktiraneOsobe = kontaktiraneOsobe;
//
//        if(this.zarazenBolescu instanceof Virus virus){
//            for (Osoba osb:kontaktiraneOsobe){
//                virus.prelazakZarazeNaOsobu(osb);
//            }
//        }
//    }

    public static class Builder {

        private String ime, prezime;
        private Integer starost;
        private Zupanija zupanija;
        private Bolest zarazenBolescu;
        private Osoba[] kontaktiraneOsobe;

        public Builder ime(String ime) {
            this.ime = ime;
            return this;
        }

        public Builder prezime(String prezime) {
            this.prezime = prezime;
            return this;
        }

        public Builder starost(Integer starost) {
            this.starost = starost;
            return this;
        }

        public Builder zupanija(Zupanija zupanija) {
            this.zupanija = zupanija;
            return this;
        }

        public Builder zarazenBolescu(Bolest zarazenBolescu) {
            this.zarazenBolescu = zarazenBolescu;
            return this;
        }

        public Builder kontaktiraneOsobe(Osoba[] kontaktiraneOsobe) {
            this.kontaktiraneOsobe = kontaktiraneOsobe;
            return this;
        }

        public Osoba build() {
            Osoba osoba = new Osoba();
            osoba.ime = this.ime;
            osoba.prezime = this.prezime;
            osoba.starost = this.starost;
            osoba.zupanija = this.zupanija;
            osoba.zarazenBolescu = this.zarazenBolescu;
            osoba.kontaktiraneOsobe = this.kontaktiraneOsobe;

            if (Optional.ofNullable(osoba.kontaktiraneOsobe).isPresent() && this.zarazenBolescu instanceof Virus virus) {
                for (Osoba osb : kontaktiraneOsobe) {
                    virus.prelazakZarazeNaOsobu(osb);
                }
            }
            return osoba;
        }
    }

        @Override
        public String toString() {
            String kontaktOsoba = (Optional.ofNullable(kontaktiraneOsobe).isPresent() && kontaktiraneOsobe.length > 0) ? Arrays.toString(kontaktiraneOsobe) : "Nema kontaktiranih osoba.";
            return "Osoba: " +
                    "\nIme i prezime = " + ime + " " + prezime +
                    "\nStarost = " + starost +
                    "\nZupanija prebivalista = " + zupanija.getNaziv() +
                    "\nZarazen bolescu = " + zarazenBolescu.getNaziv() +
                    "\nKontaktiraneOsobe:\n" + kontaktOsoba + "\n";
        }
/*
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Integer getStarost() {
        return starost;
    }

    public void setStarost(Integer starost) {
        this.starost = starost;
    }

    public Zupanija getZupanija() {
        return zupanija;
    }

    public void setZupanija(Zupanija zupanija) {
        this.zupanija = zupanija;
    }

    public Bolest getZarazenBolescu() {
        return zarazenBolescu;
    }

    public void setZarazenBolescu(Bolest zarazenBolescu) {
        this.zarazenBolescu = zarazenBolescu;
    }

    public Osoba[] getKontaktiraneOsobe() {
        return kontaktiraneOsobe;
    }

    public void setKontaktiraneOsobe(Osoba[] kontaktiraneOsobe) {
        this.kontaktiraneOsobe = kontaktiraneOsobe;
    }

 */

}
