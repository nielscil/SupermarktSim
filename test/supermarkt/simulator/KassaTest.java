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
public class KassaTest
{
    
    public KassaTest()
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
     * Test of bemanKassa method, of class Kassa.
     */
    @Test
    public void testBemanKassa()
    {
        System.out.println("bemanKassa");
        Personeel personeel = null;
        Kassa instance = null;
        instance.bemanKassa(personeel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onbemanKassa method, of class Kassa.
     */
    @Test
    public void testOnbemanKassa()
    {
        System.out.println("onbemanKassa");
        Kassa instance = null;
        instance.onbemanKassa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rekenAf method, of class Kassa.
     */
    @Test
    public void testRekenAf() throws Exception
    {
        System.out.println("rekenAf");
        Kassa instance = null;
        instance.rekenAf();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkKlanten method, of class Kassa.
     */
    @Test
    public void testCheckKlanten()
    {
        System.out.println("checkKlanten");
        Kassa instance = null;
        int expResult = 0;
        int result = instance.checkKlanten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOpen method, of class Kassa.
     */
    @Test
    public void testIsOpen()
    {
        System.out.println("isOpen");
        Kassa instance = null;
        boolean expResult = false;
        boolean result = instance.isOpen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of klantBijKassa method, of class Kassa.
     */
    @Test
    public void testKlantBijKassa()
    {
        System.out.println("klantBijKassa");
        Klant klant = null;
        Kassa instance = null;
        instance.klantBijKassa(klant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BesteKassa method, of class Kassa.
     */
    @Test
    public void testBesteKassa()
    {
        System.out.println("BesteKassa");
        List<Kassa> kassas = null;
        int expResult = 0;
        int result = Kassa.BesteKassa(kassas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of kassaPoint method, of class Kassa.
     */
    @Test
    public void testKassaPoint()
    {
        System.out.println("kassaPoint");
        Point p = null;
        Kassa instance = null;
        instance.kassaPoint(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadKassa method, of class Kassa.
     */
    @Test
    public void testLoadKassa()
    {
        System.out.println("loadKassa");
        List<Kassa> expResult = null;
        List<Kassa> result = Kassa.loadKassa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
