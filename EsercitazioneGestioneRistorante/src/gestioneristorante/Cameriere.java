package gestioneristorante;

import java.util.Random;

public class Cameriere implements Runnable {
    private final Comande comande;
    private final String nome;

    public Cameriere(String nome, Comande comande) {
        this.comande = comande;
        this.nome = nome;
    }

    @Override
    public void run() {
        Random random = new Random(100);
        Menu menu = new Menu();

        while(!Thread.currentThread().isInterrupted()) {
            int tavolo = random.nextInt(5)+1;
            int quantita = random.nextInt(4)+1;
            int delay = random.nextInt(6)+5;
            String piatto = menu.getPiatto();

            try {
                Thread.sleep(delay*1000);
                Ordinazione o = new Ordinazione(piatto,tavolo,quantita);
                this.comande.aggiungiOrdinazione(o);
                System.out.println("Ordinazione presa da " + nome + ": " + o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
