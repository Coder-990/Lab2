package main.java.hr.java.covidportal.main;

import main.java.hr.java.covidportal.model.Bolest;
import main.java.hr.java.covidportal.model.Osoba;
import main.java.hr.java.covidportal.model.Simptom;
import main.java.hr.java.covidportal.model.Zupanija;

import java.util.Scanner;

import static main.java.hr.java.covidportal.main.Glavna.*;

public class MetodeZaOdabir {

    protected  static Integer odabirBolestiVirusa(Scanner scan){

        int odabir;

        System.out.print("Unosite li bolest ili virus osobe?\n1) BOLEST\n2) VIRUS\nOdabir: ");
        do{
            odabir = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);
            if(odabir < 1 || odabir > 2) {
                System.out.print("Niste odabrali ni bolest ni virus, ponovite unos: ");
            }
        }while (odabir < 1 || odabir > 2);

        return odabir;
    }

    protected static String odabirVrijednostiBolesti(Scanner scan) {

        do {
            String inputString = scan.nextLine().toUpperCase();
            if ("RIJETKO".equals(inputString) || "SREDNJE".equals(inputString) || "CESTO".equals(inputString)) {
                return inputString;
            } else {
                System.out.print("Unesite jedan od ponudenih odgovora (RIJETKO, SREDNJE ILI CESTO), ponovite unos: ");
            }
        } while (true);
    }

    protected static Simptom odabirSimptoma(Scanner scan, Simptom[] simptomi) {

        int i = 0;

        for (Simptom simptom : simptomi) {
            System.out.println((i += 1) + ". " + simptom.getNaziv() + " - " + simptom.getVrijednost());
        }
        System.out.print("Odabir: ");
        int odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, BROJ_SIMPTOMA);

        return simptomi[odabir - 1];
    }

    protected static Zupanija odabirZupanije(Scanner scan, Zupanija[] zupanije) {

        int i = 0;

        for (Zupanija zupanija : zupanije) {
            System.out.println((i += 1) + ". " + zupanija.getNaziv());
        }
        System.out.print("Odabir: ");
        int odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, BROJ_ZUPANIJA);

        return zupanije[odabir - 1];
    }

    protected static Bolest odabirBolesti(Scanner scan, Bolest[] bolesti) {

        int i = 0;

        for (Bolest bolest : bolesti) {
            System.out.println((i += 1) + ". " + bolest.getNaziv());
        }
        System.out.print("Odabir: ");
        Integer odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, BROJ_BOLESTI);

        return bolesti[odabir - 1];
    }

    protected static Osoba odabirOsobe(Scanner scan, Osoba[] osobe) {

        int i = 0;

        for (Osoba osoba : osobe) {
            if (osoba != null) {
                System.out.println((i += 1) + ". " + osoba.getIme() + " " + osoba.getPrezime());
            }
        }
        System.out.print("Odabir: ");
        Integer odabir = MetodeZaValidaciju.provjeraBrojaSaListe(scan, brojKontaktiranihOsoba(osobe));

        return osobe[odabir - 1];
    }

    protected static Integer brojKontaktiranihOsoba(Osoba[] osobe) {

        Integer brojac = 0;
        for (Osoba osoba : osobe) {
            if (osoba != null) {
                brojac++;
            }
        }
        return brojac;
    }
}
