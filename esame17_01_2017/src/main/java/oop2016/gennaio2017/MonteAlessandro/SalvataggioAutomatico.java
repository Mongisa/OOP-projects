package oop2016.gennaio2017.MonteAlessandro;

public class SalvataggioAutomatico implements Runnable {
    private final String filename;
    private final RegistroEsami registro;

    public SalvataggioAutomatico(String filename, RegistroEsami registro) {
        this.filename = filename;
        this.registro = registro;
    }

    @Override
    public void run() {

        while(!Thread.currentThread().isInterrupted()) {
            try {
                synchronized (registro) {
                    registro.wait();

                    boolean r = RegistroEsamiUtils.salvaSuFileBinario(filename, registro);
                    if (r) {
                        System.out.println("BACKUP EFFETTUATO CON SUCCESSO");
                    } else {
                        System.err.println("ERRORE SALVATAGGIO");
                    }
                    registro.notifyAll();
                }
            } catch(InterruptedException e) {
                return;
            }
        }
    }
}
