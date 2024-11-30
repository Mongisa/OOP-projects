package producerconsumer.notthreadsafe;

public class Consumer implements Runnable {
    private final Buffer<String> buffer;
    private final int delay;

    public Consumer(Buffer<String> buffer, int delay) {
        this.buffer = buffer;
        this.delay = delay*1000;
    }

    @Override
    public void run() {
        String element;

        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(delay);

                synchronized (buffer) {
                    while(buffer.isEmpty())
                        buffer.wait();

                    element = buffer.remove();
                    buffer.notifyAll();
                }

            } catch (InterruptedException e) {
                return;
            }

            System.out.println(Thread.currentThread().getName() + " ha letto dal buffer " + element);
        }
    }
}
