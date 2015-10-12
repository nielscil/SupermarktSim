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
public class AppviewTest
{
 
    private static Controller controller;
    public AppviewTest()
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
        String logString = "Huh??!";
        Persoon persoon = new Personeel("Kjeld",new Point(0,0), 5, controller);
        Appview.Log(logString, persoon);
        //assertEquals(3,Appview.logging.size()); //logging public maken om te testen
    }

    /**
     * Test of getSupermarkView method, of class Appview.
     */
    @Test
    public void testGetSupermarkView()
    {
        System.out.println("getSupermarkView");
        Appview instance = new Appview(controller, 1);
        //SupermarkView expResult = instance.bord; //maak bord public om te testen
        SupermarkView result = instance.getSupermarkView();
        //assertEquals(expResult, result);
        
    }
    
}
