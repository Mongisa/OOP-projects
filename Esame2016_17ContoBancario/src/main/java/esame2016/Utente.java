package esame2016;

import java.io.Serializable;

public class Utente implements Serializable {
    private final String cognome;
    private final String nome;
    private String codiceFiscale;

    public Utente(String cognome, String nome, String codiceFiscale) {
        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
    }

    public Utente(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
        this.nome = null;
        this.cognome = null;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Utente u = (Utente) obj;

        return this.codiceFiscale.equalsIgnoreCase(u.codiceFiscale);
    }

    @Override
    public int hashCode() {
        return this.codiceFiscale.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return cognome + ";" + nome + ";" + codiceFiscale;
    }
}
