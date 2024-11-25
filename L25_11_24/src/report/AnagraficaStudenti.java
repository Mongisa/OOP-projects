package report;

import people.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class AnagraficaStudenti {
    private final String descrizione;
    private final Map<String, Student> anagrafica;

    public AnagraficaStudenti(String descrizione) {
        this.descrizione = descrizione;
        anagrafica = new HashMap<>();
    }

    public void aggiungi(Student s) {
        anagrafica.putIfAbsent(s.getId(), s);
    }

    public Student cerca(String matricola) {
        return anagrafica.get(matricola);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Anagrafica: " + descrizione + "\n");

        for(Student s : anagrafica.values()) {
            sb.append(s.toString() + "\n");
        }

        return sb.toString();
    }

    public void salvaDOS(String nomeFile) throws IOException {
        FileOutputStream fos = new FileOutputStream(nomeFile);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF(this.descrizione);

        for(Student s : anagrafica.values()) {
            dos.writeUTF(s.getName());
            dos.writeUTF(s.getSurname());
            dos.writeUTF(s.getCf());
            dos.writeUTF(s.getId());
            dos.writeFloat(s.getExamsAverage());
        }

        dos.close();
    }

    //Per leggere anagrafica prima di istanziarne una
    public static AnagraficaStudenti leggiDOS(String nomeFile) throws IOException {
        FileInputStream fis = new FileInputStream(nomeFile);

        //Lettura bufferizzata
        BufferedInputStream bis = new BufferedInputStream(fis);

        DataInputStream dis = new DataInputStream(bis);
        String descrizione = dis.readUTF();
        AnagraficaStudenti a = new AnagraficaStudenti(descrizione);

        try {
            while(true) {
                String nome = dis.readUTF();
                String cognome = dis.readUTF();
                String codFiscale = dis.readUTF();
                String matricola = dis.readUTF();
                float votoMedio = dis.readFloat();

                Student s = new Student(nome,cognome,codFiscale,matricola,votoMedio);
                a.aggiungi(s);
            }
        } catch(EOFException ex) {
            System.out.println("Lettura completata!");
        }

        dis.close();
        return a;
    }

    public void salvaCSV(String nomefile) throws IOException {
        //try con le risorse -> rilascia automaticamente le risorse
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomefile)))) {
            pw.println("NOME;COGNOME;CODICE FISCALE;MATRICOLA;VOTO MEDIO");

            for(Student s : anagrafica.values()) {
                pw.append(s.getName()).append(';');
                pw.append(s.getSurname()).append(';');
                pw.append(s.getCf()).append(';');
                pw.append(s.getId()).append(';');
                pw.append(String.valueOf(s.getExamsAverage()));
                pw.append('\n');
            }
        }
    }

    public static AnagraficaStudenti leggiCSV(String nomefile) throws IOException {
        // \\ perché -> 1\ parser espressioni regolari 2\ parser di java
        // una soluzione analoga è [.], usando l'insieme di caratteri
        String nome = nomefile.split("\\.")[0];
        AnagraficaStudenti a = new AnagraficaStudenti(nome);

        try(BufferedReader br = new BufferedReader(new FileReader(nomefile))) {
            //la prima riga si deve scartare
            if(br.readLine() == null) return a;
            String line;
            while((line = br.readLine()) != null) {
                String[] campi = line.split(";");
                Student s = new Student(campi[0],campi[1],campi[2],campi[3],Float.parseFloat(campi[4]));
                a.aggiungi(s);
            }
        }

        return a;
    }

    public static AnagraficaStudenti leggiCSVScan(String nomefile) throws IOException {
        String nomi = nomefile.split("\\.")[0];
        AnagraficaStudenti a = new AnagraficaStudenti(nomi);

        try(Scanner s = new Scanner(new BufferedReader(new FileReader(nomefile)))) {
            if(s.nextLine() == null) return a;

            //usare sempre notazione insiemistica
            s.useDelimiter("[;\n]");
            s.useLocale(Locale.US);

            while(s.hasNext()) {
                //Andrebbe fatto un controllo per non incorrere in eccezioni
                String nome = s.next();
                String cognome = s.next();
                String codFiscale = s.next();
                String matricola = s.next();
                float votoMedio = s.nextFloat();

                Student student = new Student(nome,cognome,codFiscale,matricola, votoMedio);
                a.aggiungi(student);
            }
        }

        return a;
    }
}
