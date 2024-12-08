package gestioneristorante;

import java.util.Random;

public class Cuoco implements Runnable {
    private final Comande comande;

    public Cuoco(Comande comande) {
        this.comande = comande;
    }

    @Override
    public void run() {
        Random random = new Random(150);
        while(!Thread.currentThread().isInterrupted()) {
            int delay = random.nextInt(6)+5;
            try {
                Ordinazione o = this.comande.consegnaOrdinazione();
                Thread.sleep(delay*1000);
                System.out.println("Piatto pronto: " + o);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
