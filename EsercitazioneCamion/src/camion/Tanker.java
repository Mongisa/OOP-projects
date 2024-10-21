package camion;

public class Tanker extends Truck {
    
    private final Truck tractor;
    private final int totalCapacity;
    private final int compartments;
    private final boolean foodGrade;

    public Tanker(Truck tractor, int totalCapacity, int compartments, boolean foodGrade) {
        super(tractor.getChassisID(), tractor.getRegistrationDate());
        if(totalCapacity < 5000 || totalCapacity > 25000) {
            throw new IllegalArgumentException("Invalid total capacity value or bad compartments number");
        }
        this.tractor = tractor;
        this.totalCapacity = totalCapacity;
        this.compartments = compartments;
        this.foodGrade = foodGrade;
    }
   

    public int getTotalCapacity() {
       return this.totalCapacity;
    }

    public int getCompartments() {
        return this.compartments;
    }

    public boolean isFoodGrade() {
        return this.foodGrade;
    }
    
    

    @Override
    public String toString() {
       return super.toString() + "->Tanker{totalCapacity=" + this.totalCapacity + ",compartments=" + this.compartments + ", foodGrade=" + this.foodGrade + "}";
    }
}
