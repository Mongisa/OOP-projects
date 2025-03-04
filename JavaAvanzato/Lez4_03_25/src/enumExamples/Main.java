package enumExamples;

public class Main {
    public static void main(String[] args) {
        Colore c = Colore.GIALLO;

        System.out.println(c.getRGB());

        Semaforo s = new Semaforo(c);
        s.indicazioni();

        int p[] = new int[3];

        /* NON E' POSSIBILE USARE QUESTA SINTASSI
        * var p1[] = new int[3];
        */

        var p1 = new int[3];
    }
}
