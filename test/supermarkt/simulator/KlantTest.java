/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Point;
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
public class KlantTest
{
    
    public KlantTest()
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
     * Test of setPostition method, of class Klant.
     */
    @Test
    public void testSetPostition()
    {
        System.out.println("setPostition");
        Point p = null;
        Klant instance = null;
        instance.setPostition(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paktProduct method, of class Klant.
     */
    @Test
    public void testPaktProduct()
    {
        System.out.println("paktProduct");
        int aantal = 0;
        String product = "";
        Pad huidigePad = null;
        Klant instance = null;
        int expResult = 0;
        int result = instance.paktProduct(aantal, product, huidigePad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Klant.
     */
    @Test
    public void testMove() throws Exception
    {
        System.out.println("move");
        Klant instance = null;
        instance.move();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
