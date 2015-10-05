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
public class ControllerTest
{
    
    public ControllerTest()
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
     * Test of deletePersoon method, of class Controller.
     */
    @Test
    public void testDeletePersoon()
    {
        System.out.println("deletePersoon");
        Persoon persoon = null;
        Controller instance = new Controller();
        instance.deletePersoon(persoon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of requestVrachtwagen method, of class Controller.
     */
    @Test
    public void testRequestVrachtwagen()
    {
        System.out.println("requestVrachtwagen");
        List<Product> benodigd = null;
        Controller instance = new Controller();
        instance.requestVrachtwagen(benodigd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRonde method, of class Controller.
     */
    @Test
    public void testGetRonde()
    {
        System.out.println("getRonde");
        int expResult = 0;
        int result = Controller.getRonde();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of staanMeerPersonen method, of class Controller.
     */
    @Test
    public void testStaanMeerPersonen()
    {
        System.out.println("staanMeerPersonen");
        Point p = null;
        Persoon persoon = null;
        Controller instance = new Controller();
        int expResult = 0;
        int result = instance.staanMeerPersonen(p, persoon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
