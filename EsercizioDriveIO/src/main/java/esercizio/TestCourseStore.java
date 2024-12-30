package esercizio;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gennaro
 */
public class TestCourseStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Course c = new Course();

        c.put("0123", new Student("Mario Rossi", "0123", 5, 27.4));
        c.put("0434", new Student("Mario Rossi", "0434", 2, 21.5));
        c.put("2584", new Student("Mario Rossi", "2584", 15, 29.2));
        c.put("1982", new Student("Mario Rossi", "1982", 9, 26.6));
        c.put("4643", new Student("Mario Rossi", "4643", 13, 19.9));

        System.out.println("Visualizzazione Course originale");
        System.out.println(c);

        
        
        
        
        System.out.println("---- Test serializzazione ----");
        CourseStore cs1 = new SerializedCourseStore();
        System.out.println("Serializzazione di Course");
        cs1.save("SerializeCourse.dat", c);

        System.out.println("Deserializzazione di Course");
        c = null;
        c = cs1.load("SerializeCourse.dat");
        System.out.println("Visualizzazione Course deserializzato");
        System.out.println(c);

        
        
        
        
        System.out.println("---- Test binary store ----");
        CourseStore cs2 = new BinaryCourseStore();
        System.out.println("Salvataggio di Course su file binario");
        cs2.save("BinaryCourse.bin", c);

        System.out.println("Caricamento di Course da file binario");
        c = null;
        c = cs2.load("BinaryCourse.bin");
        System.out.println("Visualizzazione Course caricato da file binario");
        System.out.println(c);

        
        
        
        
        System.out.println("---- Test character store ----");
        CourseStore cs3 = new CharacterCourseStore();
        System.out.println("Salvataggio di Course su file di testo");
        cs3.save("CharacterCourse.txt", c);

        System.out.println("Caricamento di Course da file di testo");
        c = null;
        c = cs3.load("CharacterCourse.txt");
        System.out.println("Visualizzazione Course caricato da file di testo");
        System.out.println(c);

    }

}
