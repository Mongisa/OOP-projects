package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        checkNumbersS(2.5,new ArrayList<Double>());

        Range<Integer> ri = new Range<>(2,4);

        System.out.println(ri.contains(3));
    }

    //PECS - Producer Extends Consumer Super
    public static void checkNumbers(Number n, List<? extends Number> l) {
        //l.add(n); //NON SI PUO'

        for(Number ni : l) {
            System.out.println(ni);
        }
    }

    public static void checkNumbersS(Double n, List<? super Double> l) {
        l.add(n);

        for(Object ni : l) {
            System.out.println(ni);
        }
    }

    public static <U extends Number> void checkNumbersG(U n, List<U> l) {
        l.add(n);

        for(U ni : l) {
            System.out.println(ni);
        }
    }
}
