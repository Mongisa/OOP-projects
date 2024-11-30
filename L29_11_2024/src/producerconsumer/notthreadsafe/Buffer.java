package producerconsumer.notthreadsafe;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer<E> {
    private int size;
    private final Queue<E> buffer;

    public Buffer(int size) {
        this.size = size;
        this.buffer = new LinkedList<>();
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public boolean isFull() {
        return buffer.size() == size;
    }

    public void add(E element) {
        buffer.add(element);
    }

    public E remove() {
        return buffer.remove();
    }
}
