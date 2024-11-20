package report;

import people.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

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
}
