/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allard
 */
public class VrachtwagenTest
{
    
    public VrachtwagenTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of ontladen method, of class Vrachtwagen.
     */
    @Test
    public void testOntladen()
    {
        System.out.println("ontladen");
        Vrachtwagen instance = null;
        boolean expResult = false;
        boolean result = instance.ontladen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAangeroepen method, of class Vrachtwagen.
     */
    @Test
    public void testGetAangeroepen()
    {
        System.out.println("getAangeroepen");
        Vrachtwagen instance = null;
        int expResult = 0;
        int result = instance.getAangeroepen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
