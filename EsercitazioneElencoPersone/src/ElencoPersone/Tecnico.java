package ElencoPersone;

import java.time.LocalDate;

public class Tecnico extends Persona {
    private final String dipartimento;

    public Tecnico (String nome, LocalDate dataNascita, String codiceFiscale, String dipartimento) {
        super(nome, dataNascita, codiceFiscale);
        this.dipartimento = dipartimento;
    }

    public String getDipartimento() {
        return dipartimento;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDipartimento=" + this.dipartimento;
    }
}