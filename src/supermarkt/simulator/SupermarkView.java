/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 * De supermarkt plattegrond
 * @author Niels
 */
public class SupermarkView extends JPanel implements Observer
{

    public static final int aantalBlokjes = 32;
    private final int sizeBlok = 20;
    private final int lineThickness = 1;
    private final int boardSize = aantalBlokjes * sizeBlok + (aantalBlokjes + 1) * lineThickness;
    private boolean firstTime = true;
    
    /**
     * Maakt de supermarktview
     */
    public SupermarkView()
    {
        setPreferredSize(new Dimension(boardSize, boardSize));
        setFocusable(true);
    }
    
    /**
     * Paint het component
     * @param g de graphics
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor (Color.GRAY);
        g.fillRect (0, 0, getWidth (), getHeight ());
        DrawBoard (g);
        if(firstTime){
            firstTime = false;
        }
        else
        {
            if(Controller.bord[0][0] != null)
        {
            for(int i = 0; i < Controller.bord.length; i++)
            {
                for(int j =0; j < Controller.bord[i].length; j++)
                {
                    DrawCell(Controller.bord[i][j], g);
                }
            }
        }
        }
    }
    
    /**
     * Update de supermarktview
     * @param o observer
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg)
    {
        DrawCell((BordPunt)o, getGraphics());
    }
    
    /**
     * Tekent het bord 
     * @param g graphics
     */
    private void DrawBoard(Graphics g)
    {
        g.setColor(Color.BLACK);
        int offset = 0;
        for (int i = 0; i < aantalBlokjes + 1; i++)
        {
            for (int j = 0; j < lineThickness; j++)
            {
                g.drawLine (offset, 0, offset, boardSize);
                g.drawLine (0, offset, boardSize, offset);
                offset ++;
            }
            offset += sizeBlok;
        }
    }
    
    /**
     * Tekent een cel
     * @param punt het bordpunt
     * @param g graphics
     */
    private void DrawCell(BordPunt punt, Graphics g)
    {
        if(g == null)
            return;
       Point offset = offset(punt.getPositie());
       switch(punt.getItem())
       {
           case 0:
               g.setColor(Color.GRAY); //loopgrond
               break;
           case 1:
               g.setColor(Color.red); //muur
               break;
           case 2:
               g.setColor(Color.black); //ingang klanten
               break;
           case 3:
               g.setColor(Color.black);//magazijn ingang
               break;
           case 4:
               g.setColor(Color.black); //laden & lossen ingang
               break;
           case 5:
               g.setColor(Color.YELLOW); //kaas afdeling
               break;
           case 6:
               g.setColor(Color.GREEN); //vers afdeling
               break;
           case 7:
               g.setColor(Color.BLUE); //kassa
               break;
            case 8:
                g.setColor(Color.WHITE); //schap
                break;
            case 9:
                g.setColor(Color.ORANGE); //Personeel
                break;
            case 10:
                g.setColor(Color.PINK); //klanten
                break;
            case 11:
                g.setColor(Color.magenta);
                break;
       }
       g.fillRect (offset.x, offset.y, sizeBlok, sizeBlok);
    }
    /**
     * de offset
     * @param p het punt
     * @return de offset
     */
    private Point offset (Point p)
    {
        return new Point(p.x * sizeBlok + (p.x + 1) * lineThickness, p.y * sizeBlok + (p.y + 1) * lineThickness);
    }
    
    /**
     * De waarde van het grid
     * @param p het punt
     * @return het punt
     */
    public Point getGridValue (Point p)
    {
        int x = 0;
        int off = lineThickness;
        while (p.x > off + sizeBlok)
        {
            off += sizeBlok + lineThickness;
            x ++;
        }
        int y = 0;
        off = lineThickness;
        while (p.y > off + sizeBlok)
        {
            off += sizeBlok + lineThickness;
            y ++;
        }
        return new Point(x,y);
    }
}
