package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Libreria {
    private final List<Libro> libri;

    public Libreria() {
        this.libri = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        this.libri.add(libro);
    }

    public Libro getLibro(String titolo) {
        return this.libri.stream().filter(libro -> libro.getTitolo().equalsIgnoreCase(titolo)).findFirst().orElseGet(() -> new Libro("UNKWNOWN", "UNKNOWN", 0));
    }

    public <T> List<T> getAttributo(Function<Libro,T> func) {
        return this.libri.stream().map(func).collect(Collectors.toList());
    }

    public Collection<Libro> getLibri() {
        return this.libri;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (Libro libro : libri) {
            sb.append(libro.toString()).append("\n");
        }

        return sb.toString();
    }
}
