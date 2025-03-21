package reflection;

public class Studente extends Persona {
    private String matricola;

    public Studente(String nome, String cognome, String cf, String matricola) {
        super(nome,cognome,cf);
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @DaImplementare(assegnatoA = "Mario",dataTermine = "25-04-2025")
    public String generaMatricola() {
        return null;
    }
}
