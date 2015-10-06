/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Point;
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
public class PadTest
{
    
    public PadTest()
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
     * Test of heeftProduct method, of class Pad.
     */
    @Test
    public void testHeeftProduct()
    {
        System.out.println("heeftProduct");
        String naam = "";
        Pad instance = null;
        boolean expResult = false;
        boolean result = instance.heeftProduct(naam);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of geefProduct method, of class Pad.
     */
    @Test
    public void testGeefProduct() throws Exception
    {
        System.out.println("geefProduct");
        String product = "";
        Klant klant = null;
        Pad instance = null;
        Product expResult = null;
        Product result = instance.geefProduct(product, klant);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vulProduct method, of class Pad.
     */
    @Test
    public void testVulProduct() throws Exception
    {
        System.out.println("vulProduct");
        Personeel p = null;
        Pad instance = null;
        boolean expResult = false;
        boolean result = instance.vulProduct(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTaak method, of class Pad.
     */
    @Test
    public void testSetTaak()
    {
        System.out.println("setTaak");
        Pad instance = null;
        instance.setTaak();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unsetTaak method, of class Pad.
     */
    @Test
    public void testUnsetTaak()
    {
        System.out.println("unsetTaak");
        Pad instance = null;
        instance.unsetTaak();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of padPoint method, of class Pad.
     */
    @Test
    public void testPadPoint()
    {
        System.out.println("padPoint");
        Point p = null;
        Pad instance = null;
        instance.padPoint(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadPad method, of class Pad.
     */
    @Test
    public void testLoadPad()
    {
        System.out.println("loadPad");
        List<List<ProductWrapper>> pws = null;
        List<Pad> expResult = null;
        List<Pad> result = Pad.loadPad(pws);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of productChecken method, of class Pad.
     */
    @Test
    public void testProductChecken()
    {
        System.out.println("productChecken");
        Pad instance = null;
        String expResult = "";
        String result = instance.productChecken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of productVullen method, of class Pad.
     */
    @Test
    public void testProductVullen()
    {
        System.out.println("productVullen");
        Pad instance = null;
        String expResult = "";
        String result = instance.productVullen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
