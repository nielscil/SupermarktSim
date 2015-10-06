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
public class PersoonTest
{
    
    public PersoonTest()
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
     * Test of setPostition method, of class Persoon.
     */
    @Test
    public void testSetPostition()
    {
        System.out.println("setPostition");
        Point p = null;
        Persoon instance = null;
        instance.setPostition(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Persoon.
     */
    @Test
    public void testMove() throws Exception
    {
        System.out.println("move");
        Persoon instance = null;
        instance.move();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PersoonImpl extends Persoon
    {

        public PersoonImpl()
        {
            super("", null, null);
        }

        public void setPostition(Point p)
        {
        }

        public void move() throws Exception
        {
        }
    }
    
}
