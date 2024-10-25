package test;

public class Main {
    public static void main(String[] args) {
        System.out.println(Static.getNumero());
        System.out.println(Static.num2);
        Static s1 = new Static(5);
        System.out.println("S1.num:" + s1.getNum());
        System.out.println(Static.getNumero());

        Static s2 = new Static(4);
        System.out.println("S2.num: " + s2.getNum());
        System.out.println("S1.num:" + s1.getNum());
        System.out.println(Static.getNumero());
        System.out.println(Static.num2);
    }
}