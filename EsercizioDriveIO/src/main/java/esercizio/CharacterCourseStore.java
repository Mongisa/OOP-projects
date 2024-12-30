package esercizio;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class CharacterCourseStore implements CourseStore {
    @Override
    public void save(String fileName, Course c) {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            pw.println("NOME,MATRICOLA,ESAMISOSTENUTI,VOTOMEDIO");
            for(String m : c.matricole()) {
                Student s = c.get(m);

                pw.print(s.getNome());
                pw.print(",");
                pw.print(s.getMatricola());
                pw.print(",");
                pw.print(s.getEsamiSostenuti());
                pw.print(",");
                pw.println(s.getVotoMedio());
            }
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public Course load(String fileName) {
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            s.useDelimiter("[\n,]");
            s.useLocale(Locale.US);

            if(s.nextLine() == null) return null;

            Course c = new Course();

            while(s.hasNext()) {
                String nome = s.next();
                String matricola = s.next();
                int esamiSostenuti = s.nextInt();
                double mediaVoto = s.nextDouble();

                Student stu = new Student(nome,matricola,esamiSostenuti,mediaVoto);
                c.put(stu.getMatricola(), stu);
            }
            return c;
        } catch(IOException e) {
            System.err.println(e);
            return null;
        }
    }
}
