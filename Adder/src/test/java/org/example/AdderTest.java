package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdderTest {

    /**
     * Test of main method, of class Adder.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Adder.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Adder.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int a = 6;
        int b = 4;
        Adder instance = new Adder();
        int expResult = 10;
        int result = instance.add(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
}