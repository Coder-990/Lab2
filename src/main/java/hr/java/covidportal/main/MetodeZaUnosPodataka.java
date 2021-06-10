package main.java.hr.java.covidportal.main;

import main.java.hr.java.covidportal.model.*;

import java.util.Scanner;

public class MetodeZaUnosPodataka {

    protected static Zupanija unosZupanije(Scanner scan, int i) {

        System.out.print("Unesite naziv " + (i + 1) + ". zupanije: ");
        String nazivZupanije = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite broj stanovnika za " + (i + 1) + ". zupaniju: ");
        Integer brojStanovnika = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);

        return new Zupanija(nazivZupanije, brojStanovnika);
    }

    protected static Simptom unosSimptoma(Scanner scan, int i) {

        System.out.print("Unesite naziv " + (i + 1) + ". simptoma: ");
        String nazivSimptoma = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite vrijednost " + (i + 1) + ". simptoma (RIJETKO, SREDNJE ILI CESTO): ");
        String vrijednostSimptoma = MetodeZaOdabir.odabirVrijednostiBolesti(scan);

        return new Simptom(nazivSimptoma, vrijednostSimptoma);
    }

    protected static Bolest unosBolesti(Scanner scan, Simptom[] simptomi, int i) {

        Integer odabirVirusaBolesti = MetodeZaOdabir.odabirBolestiVirusa(scan);
        System.out.print("Unesite naziv " + (i + 1) + ". bolesti ili virusa: ");
        String nazivBolesti = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite broj simptoma: ");
        Integer brojSimptoma = MetodeZaValidaciju.provjeraUnosSimptomaBrojKontaktiranih(scan);
        Simptom[] simptomBolesti = new Simptom[brojSimptoma];
        for (int j = 0; j < brojSimptoma; j++) {
            System.out.println("Odaberite " + (j + 1) + ". simptom: ");
            simptomBolesti[j] = MetodeZaOdabir.odabirSimptoma(scan, simptomi);
        }
        if (odabirVirusaBolesti == 1) {
            return new Bolest(nazivBolesti, simptomBolesti);
        } else {
            return new Virus(nazivBolesti, simptomBolesti);
        }
    }

    protected static Osoba unosOsobe(Scanner scan, Zupanija[] zupanije, Bolest[] bolesti, Osoba[] osobe, int i) {

        System.out.print("Unesite ime " + (i + 1) + ". osobe: ");
        String imeOsobe = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite prezime " + (i + 1) + ". osobe: ");
        String prezimeOsobe = MetodeZaValidaciju.provjeraPraznogStringaBroja(scan);
        System.out.print("Unesite starost " + (i + 1) + ". osobe: ");
        Integer starostOsobe = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);
        System.out.println("Odaberite zupaniju prebivalista " + (i + 1) + " osobe: ");
        Zupanija prebivalisteOsobe = MetodeZaOdabir.odabirZupanije(scan, zupanije);
        System.out.println("Odaberite bolest " + (i + 1) + " osobe :");
        Bolest bolestOsobe = MetodeZaOdabir.odabirBolesti(scan, bolesti);
        Osoba osoba = new Osoba.Builder()
                .ime(imeOsobe)
                .prezime(prezimeOsobe)
                .starost(starostOsobe)
                .zupanija(prebivalisteOsobe)
                .zarazenBolescu(bolestOsobe)
                .build();
        if (i > 0) {
            return unosKontaktiraneOsobe(scan, osobe, osoba);
        }
        return osoba;
    }

    protected static Osoba unosKontaktiraneOsobe(Scanner scan, Osoba[] osobe, Osoba osoba) {

        System.out.print("Unesite broj osoba koje su bile u kontaktu s tom osobom: ");
        Integer kontaktBrojOsobaSaPrvimZarazenim = MetodeZaValidaciju.provjeraUnosSimptomaBrojKontaktiranih(scan);
        Osoba[] kontaktiranaOsoba = new Osoba[kontaktBrojOsobaSaPrvimZarazenim];
        System.out.println("Odaberite osobe koje su bile u kontaktu  s tom osobom :");
        for (int i = 0; i < kontaktBrojOsobaSaPrvimZarazenim; i++) {
            kontaktiranaOsoba[i] = MetodeZaOdabir.odabirOsobe(scan, osobe);
        }
        return new Osoba.Builder()
                .ime(osoba.getIme())
                .prezime(osoba.getPrezime())
                .starost(osoba.getStarost())
                .zupanija(osoba.getZupanija())
                .zarazenBolescu(osoba.getZarazenBolescu())
                .kontaktiraneOsobe(kontaktiranaOsoba)
                .build();
    }
}
