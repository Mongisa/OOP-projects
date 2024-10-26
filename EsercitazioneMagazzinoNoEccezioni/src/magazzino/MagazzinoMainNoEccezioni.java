package magazzino;

import java.time.LocalDate;

public class MagazzinoMainNoEccezioni {
    public static void main(String[] args) {
        Magazzino m1 = new Magazzino("a001", "Amazon");

        //Inserimento di prodotti nel magazzino m1
        m1.aggiungiScorta(new Prodotto("a7b542e","Cacciavite", 3.5), 5, LocalDate.of(2024,10,25));
        m1.aggiungiScorta(new Prodotto("g5ok54e","Chiave Inglese",15), 3, LocalDate.of(2024,10,19));
        m1.aggiungiScorta(new Prodotto("t9456e0","Trapano", 125), 20, LocalDate.of(2024,9,10));

        //Stampa del magazzino m1
        System.out.println(m1.toString());

        //Acquisto di prodotti dal magazzino m1
        System.out.println("Acquisto di 3 cacciaviti\n");
        m1.rimuoviScorta("a7b542e", 3, LocalDate.of(2024,11,2));
        System.out.println(m1.getScorta("a7b542e").toString());

        Magazzino m2 = new Magazzino("e001", "eBay");

        //Inserimento di prodotti nel magazzino m1
        m2.aggiungiScorta(new Prodotto("b8c123d","Martello", 7.5), 10, LocalDate.of(2024,11,15));
        m2.aggiungiScorta(new Prodotto("h6lm78f","Pinza", 12), 6, LocalDate.of(2024,12,01));
        m2.aggiungiScorta(new Prodotto("u1234v0","Sega", 50), 15, LocalDate.of(2024,8,20));

        //Stampa del magazzino m2
        System.out.println(m2.toString());
    }
}