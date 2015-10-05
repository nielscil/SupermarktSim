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
public class VoordeelstraatTest
{
    
    public VoordeelstraatTest()
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
     * Test of padPoint method, of class Voordeelstraat.
     */
    @Test
    public void testPadPoint()
    {
        System.out.println("padPoint");
        Point p = null;
        Voordeelstraat instance = null;
        instance.padPoint(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadVoordeelstraat method, of class Voordeelstraat.
     */
    @Test
    public void testLoadVoordeelstraat()
    {
        System.out.println("loadVoordeelstraat");
        List<Point> expResult = null;
        List<Point> result = Voordeelstraat.loadVoordeelstraat();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
