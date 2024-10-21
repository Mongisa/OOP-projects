package camion;

import java.util.*;

public class Fleet {
    
    private Set<Truck> flotta;
    private static String name;

    public Fleet(String name) {
        this.flotta = new HashSet<>();
        this.name = name;
    }
    
    public void add(Truck t) {
        this.flotta.add(t);
    }
    
    public Fleet filterFoodGrade() {
        Fleet f = new Fleet(this.name + "with only food-grade Tankers");
        Iterator<Truck> i = this.flotta.iterator();
        
        while(i.hasNext()) {
            Truck t = i.next();
            if(t.getClass() == Tanker.class) {
                Tanker tanker = (Tanker) t;
                
                if(tanker.isFoodGrade()) {
                    f.flotta.add(t);
                }
            }
        }
    
        return f;
    }

    @Override
    public String toString() {
       StringBuffer s = new StringBuffer(this.name);
       s.append(" contains:\n");
       s.append(this.flotta.toString());
       
       return s.toString();
    }
     
}


