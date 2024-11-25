package people;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getAge() != o2.getAge())
            return o1.getAge() - o2.getAge(); //persone con la stessa età sono considerate duplicate!

        return o1.compareTo(o2);
    }
}
