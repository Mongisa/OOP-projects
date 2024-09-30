package izstudents;

import people.PersonUnisaStudent;

public class Main {
    public static void main(String[] args) {
        PersonUnisaStudent s1 = new PersonUnisaStudent("Alessandro","Monte", "MNT", "061270");
        assert(1==1);
        s1.addExamResult(30);
        s1.addExamResult(0);

        System.out.println(s1.getExamsAverage());
    }
}