package magazzino;

import java.time.LocalDate;

public class MagazzinoMain {
    public static void main(String[] args) {
        Magazzino m1 = new Magazzino("a001", "Amazon");

        //Inserimento di prodotti nel magazzino m1
        try {
            m1.aggiungiScorta(new Prodotto("a7b542e","Cacciavite", 3.5), 5, LocalDate.of(2024,10,25));
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            m1.aggiungiScorta(new Prodotto("g5ok54e","Chiave Inglese",15), 3, LocalDate.of(2024,10,19));
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            m1.aggiungiScorta(new Prodotto("t9456e0","Trapano", 125), 20, LocalDate.of(2024,9,10));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Stampa del magazzino m1
        System.out.println(m1.toString());

        //Lancio eccezione ProdottoGiaPresenteException
        try {
            m1.aggiungiScorta(new Prodotto("t9456e0","Trapano", 120), 20, LocalDate.of(2024,9,10));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Lancio eccezione QuantitaNonDisponibileException
        try {
            m1.rimuoviScorta("t9456e0", 25, LocalDate.of(2024,10,25));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Lancio eccezione QuantitaNegativaException
        try {
            m1.rimuoviScorta("t9456e0", -5, LocalDate.of(2024,10,25));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Lancio eccezione ProdottoNonTrovatoException
        try {
            m1.rimuoviScorta("asd3350", 5, LocalDate.of(2024,10,25));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Lancio eccezione PrezzoNegativoException
        try {
            m1.aggiungiScorta(new Prodotto("a7b5sde","Sega Circolare", -3.5), 5, LocalDate.of(2024,10,25));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Acquisto di prodotti dal magazzino m1
        try {
            System.out.println("Acquisto di 3 cacciaviti\n");
            m1.rimuoviScorta("a7b542e", 3, LocalDate.of(2024,11,2));
            System.out.println(m1.getScorta("a7b542e").toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        //Stampa del magazzino m2
        Magazzino m2 = new Magazzino("e001", "eBay");
        try {
            m2.aggiungiScorta(new Prodotto("b8c123d","Martello", 7.5), 10, LocalDate.of(2024,11,15));
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            m2.aggiungiScorta(new Prodotto("h6lm78f","Pinza", 12), 6, LocalDate.of(2024,12,01));
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            m2.aggiungiScorta(new Prodotto("u1234v0","Sega", 50), 15, LocalDate.of(2024,8,20));
        } catch (Exception e) {
            System.out.println(e);
        }

        //Stampa del magazzino m2
        System.out.println(m2.toString());
    }
}