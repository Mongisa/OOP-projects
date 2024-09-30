package people;

public class PersonUnisa extends Person {
    private String id;

    public PersonUnisa(String name, String surname, String cf, String id) {
        super(name, surname, cf);


    }

    public String getId() {
        return this.id;
    }

}
