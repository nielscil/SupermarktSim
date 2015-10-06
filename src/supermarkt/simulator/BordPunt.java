package supermarkt.simulator;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

/**
 * Bordpunt klasse
 * @author Niels
 */
public class BordPunt extends Observable
{
    private final Point positie;
    private int item;
    
    /**
     * Maakt Bordpunt aan
     * @param punt positie
     * @param item de item van het plek
     * @param o de observer
     */
    public BordPunt(Point punt,int item, Observer o)
    {
        this.positie = punt;
        this.item = item;
        this.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * Maak Bordpunt aan
     * @param x x positie
     * @param y y positie
     * @param item de item van het plek
     * @param o de observer
     */
    public BordPunt(int x, int y,int item,Observer o)
    {
        this.positie = new Point(x, y);
        this.item = item;
        this.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * Zet item van het bordpunt
     * @param item de item van het plek
     */
    public void setItem(int item)
    {
        this.item = item;
        this.setChanged();
        this.notifyObservers();
    }
    
    /**
     * Haalt positie op
     * @return de positie
     */
    public Point getPositie()
    {
        return positie;
    }
    
    /**
     * Haalt item op
     * @return het item
     */
    public int getItem()
    {
        return item;
    }
}
