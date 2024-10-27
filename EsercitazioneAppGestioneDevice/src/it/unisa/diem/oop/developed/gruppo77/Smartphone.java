package it.unisa.diem.oop.developed.gruppo77;

import it.unisa.diem.oop.provided.MobileCPUType;

public class Smartphone extends Device {
    private final MobileCPUType cpu;
    private final float screenSizeInch;

    public Smartphone(MobileCPUType cpu, float screenSizeInch, String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity) {
        super(serialNumber, year, month, dayOfMonth, RAMsize, storageCapacity);
        this.cpu = cpu;
        this.screenSizeInch = screenSizeInch;
    }

    public float getScreenSizeInch() {
        return this.screenSizeInch;
    }

    public MobileCPUType getCpu() {
        return this.cpu;
    }

    @Override
    public boolean hasTouchScreen() {
        return true;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Smartphone\n");

        sb.append(super.toString());
        sb.append("CPU= ").append(cpu).append("\n");
        sb.append("screenSizeInch= ").append(screenSizeInch).append("\n");

        return sb.toString();
    }
}
