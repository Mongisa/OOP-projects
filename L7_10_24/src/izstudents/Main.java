package izstudents;

import people.Person;
import people.PersonUnisa;
import people.Student;
import spaces.Classroom;
import spaces.Accessible;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Mario","Rossi","MRS0001");
        Student s = new Student("Stefano","Grigi","SRG0002","06127001",29.5f);

        Classroom c = new Classroom("M",4);

        c.enters(p);
        c.enters(s);

        //Upcast
        Accessible a = new Classroom("M",4);

        System.out.println(a);
        System.out.println(c.toString());
    }
}