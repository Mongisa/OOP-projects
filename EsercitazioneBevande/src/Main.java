import distributore.bibite.Succo;

public class Main {
    public static void main(String[] args) {
        Succo s1 = new Succo("0001","Pera",3,10);
        Succo s2 = new Succo("0001","Mela",3,10);

        System.out.println(s1.equals(s2));
    }
}