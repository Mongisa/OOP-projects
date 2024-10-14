package izstudents;

import people.Person;
import people.Student;
import spaces.AccessibleException;
import spaces.Classroom;
import spaces.RoomEmptyException;
import spaces.RoomFullException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Not controlled exception
 */
public class Main {
    public static void main(String[] args) {
        Person p = new Person("Mario","Rossi","MRS0001");
        Student s = new Student("Stefano","Grigi","SRG0002","06127001",29.5f);

        Classroom c = new Classroom("M",4);

        //Upcast
        Classroom a = new Classroom("M",1);

        try {
            //Method that can generate an exception
            Person p1 = a.exits();
            //If a method in the try/block construct generates an exception
            //the code that follows is not executed, e.enters(p) in this case.
            System.out.println("This line won't be printed!");
            a.enters(p);
        } catch (RoomFullException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } catch (RoomEmptyException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }

        /**
         * or
         * } catch (AccessibleException e) {
         *             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
         * }
         */

        try {
            a.enters(s);
        } catch (AccessibleException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            System.out.println("This part of code is always executed");
        }

        System.out.println(a);
        System.out.println(c.toString());
    }
}