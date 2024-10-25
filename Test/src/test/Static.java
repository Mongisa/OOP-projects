package test;

public class Static {
    private static int num = 2;
    public static int num2 = num;

    public Static(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public static int getNumero() {
        return num;
    }
}
