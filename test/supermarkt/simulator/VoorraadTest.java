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
public class VoorraadTest
{
 
    private static Voorraad voorraad;
    
    public VoorraadTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        voorraad = new Voorraad();
        //voorraad.voorraad.get(ProductWrapper.Search("Hertog Jan", voorraad.getProducts())).setAantal();
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
     * Test of lowerProduct method, of class Voorraad.
     */
    @Test
    public void testLowerProduct()
    {
        System.out.println("lowerProduct");
        String product = "Hertog Jan";
        int expResult = voorraad.getProducts().get(ProductWrapper.Search(product, voorraad.getProducts())).getAantal() - 1;
        Voorraad instance = voorraad;
        instance.lowerProduct(product);
        int result = voorraad.getProducts().get(ProductWrapper.Search(product, voorraad.getProducts())).getAantal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProducten method, of class Voorraad.
     */
    @Test
    public void testSetProducten()
    {
        System.out.println("setProducten");
        String product = "Hertog Jan";
        int expResult = voorraad.getProducts().get(ProductWrapper.Search(product, voorraad.getProducts())).getAantal() + 1;
        List<ProductWrapper> producten = new ArrayList<>();
        ProductWrapper hj = new ProductWrapper(new Product(product, 0.0, 1), 1);
        producten.add(hj);
        Voorraad instance = voorraad;
        instance.setProducten(producten);
        int result = voorraad.getProducts().get(ProductWrapper.Search(product, voorraad.getProducts())).getAantal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProducts method, of class Voorraad.
     */
    @Test
    public void testGetProducts()
    {
        System.out.println("getProducts");
        Voorraad instance = voorraad;
        //List<ProductWrapper> expResult = voorraad.voorraad;
        List<ProductWrapper> result = instance.getProducts();
        //assertEquals(expResult, result);
    }

    /**
     * Test of checkProduct method, of class Voorraad.
     */
    @Test
    public void testCheckProduct()
    {
        System.out.println("checkProduct");
        String product = "Hertog Jan";
        Voorraad instance = voorraad;
        boolean expResult = true;
        boolean result = instance.checkProduct(product);
        assertEquals(expResult, result);
    }
    
}
