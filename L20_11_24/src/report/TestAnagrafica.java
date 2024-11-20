package report;

import people.Student;

import java.io.IOException;

public class TestAnagrafica {
    public static void main(String[] args) throws IOException {
        AnagraficaStudenti a = new AnagraficaStudenti("OOP");

        a.aggiungi(new Student("Mario","Rossi","MRS0001","06127001", 28.5F));
        a.aggiungi(new Student("Stefano","Rossi","STS0001","06127002", 28.5F));
        a.aggiungi(new Student("Mario","Bianchi","MBS0001","06127003", 28.5F));

        //a.salvaDOS("anagrafica.bin");

        AnagraficaStudenti a2 = AnagraficaStudenti.leggiDOS("anagrafica.bin");

        System.out.println(a2);
    }
}
