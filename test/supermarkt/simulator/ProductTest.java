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
    private static Product p;
    
    public ProductTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        p = new Product("Hertog Jan", 0.0, 1);
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
        Product instance = p;
        String expResult = "Hertog Jan";
        String result = instance.getNaam();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrijs method, of class Product.
     */
    @Test
    public void testGetPrijs()
    {
        System.out.println("getPrijs");
        Product instance = p;
        double expResult = 0.0;
        double result = instance.getPrijs();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isVoordeel method, of class Product.
     */
    @Test
    public void testIsVoordeel()
    {
        System.out.println("isVoordeel");
        Product instance = p;
        boolean expResult = false;
        boolean result = instance.isVoordeel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAfdeling method, of class Product.
     */
    @Test
    public void testGetAfdeling()
    {
        System.out.println("getAfdeling");
        Product instance = p;
        int expResult = 1;
        int result = instance.getAfdeling();
        assertEquals(expResult, result);
    }
    
}
