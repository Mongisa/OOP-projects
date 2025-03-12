package record;

public record Studente(String nome, String cognome, String matricola) {
    private static int count = 0;

    public Studente {
        if(!matricola.matches("[0-9]{9}")) throw new IllegalArgumentException("matricola non valida");
    }

    public Studente(String nome, String cognome, CorsoDiStudi cds) {
        this(nome, cognome, cds.getPrefisso() + String.format("%04d", ++count));
    }
}
