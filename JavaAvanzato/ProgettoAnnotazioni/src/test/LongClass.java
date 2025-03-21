package test;

import annotation.*;

@AtMostThree
@FieldNumberConstraint(3)
public class LongClass {
    public int a;
    public float b;
    public String c;
    
    public void m1(){};
    public void m2(){};
    public void m3(){};
}