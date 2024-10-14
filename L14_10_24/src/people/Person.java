package people;

public class Person implements Clonable<Person> {
    private String name;
    private String surname;
    private String cf;

    public Person(String name, String surname, String cf) {
        this.name = name;
        this.surname = surname;
        this.cf = cf;
    }

    //With final -> cannot be overwritten
    final public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getCf() {
        return this.cf;
    }

    public void printPerson() {
        System.out.println("Name: " + this.name);
        System.out.println("Surname: " + this.surname);
        System.out.println("CF: " + this.cf);
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null) return false;

        if(this == obj) return true;

        //if(obj.getClass() != this.getClass()) return false; //SYMMETRIC PROPERTY

        if(!(obj instanceof Person)) return false; //Absolute check, works with subclasses. NOT SYMMETRIC

        //Downcast because I'm sure about the class
        Person p = (Person) obj;

        return p.cf.equals(this.cf);
    }

    //toString() redefinition
    @Override
    public String toString() {
        return this.name + " " + this.surname + " " + this.cf;
    }

    @Override
    public Person clone() {
        return new Person(this.name, this.surname, this.cf);
    }
}