package oop2016.gennaio2017.MonteAlessandro;

import java.util.Comparator;
import java.io.Serializable;

public class ComparatoreMatricolaDecrescente implements Comparator<String>, Serializable {
    @Override
    public int compare(String s1, String s2) {
        if(s1.equalsIgnoreCase(s2)) return 0;
        return s1.compareToIgnoreCase(s2);
    }
}
