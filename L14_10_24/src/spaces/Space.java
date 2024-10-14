package spaces;

public abstract class Space implements Accessible {
    private String name;
    private int maxSits;

    public Space (String name, int maxSits) {
        this.name = name;
        this.maxSits = maxSits;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxSits() {
        return this.maxSits;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return this.getType() + ": " + this.name + " Capacity: " + this.maxSits;
    }
}