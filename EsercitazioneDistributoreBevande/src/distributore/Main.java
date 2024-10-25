package distributore;

import distributore.bibite.*;

public class Main {
    public static void main(String[] args) {
        Distributore d = new Distributore();

        try {
            d.eroga("COC",0000);
        } catch (Exception e) {
            System.err.println("12: " + e);
        }

        try {
            d.registraTessera(0000);
            d.registraTessera(0000);
        } catch (Exception e) {
            System.err.println("19: " + e);
        }

        try {
            d.visualizzaSaldoTessera(0000);
            d.visualizzaSaldoTessera(0001);
        } catch (Exception e) {
            System.err.println("26: " + e);
        }

        try {
            d.registraBibita(new CocaCola("COC", "Coca-Cola in lattina", 2.5, 10));
        } catch (Exception e) {
            System.err.println("32: " + e);
        }

        try {
            d.eroga("COC", 0000);
        } catch (Exception e) {
            System.err.println("38: " + e);
        }

        try {
            d.caricaTessera(0000,5);
            System.out.println("43: Saldo tessera 0000: " + d.visualizzaSaldoTessera(0000));
        } catch (Exception e) {
            System.err.println("45: " + e);
        }
    }
}