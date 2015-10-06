/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;
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
public class SupermarkViewTest
{
    private static Controller controller;
    private static SupermarkView view;
    public SupermarkViewTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        controller = new Controller();
        Appview appView = new Appview(controller, 1);
        view = appView.getSupermarkView();
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
     * Test of paintComponent method, of class SupermarkView.
     */
    @Ignore @Test
    public void testPaintComponent()
    {
        System.out.println("paintComponent");
        Graphics g = null;
        SupermarkView instance = new SupermarkView();
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SupermarkView.
     */
    @Ignore @Test
    public void testUpdate()
    {
        System.out.println("update");
        Observable o = null;
        Object arg = null;
        SupermarkView instance = new SupermarkView();
        instance.update(o, arg);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGridValue method, of class SupermarkView.
     */
    @Test
    public void testGetGridValue()
    {
        System.out.println("getGridValue");
        Point p = new Point(0,0);
        SupermarkView instance = view;
        Point expResult = new Point(0,0);
        Point result = instance.getGridValue(p);
        assertEquals(expResult, result);
    }
    
}
