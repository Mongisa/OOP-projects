package esercitazione11_10_24;

// QUESTO FILE NON VA MODIFICATO

import it.unisa.diem.oop.veicoli.Moto;
import it.unisa.diem.oop.veicoli.Camion;
import it.unisa.diem.oop.veicoli.Autovettura;
import it.unisa.diem.oop.veicoli.BoxException;
import it.unisa.diem.oop.veicoli.AutorimessaVuotaException;


public class TestRimessa {

    public static void main(String[] args) {
        Autorimessa autorimessa = new Autorimessa(2, "Parcheggio E1");

        try {
            autorimessa.esce();
        } catch(AutorimessaVuotaException e) {
            System.err.println(e);
        }
       
        try {
            autorimessa.entra(new Camion("sdf244", "Fiat CX45", "Gasolio", "TT656671", 4));
        } catch (BoxException ex) {
            System.err.println(ex);
        }
        try {
            autorimessa.entra(new Camion("spl265", "Volvo PTG", "Gasolio", "YH96671", 6));
        } catch (BoxException ex) {
            System.err.println(ex);
        }
        try {
            autorimessa.entra(new Autovettura("mk23t", "Fiat Punto", "Metano", "EA566FM", 5));
        } catch (BoxException ex) {
            System.err.println(ex);
        }
        try {
            autorimessa.entra(new Autovettura("cgt612", "Fiat Idea", "Gasolio", "AQ9Y7UUU", 5));
        } catch (BoxException ex) {
            System.err.println(ex);
        }
        try {
            autorimessa.entra(new Moto("das7896", "Honda Hornet", "Benzina", "AT51233", false));
        } catch (BoxException ex) {
            System.err.println(ex);
        }
        try {
            autorimessa.entra(new Moto("gdt7896", "Suzuki Bandit", "Benzina", "AT5123N", false));
        } catch (BoxException ex) {
            System.err.println(ex);
        }
        
        System.out.println(autorimessa);

    }

}
