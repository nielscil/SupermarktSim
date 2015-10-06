/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

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
public class AppviewTest
{
    
    public AppviewTest()
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
     * Test of Log method, of class Appview.
     */
    @Test
    public void testLog()
    {
        System.out.println("Log");
        String logString = "";
        Persoon persoon = null;
        Appview.Log(logString, persoon);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSupermarkView method, of class Appview.
     */
    @Test
    public void testGetSupermarkView()
    {
        System.out.println("getSupermarkView");
        Appview instance = null;
        SupermarkView expResult = null;
        SupermarkView result = instance.getSupermarkView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
