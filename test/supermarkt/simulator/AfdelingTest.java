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

/**
 *
 * @author Niels
 */
public class AfdelingTest
{
    private static Afdeling testing;
    private static Controller controller = new Controller();
    private static Personeel personeeltest;
    public AfdelingTest()
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
        testing = new Afdeling("test afdeling", new ArrayList<Point>(),new ArrayList<ProductWrapper>(), 10);
        personeeltest = new Personeel("test personeel", new Point(1,31), 3, controller);
    }
    
    @After
    public void tearDown()
    {
        testing = null;
    }

    /**
     * Test of padPoint method, of class Afdeling.
     */
    @Test
    public void testPadPoint()
    {
        System.out.println("padPoint");
        Point p = new Point(0, 0);
        Afdeling instance = testing;
        instance.padPoint(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of bemanAfdeling method, of class Afdeling.
     */
    @Test
    public void testBemanAfdeling()
    {
        System.out.println("bemanAfdeling");
        Personeel personeel = personeeltest;
        Afdeling instance = testing;
        instance.bemanAfdeling(personeel);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setMax method, of class Afdeling.
     */
    @Test
    public void testSetMax()
    {
        System.out.println("setMax");
        int max = 0;
        Afdeling instance = testing;
        instance.setMax(max);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of onbemanAfdeling method, of class Afdeling.
     */
    @Test
    public void testOnbemanAfdeling()
    {
        System.out.println("onbemanAfdeling");
        Afdeling instance = testing;
        instance.onbemanAfdeling();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isBemand method, of class Afdeling.
     */
    @Test
    public void testIsBemand()
    {
        System.out.println("isBemand");
        Afdeling instance = testing;
        boolean expResult = false;
        boolean result = instance.isBemand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNaam method, of class Afdeling.
     */
    @Test
    public void testGetNaam()
    {
        System.out.println("getNaam");
        Afdeling instance = testing;
        String expResult = "test afdeling";
        String result = instance.getNaam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of loadAfdeling method, of class Afdeling.
     */
    @Test
    public void testLoadAfdeling()
    {
        System.out.println("loadAfdeling");
        List<List<ProductWrapper>> productWrappers = new ArrayList<List<ProductWrapper>>();
        List<Afdeling> expResult = new ArrayList<>();
        List<Afdeling> result = Afdeling.loadAfdeling(productWrappers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
