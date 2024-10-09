package people;

//"abstract" class -> cannot init objects
public abstract class PersonUnisa extends Person {
    private String id;

    public PersonUnisa(String name, String surname, String cf, String id) {
        super(name, surname, cf);
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.getRole() + "-> " + super.toString() + " " + this.id;
    }

    //"abstract" method -> must be defined in subclasses
    public abstract String getRole();
}
