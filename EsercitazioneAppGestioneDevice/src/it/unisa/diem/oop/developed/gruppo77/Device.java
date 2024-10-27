package it.unisa.diem.oop.developed.gruppo77;

import java.time.LocalDate;
import java.lang.Comparable;

public abstract class Device implements Comparable<Device> {
    private final String serialNumber;
    private final LocalDate releaseDate;
    private final int RAMsize;
    private final int storageCapacity;

    public Device(String serialNumber, int year, int month, int dayOfMonth, int RAMsize, int storageCapacity) {
        this.serialNumber = serialNumber;
        this.releaseDate = LocalDate.of(year, month, dayOfMonth);
        this.RAMsize = RAMsize;
        this.storageCapacity = storageCapacity;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public int getRAMsize() {
        return this.RAMsize;
    }

    public int getStorageCapacity() {
        return this.storageCapacity;
    }

    public int hashCode() {
        return this.serialNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj.getClass() != this.getClass()) return false;

        Device d = (Device) obj;

        return d.serialNumber.equalsIgnoreCase(this.serialNumber);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("serialNumber= " + serialNumber.toUpperCase() + "\n");
        sb.append("releaseDate= " + releaseDate + "\n");
        sb.append("RAMsize= " + RAMsize + "GB\n");
        sb.append("storageCapacity= " + storageCapacity + "GB\n");

        return sb.toString();
    }

    public abstract boolean hasTouchScreen();

    public final int compareTo(Device o) {
        return o.serialNumber.compareToIgnoreCase(this.serialNumber);
    }
}
