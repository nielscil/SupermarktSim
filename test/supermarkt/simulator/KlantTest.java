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
import org.junit.Ignore;

/**
 *
 * @author Allard
 */
public class KlantTest
{
    private static Controller controller;
    private static Klant testKlant;
    public KlantTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        controller =  new Controller();
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
     * Test of setPostition method, of class Klant.
     */
    @Test
    public void testSetPostition()
    {
        System.out.println("setPostition");
        Point p = new Point(1,30);
        Klant instance = testKlant;
        instance.setPostition(p);
        assertEquals(9, Controller.bord[p.x][p.y].getItem());
    }

    /**
     * Test of paktProduct method, of class Klant.
     */
    @Test
    public void testPaktProduct()
    {
        System.out.println("paktProduct");
        int aantal = 1;
        String product = "Sok";
        List<ProductWrapper> pws = new ArrayList<>();
        pws.add(new ProductWrapper(new Product("Sok", 2.0, 1), 3));
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        Pad huidigePad = new Pad(points, pws, aantal, product);
        Klant instance = testKlant;
        int expResult = 1;
        int result = instance.paktProduct(1, product, huidigePad);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Klant.
     */
    @Ignore @Test
    public void testMove() throws Exception
    {
        System.out.println("move");
        Klant instance = null;
        instance.move();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
