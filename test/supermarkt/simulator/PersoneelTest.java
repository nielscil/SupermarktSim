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
import org.junit.Ignore;

/**
 *
 * @author Allard
 */
public class PersoneelTest
{
    private static Personeel ps;
    private static Controller controller;
    
    public PersoneelTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        controller = new Controller();
        ps = new Personeel("Test Personeel 1", new Point(1,31), 5, controller);
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
     * Test of setPostition method, of class Personeel.
     */
    @Test
    public void testSetPostition()
    {
        System.out.println("setPostition");
        Point p = new Point(1,30);
        Personeel instance = ps;
        instance.setPostition(p);
        assertEquals(10, Controller.bord[p.x][p.y].getItem());
    }

    /**
     * Test of voegTaakToe method, of class Personeel.
     */
    @Test
    public void testVoegTaakToe()
    {
        System.out.println("voegTaakToe");
        Taken taak = new Taken(Taken.Taak.Pad1);
        Personeel instance = ps;
        instance.voegTaakToe(taak);
        //assertEquals(taak, ps.taken.get(0)); //Maak public voor test
    }

    /**
     * Test of move method, of class Personeel.
     */
    @Ignore @Test
    public void testMove() throws Exception
    {
        System.out.println("move");
        Personeel instance = ps;
        instance.move();
    }
    
}
