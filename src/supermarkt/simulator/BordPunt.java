/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Niels
 */
public class BordPunt extends Observable
{
    private Point positie;
    private int item;
    
    public BordPunt(Point punt,int item, Observer o)
    {
        this.positie = punt;
        this.item = item;
        this.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
    public BordPunt(int x, int y,int item,Observer o)
    {
        this.positie = new Point(x, y);
        this.item = item;
        this.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void setItem(int item)
    {
        this.item = item;
        this.setChanged();
        this.notifyObservers();
    }
    
    public Point getPositie()
    {
        return positie;
    }
    
    public int getItem()
    {
        return item;
    }
}
