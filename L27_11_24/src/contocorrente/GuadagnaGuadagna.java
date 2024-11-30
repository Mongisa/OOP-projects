package contocorrente;

import java.util.Random;

public class GuadagnaGuadagna implements Runnable {
    private final ContoCorrente c;

    public GuadagnaGuadagna(ContoCorrente c) {
        this.c = c;
    }

    @Override
    public void run() {
        Random n = new Random(23400);

        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                //Questa eccezione viene lanciata se voglio interrompere il thread
                //mentre è a riposo

                //Per interrompere il thread anche quando è a riposo
                return;
            }

            double versamento = (n.nextInt(19)+1)*50;

            synchronized (c) {
                c.versa(versamento);
                System.out.println(Thread.currentThread().getName() + " ha versato: " + versamento + ", nuovo saldo: " + c.getSaldo());
            }
        }
    }
}
