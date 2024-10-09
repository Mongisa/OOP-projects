package people;

public class Student extends PersonUnisa{
    private float examsAverage = 0;

    public Student(String name, String surname, String cf, String id, float examAverage) {
        super(name, surname, cf, id);

        if(examAverage < 18) throw new AverageNotPermittedException("examAverage can't be < 18");

        this.examsAverage = examAverage;
    }

    public float getExamsAverage() {
        return this.examsAverage;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.examsAverage;
    }

    @Override
    public String getRole() {
        return "Student";
    }
}
