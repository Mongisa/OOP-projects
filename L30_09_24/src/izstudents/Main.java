package izstudents;

import people.Person;
import people.PersonUnisa;
import people.Student;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Alessandro","Monte", "MNT", "061270", 28f);

        Person p1 = new Person("Nicola","Sorrentino","NCLSR003");

        //Upcast, cannot access all methods and attributes (they still exist)
        Person s2 = new Student("Mario","Rossi","MRG00001","061270004", 29.5F);

        //Person's toString() method is overwritten by Student's toString() method
        System.out.println(s2.toString());

        //Downcast could be forced with explicit casting
        Student s3 = (Student) s2;

        //Class type could be checked before downcast
        if(p1 instanceof Student) {
            Student s4 = (Student) p1;
            System.out.println("First if");
            System.out.println(s4.getExamsAverage());
        }

        if(s2 instanceof Student) {
            Student s4 = (Student) s2;
            System.out.println("Second if");
            System.out.println(s4.getExamsAverage());
        }

        //Alternative method
        if(s2.getClass() == Student.class) {
            Student s4 = (Student) s2;
            System.out.println("Third if");
            System.out.println(s4.getExamsAverage());
        }
    }
}