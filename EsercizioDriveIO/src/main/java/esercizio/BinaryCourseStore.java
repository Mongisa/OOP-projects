package esercizio;

import java.io.*;

public class BinaryCourseStore implements CourseStore {
    @Override
    public void save(String filename, Course c) {
        try(DataOutputStream dis = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
            for(String m : c.matricole()) {
                Student s = c.get(m);

                dis.writeUTF(s.getNome());
                dis.writeUTF(s.getMatricola());
                dis.writeInt(s.getEsamiSostenuti());
                dis.writeDouble(s.getVotoMedio());
            }
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public Course load(String fileName) {
        Course c = new Course();

        try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while(true) {
                String nome = dis.readUTF();
                String matricola = dis.readUTF();
                int esamiSostenuti = dis.readInt();
                double votoMedio = dis.readDouble();

                Student s = new Student(nome, matricola, esamiSostenuti, votoMedio);
                c.put(s.getMatricola(), s);
            }
        } catch(EOFException e) {
            System.out.println("Lettura completata");
        } catch(IOException e) {
            System.err.println(e);
            return null;
        }

        return c;
    }
}
