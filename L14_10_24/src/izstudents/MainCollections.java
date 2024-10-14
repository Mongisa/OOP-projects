package izstudents;

import people.Person;
import people.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainCollections {
    public static void main(String[] args) {
        Person p = new Person("Mario", "Rossi", "MRS0001");
        Person p1 = p.clone();
        Person s = new Student("Stefano", "Grigi", "SRG0002", "06127001", 29.5f);


        boolean test1 = p.equals(p1);
        boolean test2 = p.equals(p);
        boolean test3 = p.equals(s);
        //System.out.println(test1 + " " + test2 + " " + test3);

        List<Person> people;

        people = new ArrayList<Person>();

        people.add(p);
        people.add(s);
        people.add(p1);

        //System.out.println(people.toString());

        for(Person pm : people)
            System.out.println(pm);

        Iterator<Person> ip = people.iterator();

        while(ip.hasNext())
            System.out.println(ip.next());
    }
}