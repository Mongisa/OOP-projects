package elencotelefonico;

import java.util.Objects;

public class Persona implements Comparable<Persona> {
    private final String nome;
    private final String cognome;
    private final String cf;
    private final int eta;

    public Persona(String nome, String cognome, String cf, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.eta = eta;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getCf() {
        return  this.cf;
    }

    public int getEta() {
        return this.eta;
    }

    @Override
    public String toString() {
        return "Persona{Nome="+ nome + ", Cognome=" + cognome + ", CodiceFiscale=" + cf + ", eta=" + eta + "}";
    }

    @Override
    public int compareTo(Persona o) {
        return this.cf.compareToIgnoreCase(o.cf);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.cf.toUpperCase());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final Persona other = (Persona) obj;
        return Objects.equals(this.cf.toUpperCase(), other.cf.toUpperCase());
    }
}
