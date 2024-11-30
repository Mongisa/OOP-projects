package contocorrente;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ContoCorrente c = new ContoCorrente(1000);

        Thread t1 = new Thread(new GuadagnaGuadagna(c));
        Thread t2 = new Thread(new SpendiSpendi(c));

        t1.setName("GuadagnaGuadagna");
        t2.setName("SpendiSpendi");

        t1.start();
        t2.start();

        //Attesa di 15s
        Thread.sleep(15*1000);

        t1.interrupt();
        t2.interrupt();
    }
}
