package camion;

import java.time.LocalDate;


public class Truck {
    
    private final String t_id;
    private final LocalDate dat_imm;

    public Truck(String t_id, LocalDate dat_imm) {
        this.t_id = t_id;
        this.dat_imm = dat_imm;
    }

    public String getChassisID() {
       return this.t_id;
    }

    public LocalDate getRegistrationDate() {
        return this.dat_imm;
    }
    

    @Override
    public int hashCode() {      
        return this.t_id.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
       if(obj == null) return false;
       if(obj == this) return true;
       if(!(obj instanceof Truck)) return false;
       
       Truck t = (Truck) obj;
       return t.t_id.equals(this.t_id);
    }

    @Override
    public String toString() {
        return "Truck{chassisID=" + this.t_id + ", registrationDate=" + this.dat_imm + "}";
    }
    
    
    
}
