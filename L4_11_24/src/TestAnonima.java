import java.util.*;

public class TestAnonima {
    public static void main(String[] args) {
        List<String> elenco = new LinkedList();

        elenco.add("Mario");
        elenco.add("Ernesto");
        elenco.add("Luca");
        elenco.add("Margherita");

        System.out.println(elenco);

        // sorting in ordine crescente (lunghezza stringa)
        elenco.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(elenco);
    }
}
