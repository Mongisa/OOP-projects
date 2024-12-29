package oop2016.gennaio2017.MonteAlessandro;

import java.util.Iterator;
import java.util.TreeMap;
import java.io.Serializable;

public class RegistroEsami extends TreeMap<String,Libretto> implements Serializable,Iterable<Libretto> {

    public RegistroEsami() {
        super(new ComparatoreMatricolaDecrescente());
    }

    public boolean aggiungiEsame(String matricola, Esame esame) {
        Libretto l = this.get(matricola);
        if(l == null) return false;
        return l.add(esame);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("RegistroEsami\n");

        this.forEach(item -> {
           sb.append(item.toString()).append("\n");
        });

        return sb.toString();
    }

    @Override
    public Iterator<Libretto> iterator() {
        return this.values().iterator();
    }
}
