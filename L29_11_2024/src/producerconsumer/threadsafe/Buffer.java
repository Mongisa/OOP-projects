package producerconsumer.threadsafe;

import java.util.LinkedList;
import java.util.Queue;

//La sincronizzazione è gestita sulla risorsa
public class Buffer<E> {
    private final int size;
    private final Queue<E> buffer;

    public Buffer(int size) {
        this.buffer = new LinkedList<>();
        this.size = size;
    }

    public synchronized boolean isEmpty() {
        return buffer.isEmpty();
    }

    public synchronized boolean isFull() {
        return buffer.size() == size;
    }

    public synchronized void add(E element) throws InterruptedException {
        while(isFull())
            wait();

        buffer.add(element);
        notifyAll();
    }

    public synchronized E remove() throws InterruptedException {
        while(isEmpty())
            wait();

        //La notifica può avvenire prima della rimozione perché il mutex viene
        //rilasciato al termine del metodo (dopo il return)
        notifyAll();
        return buffer.remove();
    }
}