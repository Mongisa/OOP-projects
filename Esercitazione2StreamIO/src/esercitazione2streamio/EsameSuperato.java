package esercitazione2streamio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class EsameSuperato implements Comparable<EsameSuperato>, Serializable {
    private final String matricolaStudente;
    private final LocalDate annoMeseGiorno;
    private final String nomeInsegnamento;
    private final int voto;
    private final int id;
    private static int index = 0;

    public EsameSuperato(String matricolaStudente, LocalDate annoMeseGiorno, String nomeInsegnamento, int voto) {
        this.matricolaStudente = matricolaStudente;
        this.annoMeseGiorno = annoMeseGiorno;
        this.nomeInsegnamento = nomeInsegnamento;
        this.voto = voto;
        this.id = index++;
    }

    public String getMatricolaStudente() {
        return matricolaStudente;
    }

    public LocalDate getAnnoMeseGiorno() {
        return annoMeseGiorno;
    }

    public String getNomeInsegnamento() {
        return nomeInsegnamento;
    }

    public double getVoto() {
        return voto;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (getClass() != o.getClass()) return false;
        EsameSuperato es = (EsameSuperato) o;
        return this.id == es.id;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("*Esame Superato*\n");
        sb.append("matricola=").append(matricolaStudente).append("\n");
        sb.append("dataSuperamento=").append(annoMeseGiorno).append("\n");
        sb.append("nomeEsame=").append(nomeInsegnamento).append("\n");
        sb.append("voto=").append(voto).append("\n");

        return sb.toString();
    }

    @Override
    public int compareTo(EsameSuperato es) {
        return this.id - es.id;
    }
}
