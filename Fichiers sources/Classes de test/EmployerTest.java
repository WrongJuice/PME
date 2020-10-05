/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author alfred
 */
public class EmployerTest {
    
    public EmployerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of recruit method, of class Employer.
     */
    @Test
    public void testRecruit() {
        System.out.println("recruit");
        Employee employee = null;
        Employer instance = null;
        instance.recruit(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployees method, of class Employer.
     */
    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        Employer instance = null;
        ArrayList<Employee> expResult = null;
        ArrayList<Employee> result = instance.getEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Employer.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Employer instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Employer.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Employer instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCa method, of class Employer.
     */
    @Test
    public void testGetCa() {
        System.out.println("getCa");
        Employer instance = null;
        int expResult = 0;
        int result = instance.getCa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCa method, of class Employer.
     */
    @Test
    public void testSetCa() {
        System.out.println("setCa");
        int ca = 0;
        Employer instance = null;
        instance.setCa(ca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toSgtring method, of class Employer.
     */
    @Test
    public void testToSgtring() {
        System.out.println("toSgtring");
        Employer instance = null;
        String expResult = "";
        String result = instance.toSgtring();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
