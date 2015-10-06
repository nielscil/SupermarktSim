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
public class DatabaseTest
{
    
    public DatabaseTest()
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
     * Test of getProducten method, of class Database.
     */
    @Test
    public void testGetProducten()
    {
        System.out.println("getProducten");
        List<ProductWrapper> expResult = null;
        List<ProductWrapper> result = Database.getProducten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWinkelproducten method, of class Database.
     */
    @Test
    public void testGetWinkelproducten()
    {
        System.out.println("getWinkelproducten");
        List<ProductWrapper> expResult = null;
        List<ProductWrapper> result = Database.getWinkelproducten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadGroepen method, of class Database.
     */
    @Test
    public void testLoadGroepen()
    {
        System.out.println("loadGroepen");
        List<Groep> expResult = null;
        List<Groep> result = Database.loadGroepen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProducten method, of class Database.
     */
    @Test
    public void testSetProducten()
    {
        System.out.println("setProducten");
        List<ProductWrapper> producten = null;
        Database.setProducten(producten);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGemiddelde method, of class Database.
     */
    @Test
    public void testGetGemiddelde()
    {
        System.out.println("getGemiddelde");
        Afdeling afdeling = null;
        int expResult = 0;
        int result = Database.getGemiddelde(afdeling);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDay method, of class Database.
     */
    @Test
    public void testGetDay()
    {
        System.out.println("getDay");
        int expResult = 0;
        int result = Database.getDay();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lowerWinkelproduct method, of class Database.
     */
    @Test
    public void testLowerWinkelproduct()
    {
        System.out.println("lowerWinkelproduct");
        Product product = null;
        Database.lowerWinkelproduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWinkelproduct method, of class Database.
     */
    @Test
    public void testSetWinkelproduct()
    {
        System.out.println("setWinkelproduct");
        List<ProductWrapper> producten = null;
        Database.setWinkelproduct(producten);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOmzet method, of class Database.
     */
    @Test
    public void testGetOmzet()
    {
        System.out.println("getOmzet");
        double expResult = 0.0;
        double result = Database.getOmzet();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductTypes method, of class Database.
     */
    @Test
    public void testGetProductTypes()
    {
        System.out.println("getProductTypes");
        List<Product> expResult = null;
        List<Product> result = Database.getProductTypes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkProduct method, of class Database.
     */
    @Test
    public void testCheckProduct()
    {
        System.out.println("checkProduct");
        String product = "";
        boolean expResult = false;
        boolean result = Database.checkProduct(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
