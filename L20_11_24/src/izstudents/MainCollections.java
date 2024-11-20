package izstudents;

import people.AgeComparator;
import people.Person;
import people.Student;

import java.util.*;

public class MainCollections {
    public static void main(String[] args) {
        Person p = new Person("Mario", "Rossi", "MRS0001");
        Person p1 = p.clone();
        Person s = new Student("Stefano", "Grigi", "SRG0002", "06127001", 29.5f);

        s.setAge(30);
        p.setAge(20);
        p1.setAge(25);

        boolean test1 = p.equals(p1);
        boolean test2 = p.equals(p);
        boolean test3 = p.equals(s);
        //System.out.println(test1 + " " + test2 + " " + test3);

        List<Person> people;

        people = new LinkedList<>();

        people.add(p);
        people.add(s);
        people.add(p1);

        //System.out.println(people.toString());

        /**
        for(Person pm : people)
            System.out.println(pm);
        System.out.println();

        Iterator<Person> ip = people.iterator();

        while(ip.hasNext())
            System.out.println(ip.next());
         */

        System.out.println(people.get(1));

        Set<Person> people2; //most used treeSet hashSet
        people2 = new HashSet<>();

        people2.add(p);
        people2.add(s);
        people.add(p1);

        System.out.println(people2.contains(p));

        //Occorre ridefinire hashCode per avere lo stesso risultato
        //in caso di due oggetti con lo stesso codice fiscale.

        Set<String> words;
        words = new TreeSet<>();

        words.add("Ciao");
        words.add("Benvenuti");
        words.add("Attenzione");

        System.out.println(words);

        Set<Person> people3;
        people3 = new TreeSet<>(new AgeComparator());

        //Dobbiamo esplicitare la relazione d'ordine degli oggetti
        //da inserire

        people3.add(s);
        people3.add(p);
        people3.add(p1);

        System.out.println(people3);
    }
}