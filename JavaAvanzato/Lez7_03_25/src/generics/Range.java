package generics;

public class Range<T extends Number & Comparable<T>> {

    private T low;
    private T high;

    public Range(T min, T max) {
        this.low = min;
        this.high = max;

        if(low.compareTo(high) >= 0)
            throw new IllegalArgumentException("Low deve essere minore di High");
    }

    public T getLow() {
        return low;
    }

    public T getHigh() {
        return high;
    }

    public boolean contains(T value) {
        return low.compareTo(value) < 0 && high.compareTo(value) > 0;
    }

    @Override
    public String toString() {
        return low + " ~ " + high;
    }
}
