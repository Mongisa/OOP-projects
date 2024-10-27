package it.unisa.diem.oop.developed.gruppo77;

import it.unisa.diem.oop.provided.DeviceFilter;
import it.unisa.diem.oop.provided.Filterable;
import java.util.*;

public class DeviceStore implements Filterable {
    private final String name;
    private final Set<Device> store;

    public DeviceStore(String name) {
        this.name = name;
        this.store = new TreeSet<>();
    }

    public DeviceStore(String name, Comparator<Device> c) {
        this.name = name;
        this.store = new TreeSet<>(c);
    }

    public void addDevice(Device d) {
        if(!this.store.add(d)) {
            throw new DeviceInsertionException("Device già presente");
        }
    }
    //Nel mezzo del cammin di nostra vita
    //mi ritrovai per una selva oscura
    //che la diritta via era smarrita.

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(name);
        sb.append(" contains ").append(this.store.size()).append(" items\n");
        sb.append("Printing:\n");
        Iterator<Device> i = this.store.iterator();

        while(i.hasNext()) {
            sb.append("*****\n").append(i.next().toString());
        }

        return sb.toString();
    }

    @Override
    public DeviceStore filter(DeviceFilter d, Comparator<Device> c) {

        DeviceStore ds;

        if(c==null) {
            ds = new DeviceStore(this.name + " custom view ");
        } else {
            ds = new DeviceStore(this.name + " custom view ", c);
        }

        Iterator<Device> i = this.store.iterator();

        while(i.hasNext()) {
            Device de = i.next();
            if(d.checkDevice(de)) {
                ds.store.add(de);
            }
        }

        return ds;
    }
}
