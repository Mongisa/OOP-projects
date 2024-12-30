package esercizio;

import java.io.Serializable;

public class Student implements Serializable {
    private final String nome;
    private final String matricola;
    private int esamiSostenuti;
    private double votoMedio;

    public Student(String nome, String matricola, int esamiSostenuti, double votoMedio) {
        this.nome = nome;
        this.matricola = matricola;
        this.esamiSostenuti = esamiSostenuti;
        this.votoMedio = votoMedio;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricola() {
        return this.matricola;
    }

    public void setEsamiSostenuti(int e) {
        this.esamiSostenuti = e;
    }

    public int getEsamiSostenuti() {
        return this.esamiSostenuti;
    }

    public void setVotoMedio(double v) {
        this.votoMedio = v;
    }

    public double getVotoMedio() {
        return this.votoMedio;
    }

    @Override
    public String toString() {
        return "Student{nome=" + nome + " , matricola=" + matricola + " , esamiSostenuti=" + esamiSostenuti + ", votoMedio=" + votoMedio;
    }
}
