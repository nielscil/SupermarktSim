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
public class KassaTest
{
    private final Controller controller = new Controller();
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
        Personeel personeel = new Personeel("Piet", new Point(0,0), 5, controller);
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        Kassa instance = new Kassa(1, plaats);
        instance.bemanKassa(personeel);
        //assertEquals(personeel, instance.bemand); // Maak bemand public
        
    }

    /**
     * Test of onbemanKassa method, of class Kassa.
     */
    @Test
    public void testOnbemanKassa()
    {
        System.out.println("onbemanKassa");
        Personeel personeel = new Personeel("Piet", new Point(0,0), 5, controller);
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        Kassa instance = new Kassa(1, plaats);
        instance.bemanKassa(personeel);
        instance.onbemanKassa();
        //assertEquals(null, instance.bemand); // Maak bemand public
        
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
        Personeel personeel = new Personeel("Piet", new Point(0,0), 5, controller);
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        Kassa instance = new Kassa(1, plaats);
        instance.bemanKassa(personeel);
        int expResult = 0;
        int result = instance.checkKlanten();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isOpen method, of class Kassa.
     */
    @Test
    public void testIsOpen()
    {
        System.out.println("isOpen");
        Personeel personeel = new Personeel("Piet", new Point(0,0), 5, controller);
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        Kassa instance = new Kassa(1, plaats);
        instance.bemanKassa(personeel);
        boolean expResult = true;
        boolean result = instance.isOpen();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of klantBijKassa method, of class Kassa.
     */
    @Test
    public void testKlantBijKassa() //fout
    {
        System.out.println("klantBijKassa");
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        List<Product> producten = new ArrayList<>();
        producten.add(new Product("sok", 1.35, 1));
        Groep groep = new Groep("studenten", producten);
        Klant klant = new Klant("pieter", new Point(0,0), groep, controller);
        Kassa instance = new Kassa(1, plaats);
        instance.klantBijKassa(klant);
        //assertEquals(klant, instance.rij.get(0)); //Maak rij public
        
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
        Point p = new Point(0,1);
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        Kassa instance = new Kassa(1, plaats);
        instance.kassaPoint(p);
        assertEquals(7, controller.bord[p.x][p.y].getItem());
        
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
