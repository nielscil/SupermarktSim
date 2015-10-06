/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.awt.Point;
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
public class VoordeelstraatTest
{
    private static Voordeelstraat testStraat;
    private static Controller controller;
    
    public VoordeelstraatTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        testStraat = new Voordeelstraat(new ArrayList<Point>(), new ArrayList<ProductWrapper>(), 5);
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
     * Test of padPoint method, of class Voordeelstraat.
     */
    @Test
    public void testPadPoint()
    {
        System.out.println("padPoint");
        Point p = new Point(0,0);
        Voordeelstraat instance = testStraat;
        instance.padPoint(p);
        assertEquals(Controller.bord[p.x][p.y].getItem(), 11);
    }

    /**
     * Test of loadVoordeelstraat method, of class Voordeelstraat.
     */
    @Test
    public void testLoadVoordeelstraat()
    {
        System.out.println("loadVoordeelstraat");
        List<Point> result = Voordeelstraat.loadVoordeelstraat();
        if(result.isEmpty())
            fail("No points");
    }
    
}
