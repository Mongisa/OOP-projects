package oop2016.gennaio2017.MonteAlessandro;

import java.io.Serializable;

public class Studente implements Comparable<Studente>, Serializable {
    private final String nome;
    private final String cognome;
    private final String matricola;

    public Studente(String nome, String cognome, String matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getMatricola() {
        return this.matricola;
    }

    @Override
    public String toString() {
        return "Studente{nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + "}";
    }

    @Override
    public int hashCode() {
        return matricola.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Studente s = (Studente) obj;

        return s.matricola.equalsIgnoreCase(this.matricola);
    }

    @Override
    public int compareTo(Studente o) {
        return o.matricola.compareToIgnoreCase(this.matricola);
    }
}
