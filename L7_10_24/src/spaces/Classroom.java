package spaces;

import people.Person;

public class Classroom extends Space{
    private Person people[];
    private int count;

    public Classroom (String name, int maxSits) {
        super(name,maxSits);

        this.people = new Person[maxSits];
        this.count = 0;
    }

   @Override
   public void enters(Person p) {
        if(isFull()) {
            System.out.println("Room is full");
            return;
        }

        this.people[this.count++] = p;
   }

   @Override
   public Person exits() {
        if(isEmpty()) {
            System.out.println("Room is empty");
            return null;
        }

        Person p = this.people[--count];
        this.people[count] = null;

        return p;
   }

   private boolean isFull() {
        return this.count == this.people.length;
   }

   private boolean isEmpty() {
        return this.count == 0;
   }

   public String getType() {
        return "Classroom";
   }

   @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString() + '\n');

        for(int i=0;i<count;i++) {
            sb.append(people[i].toString() + "\n");
        }

        return sb.toString();
   }
}
