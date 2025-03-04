package sealedInterface;

public class EspressioneSomma implements Descrivibile {

    private final int a,b;

    public EspressioneSomma(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int valuta() {
        return a+b;
    }

    @Override
    public void descrivi() {
        System.out.println("Il risultato di " + a + "+" + b + " = " + valuta());
    }
}
