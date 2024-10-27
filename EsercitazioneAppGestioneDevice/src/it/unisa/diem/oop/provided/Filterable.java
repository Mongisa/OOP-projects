package it.unisa.diem.oop.provided;

import it.unisa.diem.oop.developed.gruppo77.*;
import java.util.Comparator;

public interface Filterable {
    public DeviceStore filter(DeviceFilter d, Comparator<Device> c);
}
