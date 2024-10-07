package spaces;

import people.Person;

//Interface -> all methods are abstracts
//An interface is extendable just like a class
public interface Accessible {
    void enters(Person p);
    Person exits();
}