package oop2016.gennaio2017.MonteAlessandro;

import java.util.*;
import java.io.Serializable;

public class Libretto extends HashSet<Esame> implements Serializable {
    private final Studente studente;

    public Libretto(Studente s) {
        super();
        this.studente = new Studente(s.getNome(), s.getCognome(),s.getMatricola());
    }

    public Studente getStudente() {
        return this.studente;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(studente.toString());
        sb.append("\n");
        for(Esame e : this)
            sb.append(e.toString()).append("\n");

        return sb.toString();
    }
}
