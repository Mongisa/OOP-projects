package esame2016;

import java.io.IOException;

public class ThreadSalvataggioAutomatico implements Runnable {
    private final SerializableContiCorrentiClienti scc;
    private final String filename;
    private final int savePeriod;

    public ThreadSalvataggioAutomatico(SerializableContiCorrentiClienti scc, String filename, int savePeriod) {
        this.scc = scc;
        this.filename = filename;
        this.savePeriod = savePeriod*1000;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                synchronized(scc) {
                    scc.wait();
                    scc.save(filename);
                }
                System.out.println("BACKUP EFFETTUATO");
            } catch (InterruptedException e) {
                return;
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
