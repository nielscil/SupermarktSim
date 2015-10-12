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
public class GroepTest
{
    
    public GroepTest()
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
     * Test of getProducten method, of class Groep.
     */
    @Test
    public void testGetProducten()
    {
        System.out.println("getProducten");
        List<Product> producten = new ArrayList<>();
        producten.add(new Product("Chips", 1.5, 1));
        Groep instance = new Groep("studenten", producten);
        List<Product> expResult = producten;
        List<Product> result = instance.getProducten();
        assertEquals(expResult, result);
    }
    
}
