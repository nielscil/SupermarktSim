/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

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
    
    public ProductWrapperTest()
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
     * Test of setAantal method, of class ProductWrapper.
     */
    @Test
    public void testSetAantal_int()
    {
        System.out.println("setAantal");
        int aantal = 0;
        ProductWrapper instance = null;
        instance.setAantal(aantal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAantal method, of class ProductWrapper.
     */
    @Test
    public void testSetAantal_0args()
    {
        System.out.println("setAantal");
        ProductWrapper instance = null;
        instance.setAantal();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProduct method, of class ProductWrapper.
     */
    @Test
    public void testSetProduct()
    {
        System.out.println("setProduct");
        Product product = null;
        ProductWrapper instance = null;
        instance.setProduct(product);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pakEen method, of class ProductWrapper.
     */
    @Test
    public void testPakEen() throws Exception
    {
        System.out.println("pakEen");
        ProductWrapper instance = null;
        Product expResult = null;
        Product result = instance.pakEen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAantal method, of class ProductWrapper.
     */
    @Test
    public void testGetAantal()
    {
        System.out.println("getAantal");
        ProductWrapper instance = null;
        int expResult = 0;
        int result = instance.getAantal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductNaam method, of class ProductWrapper.
     */
    @Test
    public void testGetProductNaam()
    {
        System.out.println("getProductNaam");
        ProductWrapper instance = null;
        String expResult = "";
        String result = instance.getProductNaam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProduct method, of class ProductWrapper.
     */
    @Test
    public void testGetProduct()
    {
        System.out.println("getProduct");
        ProductWrapper instance = null;
        Product expResult = null;
        Product result = instance.getProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Search method, of class ProductWrapper.
     */
    @Test
    public void testSearch()
    {
        System.out.println("Search");
        String product = "";
        List<ProductWrapper> lijst = null;
        int expResult = 0;
        int result = ProductWrapper.Search(product, lijst);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_String_List()
    {
        System.out.println("Add");
        String product = "";
        List<ProductWrapper> lijst = null;
        List<ProductWrapper> expResult = null;
        List<ProductWrapper> result = ProductWrapper.Add(product, lijst);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_3args_1()
    {
        System.out.println("Add");
        String product = "";
        int aantal = 0;
        List<ProductWrapper> lijst = null;
        List<ProductWrapper> expResult = null;
        List<ProductWrapper> result = ProductWrapper.Add(product, aantal, lijst);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_3args_2() throws Exception
    {
        System.out.println("Add");
        String product = "";
        List<ProductWrapper> lijst = null;
        int max = 0;
        List<ProductWrapper> expResult = null;
        List<ProductWrapper> result = ProductWrapper.Add(product, lijst, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Add method, of class ProductWrapper.
     */
    @Test
    public void testAdd_4args() throws Exception
    {
        System.out.println("Add");
        String product = "";
        int aantal = 0;
        List<ProductWrapper> lijst = null;
        int max = 0;
        List<ProductWrapper> expResult = null;
        List<ProductWrapper> result = ProductWrapper.Add(product, aantal, lijst, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadProductWrappers method, of class ProductWrapper.
     */
    @Test
    public void testLoadProductWrappers()
    {
        System.out.println("loadProductWrappers");
        List<List<ProductWrapper>> expResult = null;
        List<List<ProductWrapper>> result = ProductWrapper.loadProductWrappers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
