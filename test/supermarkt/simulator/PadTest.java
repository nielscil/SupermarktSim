/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.ir.annotations.Ignore;
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
public class PadTest
{
    private static Controller controller;
    private static Klant testKlant;
    private static Pad pad;
    
    public PadTest()
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
        
        List<Point> plaats = new ArrayList<>();
        plaats.add(new Point(0,0));
        List<ProductWrapper> pws = new ArrayList<>();
        pws.add(new ProductWrapper(new Product("sok", 1.35, 1),3));
        pad = new Pad(plaats, pws, 3, "padnaam");
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
     * Test of heeftProduct method, of class Pad.
     */
    @Test
    public void testHeeftProduct()
    {
        System.out.println("heeftProduct");
        String naam = "sok";
        Pad instance = pad;
        boolean expResult = true;
        boolean result = instance.heeftProduct(naam);
        assertEquals(expResult, result);
    }

    /**
     * Test of geefProduct method, of class Pad.
     */
    @Test
    public void testGeefProduct() throws Exception
    {
        System.out.println("geefProduct");
        String product = "sok";
        Klant klant = testKlant;
        Pad instance = pad;
        Product result = instance.geefProduct(product, klant);
        assertEquals(product, result.getNaam());
        
    }

    /**
     * Test of vulProduct method, of class Pad.
     */
    @Test
    public void testVulProduct() throws Exception
    {
        System.out.println("vulProduct");      
        Pad instance = pad;
        Personeel p = new Personeel("fristie", new Point(0,0), 5, controller);
        boolean expResult = true;
        boolean result = instance.vulProduct(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of setTaak method, of class Pad.
     */
    @Test
    public void testSetTaak()
    {
        System.out.println("setTaak");
        Pad instance = pad;
        instance.setTaak();
        assertEquals(true, instance.wordtGevuld);
        
    }

    /**
     * Test of unsetTaak method, of class Pad.
     */
    @Test
    public void testUnsetTaak()
    {
        System.out.println("unsetTaak");
        Pad instance = pad;
        instance.unsetTaak();
        assertEquals(false, instance.wordtGevuld);
    }

    /**
     * Test of padPoint method, of class Pad.
     */
    @Test
    public void testPadPoint()
    {
        System.out.println("padPoint");
        Point p = new Point(0,0);
        Pad instance = pad;
        instance.padPoint(p);
        assertEquals(8, Controller.bord[p.x][p.y].getItem());
    }

    /**
     * Test of loadPad method, of class Pad.
     */
    @Test
    public void testLoadPad()
    {
        System.out.println("loadPad");
        List<List<ProductWrapper>> pws = new ArrayList<List<ProductWrapper>>();
        List<Pad> expResult = new ArrayList<>();
        List<Pad> result = Pad.loadPad(pws);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of productChecken method, of class Pad.
     */
    @Test
    public void testProductChecken()
    {
        System.out.println("productChecken");
        Pad instance = pad;
        String expResult = "sok";
        String result = instance.productChecken();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of productVullen method, of class Pad.
     */
    @Test
    public void testProductVullen()
    {
        System.out.println("productVullen");
        Pad instance = pad;
        String expResult = "sok";
        String result = instance.productVullen();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setpadenView method, of class Pad.
     */
    @Ignore @Test
    public void testSetpadenView()
    {
        System.out.println("setpadenView");
        padenView pv = new padenView(controller);
        //padenView.padView padview = new padenView.padView(pad);
        Pad instance = null;
        //instance.setpadenView(padview);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
