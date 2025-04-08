package main;

import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Libreria l = new Libreria();

        l.aggiungiLibro(new Libro("Ventimila Leghe Sotto i Mari","Jules Verne",1870,18.0, Optional.of(2.0)));
        l.aggiungiLibro(new Libro("Il GGG", "Roald Dahl",1982,15.0,null));
        l.aggiungiLibro(new Libro("Il principe","Niccolò Machiavelli",1532,10.0,Optional.of(2.0)));
        l.aggiungiLibro(new Libro("L'isola del tesoro","Robert Louis Stevenson",1883, 15, null));

        //Stampa tutti i libri pubblicati dopo il 1900
        System.out.println(l.getLibri().stream().filter(i -> i.getAnnoPubblicazione() > 1850).collect(Collectors.toList()));

        Libro a = l.getLibro("ventimila leghe sotto i mari");

        System.out.println(a);
    }
}
