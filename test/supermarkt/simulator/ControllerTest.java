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
        Controller instance = new Controller();
        Personeel persoon = new Personeel("Allard", new Point(0,0), 1, instance); // maak personeel public
        //instance.personeel.add(persoon);
        instance.deletePersoon(persoon);
        //assertEquals(0,instance.personeel.size()); //Maak personeel public
    }

    /**
     * Test of requestVrachtwagen method, of class Controller.
     */
    @Test
    public void testRequestVrachtwagen()
    {
        System.out.println("requestVrachtwagen");
        List<Product> benodigd = new ArrayList<>();
        Product prod = new Product("kaas", 1.34, 1);
        benodigd.add(prod);
        Controller instance = new Controller();
        instance.requestVrachtwagen(benodigd);
        if(instance.vrachtwagen == null)
            fail("Vrachtwagen mag niet null zijn");       
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
    }

    /**
     * Test of staanMeerPersonen method, of class Controller.
     */
    @Test
    public void testStaanMeerPersonen()
    {
        System.out.println("staanMeerPersonen");
        Point p = new Point(0,0);
        Controller instance = new Controller();
        Personeel persoon = new Personeel("Kjeld", p, 5, instance);
        Personeel persoon1 = new Personeel("Joris", p, 5, instance);
        //instance.personeel.add(persoon1);
        int expResult = 0;
        int result = instance.staanMeerPersonen(p, persoon);
        assertEquals(expResult, result);
    }
    
}
