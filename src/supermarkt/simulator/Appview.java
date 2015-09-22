/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Niels
 */
public class Appview
{
    private static final int GAP = 5;
    private SupermarkView bord;
    
    public Appview()
    {
        JFrame frame = new JFrame();
        JPanel framePanel = new JPanel ();
        framePanel.setBorder (BorderFactory.createEmptyBorder (GAP, GAP, GAP, GAP));
        framePanel.setLayout (new BorderLayout (GAP, GAP));
        bord = new SupermarkView();
        framePanel.add (bord, BorderLayout.WEST);
        frame.add (framePanel);
        frame.setTitle ("The Sims: Supermarkt Simulator DLC");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable (false);
        frame.pack ();
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
        try
        {
            Thread.sleep(100);
        }
        catch(InterruptedException e){}
    }
    
    public SupermarkView getSupermarkView()
    {
        return bord;
    }
}
