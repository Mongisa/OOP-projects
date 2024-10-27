package it.unisa.diem.oop.developed.gruppo77;

import it.unisa.diem.oop.provided.*;

public class Notebook extends Device {
    private final CPUType type;
    private final NBScreenType screenType;
    private final boolean touchScreen;

    public Notebook(CPUType type, NBScreenType screenType, String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity) {
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = false;
    }

    public Notebook(CPUType type, NBScreenType screenType, boolean touchScreen, String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity) {
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.type = type;
        this.screenType = screenType;
        this.touchScreen = touchScreen;
    }

    public CPUType getType() {
        return this.type;
    }

    public NBScreenType getScreenType() {
        return this.screenType;
    }

    @Override
    public boolean hasTouchScreen() {
        return this.touchScreen;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Notebook\n");

        sb.append(super.toString());
        sb.append("CPU=").append(type).append("\n");
        sb.append("screenType=").append(screenType).append("\n");
        if(touchScreen) {
            sb.append("touchScreen available\n");
        }

        return sb.toString();
   }
}
