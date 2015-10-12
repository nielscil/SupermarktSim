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
    private SupermarkView bord = new SupermarkView();
    private BordPunt instance = new BordPunt(new Point(0,0), 5, bord);
    
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
        instance.setItem(5);
        //assertEquals(5, instance.item); //Maak item public
    }

    /**
     * Test of getPositie method, of class BordPunt.
     */
    @Test
    public void testGetPositie()
    {
        System.out.println("getPositie");
        Point point = new Point(0,0);
        Point result = instance.getPositie();
        assertEquals(point, result);
        
    }

    /**
     * Test of getItem method, of class BordPunt.
     */
    @Test
    public void testGetItem()
    {
        System.out.println("getItem");
        int expResult = 5;
        int result = instance.getItem();
        assertEquals(expResult, result);
        
    }
    
}
