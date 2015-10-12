/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Allard
 */
public class DatabaseTest
{
    private static Controller controller;
    public DatabaseTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        controller = new Controller();
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
        List<ProductWrapper> result = Database.getProducten();
        if(result == null || result.isEmpty())
            fail("Geen producten gevonden");
    }

    /**
     * Test of getWinkelproducten method, of class Database.
     */
    @Test
    public void testGetWinkelproducten()
    {
        System.out.println("getWinkelproducten");
        List<ProductWrapper> result = Database.getWinkelproducten();
        if(result == null || result.isEmpty())
            fail("Geen producten gevonden");
    }

    /**
     * Test of loadGroepen method, of class Database.
     */
    @Test
    public void testLoadGroepen()
    {
        System.out.println("loadGroepen");
        List<Groep> result = Database.loadGroepen();
        if(result == null || result.isEmpty())
            fail("Geen groepen gevonden");
    }

    /**
     * Test of setProducten method, of class Database.
     */
    @Ignore @Test
    public void testSetProducten()
    {
        System.out.println("setProducten");
        List<ProductWrapper> producten = null;
        Database.setProducten(producten);
    }

    /**
     * Test of getGemiddelde method, of class Database.
     */
    @Test
    public void testGetGemiddelde()
    {
        System.out.println("getGemiddelde");
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        List<ProductWrapper> producten = new ArrayList<>();
        producten.add(new ProductWrapper(new Product("brie", 1.35, 2), 5));
        Afdeling afdeling = new Afdeling("Kaas", plaats, producten, 4);
        int expResult = 6;
        int result = Database.getGemiddelde(afdeling);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDay method, of class Database.
     */
    @Test
    public void testGetDay()
    {
        System.out.println("getDay");
        int expResult = 19;
        int result = Database.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of lowerWinkelproduct method, of class Database.
     */
    @Ignore @Test
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
    @Ignore @Test
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
        double expResult = 1296.0;
        double result = Database.getOmzet();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getProductTypes method, of class Database.
     */
    @Test
    public void testGetProductTypes()
    {
        System.out.println("getProductTypes");
        List<Product> result = Database.getProductTypes();
        if(result == null || result.isEmpty())
            fail("Geen producten gevonden");
    }

    /**
     * Test of checkProduct method, of class Database.
     */
    @Test
    public void testCheckProduct()
    {
        System.out.println("checkProduct");
        String product = "Brie";
        boolean expResult = false;
        boolean result = Database.checkProduct(product);
        assertEquals(expResult, result);
    }
    
}
