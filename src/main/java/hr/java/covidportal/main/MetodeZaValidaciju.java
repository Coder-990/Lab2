package main.java.hr.java.covidportal.main;


import java.util.Scanner;
import java.util.regex.Pattern;

public class MetodeZaValidaciju {

    protected static String provjeraPraznogStringaBroja(Scanner scan){

        String inputString;
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        do{
            inputString = scan.nextLine().trim();
            if(inputString.isBlank() || pattern.matcher(inputString).matches()){
                System.out.print("Pokusali ste unijeti prazan string ili broj, ponovite unos: ");
            }
        }while (inputString.isBlank() || pattern.matcher(inputString).matches());

        return inputString;
    }

    protected static Integer provjeraNegativnogIntegera(Scanner scan){
        int inputInt;

        do{
            inputInt = scan.nextInt();
            scan.nextLine();
            if(inputInt < 0 || inputInt == 0){
                System.out.print("Pokusali ste unijeti negativan broj, ponovite unos: ");
            }
        }while (inputInt < 0 || inputInt == 0);

        return inputInt;
    }

    protected static Integer provjeraUnosSimptomaBrojKontaktiranih(Scanner scan) {

        int odabir;
        do {
            odabir = scan.nextInt();
            scan.nextLine();
            if (odabir < 0) {
                System.out.print("Unos moze biti nula, jedan ili vise, ponovite unos: ");
            }
        } while (odabir < 0);

        return odabir;
    }

    protected  static Integer provjeraBrojaSaListe(Scanner scan, Integer granica){

        int odabir;
        do {
            odabir = MetodeZaValidaciju.provjeraNegativnogIntegera(scan);
            if(odabir < 0 || odabir > granica)
                System.out.print("Odabir mora biti redni broj sa ponudene liste, ponovite unos: ");
        }while (odabir < 0 || odabir > granica);

        return odabir;
    }
}
