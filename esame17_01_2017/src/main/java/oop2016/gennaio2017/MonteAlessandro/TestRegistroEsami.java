/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop2016.gennaio2017.MonteAlessandro;

import java.util.Scanner;

/**
 *
 * @author Gennaro
 */
public class TestRegistroEsami {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, DataNonValidaException, CodiceNonValidoException, VotoNonValidoException {

        Scanner in = new Scanner(System.in);
        String scelta;
        RegistroEsami r;

        // Inizializzazione registro
        do {
            System.out.println("Vuoi caricare il registro esami da file? (S/N) ");
            scelta = in.next();
        } while (!scelta.matches("[SNsn]"));
        if (scelta.matches("[Ss]")) {
            if ((r = RegistroEsamiUtils.caricaDaFileBinario("Backup.dat")) == null) {
                System.err.println("Impossibile leggere da file");
                System.exit(-1);
            }else{
                System.out.println("Caricamento effettuato correttamente\nSono stati caricati " + r.keySet().size() + " libretti");
            }
        } else {
            r = new RegistroEsami();
            System.out.println("Istanziato nuovo registro ");
        }

        // Avvio thread di salvataggio automatico
        new Thread(new SalvataggioAutomatico("Backup.dat", r)).start();

        synchronized (r) {
            r.put("0612703123", new Libretto(new Studente("Marco", "Rossi", "0612703123")));
            System.out.println("Aggiunto Studente con matricola 0612703123");
            System.out.println(r);
            r.notifyAll();
        }
        Thread.sleep(3000);
        synchronized (r) {
            r.put("0612701234", new Libretto(new Studente("Lucia", "Bianchi", "0612701234")));
            r.aggiungiEsame("0612701234", Esame.crea("Programmazione ad Oggetti", 9, 1, 2017, 28, "0612700009"));
            System.out.println("Aggiunto Studente con matricola 0612701234");
            System.out.println(r);
            r.notifyAll();
        }
        Thread.sleep(3000);
        synchronized (r) {
            r.put("0612707654", new Libretto(new Studente("Elena", "Verdi", "0612707654")));
            r.aggiungiEsame("0612707654", Esame.crea("Programmazione ad Oggetti", 10, 1, 2017, 31, "0612700009"));
            r.aggiungiEsame("0612707654", Esame.crea("Matematica I", 10, 10, 2016, 21, "0612700005"));
            r.aggiungiEsame("0612707654", Esame.crea("Matematica II", 10, 12, 2016, 25, "0612700007"));
            System.out.println("Aggiunto Studente con matricola 0612707654");
            System.out.println(r);
            r.notifyAll();
        }
        Thread.sleep(3000);
        synchronized (r) {
            r.put("0612710134", new Libretto(new Studente("Lucia", "Bianchi", "0612710134")));
            r.aggiungiEsame("0612710134", Esame.crea("Programmazione ad Oggetti", 5, 1, 2017, 25, "0612700009"));
            System.out.println("Aggiunto Studente con matricola 0612710134");
            System.out.println(r);
            r.notifyAll();
        }
        Thread.sleep(3000);

    
    
    }

}
