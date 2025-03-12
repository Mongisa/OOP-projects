package esercitazione;

public sealed class MembroUnisa extends Persona permits Docente,Studente {
    private final String matricola;

    public MembroUnisa(String codiceFiscale, String nomeCompleto, String matricola) {
        super(codiceFiscale, nomeCompleto);
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    @Override
    public String toString() {
        return "MembroUnisa = { " + super.toString() + " matricola=" + matricola + " }";
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if (this == o) return true;
        if (!(o instanceof MembroUnisa mu)) return false;
        return mu.matricola.equals(matricola);
    }

    @Override
    public int hashCode() {
        return matricola.hashCode();
    }
}
