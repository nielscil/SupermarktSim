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
public class TakenTest
{
    
    public TakenTest()
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
     * Test of getEindPunt method, of class Taken.
     */
    @Test
    public void testGetEindPunt()
    {
        System.out.println("getEindPunt");
        Taken instance = null;
        Point expResult = null;
        Point result = instance.getEindPunt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaak method, of class Taken.
     */
    @Test
    public void testGetTaak()
    {
        System.out.println("getTaak");
        Taken instance = null;
        Taken.Taak expResult = null;
        Taken.Taak result = instance.getTaak();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaakBeschrijving method, of class Taken.
     */
    @Test
    public void testGetTaakBeschrijving() throws Exception
    {
        System.out.println("getTaakBeschrijving");
        Point begin = null;
        Taken instance = null;
        Point expResult = null;
        Point result = instance.getTaakBeschrijving(begin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
