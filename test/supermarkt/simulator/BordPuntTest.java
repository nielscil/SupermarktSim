/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Point;
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
public class BordPuntTest
{
    
    public BordPuntTest()
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
     * Test of setItem method, of class BordPunt.
     */
    @Test
    public void testSetItem()
    {
        System.out.println("setItem");
        int item = 0;
        BordPunt instance = null;
        instance.setItem(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositie method, of class BordPunt.
     */
    @Test
    public void testGetPositie()
    {
        System.out.println("getPositie");
        BordPunt instance = null;
        Point expResult = null;
        Point result = instance.getPositie();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItem method, of class BordPunt.
     */
    @Test
    public void testGetItem()
    {
        System.out.println("getItem");
        BordPunt instance = null;
        int expResult = 0;
        int result = instance.getItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
