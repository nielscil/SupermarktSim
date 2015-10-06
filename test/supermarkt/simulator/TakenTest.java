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
    private static Taken taak;
    private static Controller controller;
    public TakenTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        taak = new Taken(Taken.Taak.Pad1);
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
     * Test of getEindPunt method, of class Taken.
     */
    @Test
    public void testGetEindPunt()
    {
        System.out.println("getEindPunt");
        Taken instance = taak;
        Point expResult = new Point(8,8);
        Point result = instance.getEindPunt();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTaak method, of class Taken.
     */
    @Test
    public void testGetTaak()
    {
        System.out.println("getTaak");
        Taken instance = taak;
        Taken.Taak expResult = Taken.Taak.Pad1;
        Taken.Taak result = instance.getTaak();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTaakBeschrijving method, of class Taken.
     */
    @Test
    public void testGetTaakBeschrijving() throws Exception
    {
        System.out.println("getTaakBeschrijving");
        Point begin = new Point(1,31);
        Taken instance = taak;
        Point expResult = new Point(1,30);
        Point result = instance.getTaakBeschrijving(begin);
        assertEquals(expResult, result);
    }
    
}
