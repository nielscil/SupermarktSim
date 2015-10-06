/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

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
public class VrachtwagenTest
{
    private Product testProduct = new Product("Test Product", 0.0, 1);
    private Vrachtwagen vrachtwagen;
    private static Controller controller;
    List<Product> testList;
    public VrachtwagenTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
       controller = new Controller();
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        testList = new ArrayList<>();
        testList.add(testProduct);
        vrachtwagen = new Vrachtwagen(testList, 1);
    }
    
    @After
    public void tearDown()
    {
        testProduct = null;
    }
    
    /**
     * Test constructor method, of class Vrachtwagen.
     */
    @Test
    public void testVrachtwagen()
    {
        System.out.println("Vrachtwagen aanroepen");
        Vrachtwagen instance = new Vrachtwagen(testList, 1);
        assertEquals(instance.wordtGelost, false);
        //assertEquals(instance.lading.get(0).getProductNaam(),testList.get(0).getNaam()); // Maak lading public!
        //assertEquals(instance.aangeroepen,11); //Maak aangeroepen public!
    }

    /**
     * Test of ontladen method, of class Vrachtwagen.
     */
    @Test
    public void testOntladen()
    {
        System.out.println("ontladen");
        Vrachtwagen instance = vrachtwagen;
        boolean expResult = false;
        boolean result = instance.ontladen();
        assertEquals(expResult, result);
        expResult = true;
        result = instance.ontladen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAangeroepen method, of class Vrachtwagen.
     */
    @Test
    public void testGetAangeroepen()
    {
        System.out.println("getAangeroepen");
        Vrachtwagen instance = vrachtwagen;
        int expResult = 11;
        int result = instance.getAangeroepen();
        assertEquals(expResult, result);
    }
    
}
