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
    private static Controller controller;
    private static Personeel personeel;
    private static Klant testKlant;
    public KassaTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        controller =  new Controller();
        personeel = new Personeel("Piet", new Point(0,0), 5, controller);
        List<Product> producten = new ArrayList<>();
        producten.add(new Product("sok", 1.35, 1));
        Groep groep = new Groep("studenten", producten);
        testKlant = new Klant("pieter", new Point(0,0), groep, controller);
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
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        Kassa instance = new Kassa(1, plaats);
        testKlant.winkelwagen.add(new Product("Sok", 1.0, 1));
        instance.rij.add(testKlant);
        instance.bemanKassa(personeel);
        instance.rekenAf();
        assertEquals(0, instance.rij.size());
    }

    /**
     * Test of checkKlanten method, of class Kassa.
     */
    @Test
    public void testCheckKlanten()
    {
        System.out.println("checkKlanten");
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
        Kassa instance = new Kassa(1, plaats);
        instance.klantBijKassa(testKlant);
        assertEquals(testKlant, instance.rij.get(0)); //Maak rij public
        
    }

    /**
     * Test of BesteKassa method, of class Kassa.
     */
    @Test
    public void testBesteKassa()
    {
        System.out.println("BesteKassa");
        List<Kassa> kassas = controller.kassas;
        int expResult = 1;
        int result = Kassa.BesteKassa(kassas);
        assertEquals(expResult, result);
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
        int expResult = 4;
        List<Kassa> result = Kassa.loadKassa();
        assertEquals(expResult, result.size());
    }
    
}
