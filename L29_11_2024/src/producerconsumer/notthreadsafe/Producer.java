package producerconsumer.notthreadsafe;

import java.util.Random;

public class Producer implements Runnable {
    private final Buffer<String> buffer;
    private final int delay;

    public Producer(Buffer<String> buffer, int delay) {
        this.buffer = buffer;
        this.delay = delay*1000;
    }

    @Override
    public void run() {
        Random p = new Random(2300);

        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(delay);

                synchronized (buffer) {
                    while(buffer.isFull())
                        buffer.wait();

                    buffer.add("Info " + p.nextInt(10));
                    buffer.notifyAll();
                }
            } catch (InterruptedException e) {
                return;
            }

            System.out.println(Thread.currentThread().getName() + " ha aggiornato il buffer");
        }
    }
}
