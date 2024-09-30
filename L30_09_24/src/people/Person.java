package people;

public class Person {
    private String name;
    private String surname;
    private String cf;

    public Person(String name, String surname, String cf) {
        this.name = name;
        this.surname = surname;
        this.cf = cf;
    }

    public String getName() {
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
}