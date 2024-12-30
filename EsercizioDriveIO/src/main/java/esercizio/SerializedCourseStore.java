package esercizio;

import java.io.*;

public class SerializedCourseStore implements CourseStore {
    @Override
    public void save(String fileName, Course c) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            oos.writeObject(c);
        } catch(IOException e) {
            System.err.println(e);
        }
    }

    @Override
    public Course load(String fileName) {
        try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            return (Course) ois.readObject();
        } catch(Exception e) {
            System.err.println(e);
            return null;
        }
    }
}
