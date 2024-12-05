package esercitazione2streamio;

public class Main {
    public static void main(String[] args) {
        LibrettoEsami le = LibrettoEsami.read("esami.txt");

        System.out.println("Stampa libretto non ordinato\n");
        System.out.println(le);

        System.out.println("\nStampa libretto ordinato\n");
        System.out.println(le.getLibrettoOrdinato());

        System.out.println("\nStampa esami sostenuti da 0612700212\n");
        System.out.println(le.getByMatricola("0612700212"));

        System.out.println("\nStampa esiti esami HPC\n");
        System.out.println(le.getByNomeInsegnamento("HPC"));

        System.out.println("\nSALVATAGGIO DATI CON SERIALIZZAZIONE\n");
        le.saveObj("data.bin");

        System.out.println("CARICO DATI SERIALIZZATI");
        LibrettoEsami le1 = LibrettoEsami.readObj("data.bin");
        System.out.println(le1);
    }
}
