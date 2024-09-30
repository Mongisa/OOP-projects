package people;

public class PersonUnisaStudent extends PersonUnisa{
    private float examsAverage = 0;

    public PersonUnisaStudent(String name, String surname, String cf, String id) {
        super(name, surname, cf, id);
    }

    public void addExamResult(float result) {
        examsAverage = (examsAverage+result)/2.0f;
    }

    public float getExamsAverage() {
        return this.examsAverage;
    }
}
