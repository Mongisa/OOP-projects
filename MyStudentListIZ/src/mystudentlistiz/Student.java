package mystudentlistiz;

public class Student {
    private final String name;
    private final String surname;
    private final String code;

    public Student(String name, String surname, String code) {
        this.name = name;
        this.surname = surname;
        this.code = code;
    }

    public String getName () {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getCode() {
        return this.code;
    }
}
