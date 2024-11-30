package producerconsumer.notthreadsafe;

public class TestNotThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        Buffer<String> buffer = new Buffer<>(5);

        Producer producer = new Producer(buffer,2);

        Consumer consumer1 = new Consumer(buffer,1);
        Consumer consumer2 = new Consumer(buffer,1);

        Thread t1 = new Thread(producer,"Producer");
        Thread t2 = new Thread(consumer1,"Consumer1");
        Thread t3 = new Thread(consumer2,"Consumer2");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(25*1000);

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
    }
}
