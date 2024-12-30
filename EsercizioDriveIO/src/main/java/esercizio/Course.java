package esercizio;

import java.util.*;
import java.io.Serializable;

public class Course implements Serializable {
    private final Map<String, Student> studenti;

    public Course() {
        this.studenti = new HashMap<>();
    }

    public Student get(String matricola) {
        return studenti.get(matricola);
    }

    public void put(String matricola, Student studente) {
        studenti.put(matricola, studente);
    }

    public Set<String> matricole() {
        return studenti.keySet();
    }

    @Override
    public String toString() {
        return studenti.toString();
    }
}
