//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Rettangolo rettangolo = new Rettangolo(23,34);
        System.out.println("Base: "+rettangolo.getAltezza());
        System.out.println("Altezza: "+rettangolo.getAltezza());
        System.out.println("Perimetro: "+rettangolo.getPerimetro());
    }
}

class Rettangolo {
    private int base;
    private int altezza;

    public Rettangolo(int base, int altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public int getBase() {
        return this.base;
    }

    public int getAltezza() {
        return this.altezza;
    }

    public int getPerimetro() {
        return 2*(this.base+this.altezza);
    }
}