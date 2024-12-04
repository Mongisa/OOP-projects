package esercitazione2streamio;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LibrettoEsami le = LibrettoEsami.read("esami.txt");

        System.out.println(le.getByNomeInsegnamento("HPC"));
    }
}
