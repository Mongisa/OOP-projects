package esercitazione;

public final class Studente extends MembroUnisa {
    private final CorsoDiStudi corsoDiStudi;
    private final float votoMedio;

    public Studente(String codiceFiscale, String nomeCompleto, String matricola, CorsoDiStudi corsoDiStudi, float votoMedio) {
        super(codiceFiscale, nomeCompleto, matricola);

        if(!super.getMatricola().matches(corsoDiStudi.getCodice()+ "[0-9]{4}")) throw new IllegalArgumentException("La matricola non è coerente con il corso di studi");

        this.corsoDiStudi = corsoDiStudi;
        this.votoMedio = votoMedio;
    }

    public CorsoDiStudi getCorsoDiStudi() {
        return corsoDiStudi;
    }

    public float getVotoMedio() {
        return votoMedio;
    }

    @Override
    public String toString() {
        return "Studente: " + super.toString();
    }
}
