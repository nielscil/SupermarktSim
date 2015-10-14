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
 * @author Niels
 */
public class padenViewTest
{
    
    public padenViewTest()
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
     * Test of setPaden method, of class padenView.
     */
    @Test
    public void testSetPaden()
    {
        Controller controller = new Controller();
        System.out.println("setPaden");
        padenView instance = new padenView(controller);
        instance.setPaden();
        int expResult = 7;
        int result = instance.getComponentCount();
        assertEquals(expResult, result);
    }
    
}
