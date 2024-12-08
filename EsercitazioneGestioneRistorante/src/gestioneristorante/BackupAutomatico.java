package gestioneristorante;

public class BackupAutomatico implements Runnable {
    private final Comande comande;

    public BackupAutomatico(Comande comande) {
        this.comande = comande;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                this.comande.salvaOrdinazioni();
                System.out.println("BACKUP EFFETTUATO");
                Thread.sleep(20*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
