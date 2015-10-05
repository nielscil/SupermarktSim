/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.util.List;
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
public class VoorraadTest
{
    
    public VoorraadTest()
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
     * Test of lowerProduct method, of class Voorraad.
     */
    @Test
    public void testLowerProduct()
    {
        System.out.println("lowerProduct");
        String product = "";
        Voorraad instance = new Voorraad();
        instance.lowerProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducten method, of class Voorraad.
     */
    @Test
    public void testSetProducten()
    {
        System.out.println("setProducten");
        List<ProductWrapper> producten = null;
        Voorraad instance = new Voorraad();
        instance.setProducten(producten);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProducts method, of class Voorraad.
     */
    @Test
    public void testGetProducts()
    {
        System.out.println("getProducts");
        Voorraad instance = new Voorraad();
        List<ProductWrapper> expResult = null;
        List<ProductWrapper> result = instance.getProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkProduct method, of class Voorraad.
     */
    @Test
    public void testCheckProduct()
    {
        System.out.println("checkProduct");
        String product = "";
        Voorraad instance = new Voorraad();
        boolean expResult = false;
        boolean result = instance.checkProduct(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
