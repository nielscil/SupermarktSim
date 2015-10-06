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
public class ProductWrapperTest
{
    private static ProductWrapper pw;
    private static Product productTest = null;
    
    public ProductWrapperTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        productTest = new Product("hertog Jan", 0.0, 1);
        pw = new ProductWrapper(productTest,2);
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
     * Test of setAantal method, of class ProductWrapper.
     */
    @Test
    public void testSetAantal_int()
    {
        System.out.println("setAantal");
        int aantal = 10;
        ProductWrapper instance = pw;
        instance.setAantal(aantal);
        assertEquals(aantal, instance.getAantal());
    }

    /**
     * Test of setAantal method, of class ProductWrapper.
     */
    @Test
    public void testSetAantal_0args()
    {
        System.out.println("setAantal");
        ProductWrapper instance = pw;
        int expResult = instance.getAantal() + 1;
        instance.setAantal();
        int result = instance.getAantal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProduct method, of class ProductWrapper.
     */
    @Test
    public void testSetProduct()
    {
        System.out.println("setProduct");
        Product product = productTest;
        ProductWrapper instance = pw;
        instance.setProduct(product);
        assertEquals(product, instance.getProduct());
    }

    /**
     * Test of pakEen method, of class ProductWrapper.
     */
    @Test
    public void testPakEen() throws Exception
    {
        System.out.println("pakEen");
        ProductWrapper instance = pw;
        Product expResult = productTest;
        Product result = instance.pakEen();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAantal method, of class ProductWrapper.
     */
    @Test
    public void testGetAantal()
    {
        System.out.println("getAantal");
        ProductWrapper instance = pw;
        //int expResult = instance.aantal; //Maak public voor test!!
        int result = instance.getAantal();
        //assertEquals(expResult, result);
    }

    /**
     * Test of getProductNaam method, of class ProductWrapper.
     */
    @Test
    public void testGetProductNaam()
    {
        System.out.println("getProductNaam");
        ProductWrapper instance = pw;
        //String expResult = instance.product.getNaam(); //Maak public voor Test
        String result = instance.getProductNaam();
        //assertEquals(expResult, result);
    }

    /**
     * Test of getProduct method, of class ProductWrapper.
     */
    @Test
    public void testGetProduct()
    {
        System.out.println("getProduct");
        ProductWrapper instance = pw;
        Product expResult = productTest;
        Product result = instance.getProduct();
        assertEquals(expResult, result);
    }

    /**
     * Test of Search method, of class ProductWrapper.
     */
    @Test
    public void testSearch()
    {
        System.out.println("Search");
        String product = "Hertog Jan";
        List<ProductWrapper> lijst = new ArrayList<>();
        int expResult = -1;
        int result = ProductWrapper.Search(product, lijst);
        assertEquals(expResult, result);
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_String_List()
    {
        System.out.println("Add");
        String product = "Hertog Jan";
        List<ProductWrapper> lijst = new ArrayList<>();
        lijst.add(pw);
        List<ProductWrapper> expResult = new ArrayList<>();
        expResult.add(pw);
        List<ProductWrapper> result = ProductWrapper.Add(product, lijst);
        assertEquals(expResult, result);
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_3args_1()
    {
        System.out.println("Add");
        String product = "Hertog Jan";
        int aantal = 1;
        List<ProductWrapper> lijst = new ArrayList<>();
        lijst.add(pw);
        List<ProductWrapper> expResult = new ArrayList<>();
        expResult.add(pw);
        List<ProductWrapper> result = ProductWrapper.Add(product, aantal, lijst);
        assertEquals(expResult, result);
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_3args_2() throws Exception
    {
        System.out.println("Add");
        String product = "Hertog Jan";
        List<ProductWrapper> lijst = new ArrayList<>();
        lijst.add(pw);
        int max = 10;
        List<ProductWrapper> expResult = new ArrayList<>();
        expResult.add(pw);
        List<ProductWrapper> result = ProductWrapper.Add(product, lijst, max);
        assertEquals(expResult, result);
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_4args() throws Exception
    {
        System.out.println("Add");
        String product = "";
        int aantal = 1;
        List<ProductWrapper> lijst = new ArrayList<>();
        lijst.add(pw);
        int max = 10;
        List<ProductWrapper> expResult = new ArrayList<>();
        expResult.add(pw);
        List<ProductWrapper> result = ProductWrapper.Add(product, aantal, lijst, max);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadProductWrappers method, of class ProductWrapper.
     */
    @Test
    public void testLoadProductWrappers()
    {
        System.out.println("loadProductWrappers");
        List<List<ProductWrapper>> result = ProductWrapper.loadProductWrappers();
        if(result.isEmpty())
            fail("No Productwrappers");
    }
    
}
