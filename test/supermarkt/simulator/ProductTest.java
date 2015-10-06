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
public class ProductTest
{
    
    public ProductTest()
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
     * Test of getNaam method, of class Product.
     */
    @Test
    public void testGetNaam()
    {
        System.out.println("getNaam");
        Product instance = null;
        String expResult = "";
        String result = instance.getNaam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrijs method, of class Product.
     */
    @Test
    public void testGetPrijs()
    {
        System.out.println("getPrijs");
        Product instance = null;
        double expResult = 0.0;
        double result = instance.getPrijs();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVoordeel method, of class Product.
     */
    @Test
    public void testIsVoordeel()
    {
        System.out.println("isVoordeel");
        Product instance = null;
        boolean expResult = false;
        boolean result = instance.isVoordeel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAfdeling method, of class Product.
     */
    @Test
    public void testGetAfdeling()
    {
        System.out.println("getAfdeling");
        Product instance = null;
        int expResult = 0;
        int result = instance.getAfdeling();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
