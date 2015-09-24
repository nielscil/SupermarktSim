package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Personeel extends Persoon 
{

    private int maxTaken;
    private List<Taken> taken = new ArrayList<>();
    
    public Personeel(String naam, Point beginpositie, int maxTaken,Controller controller)
    {
        super(naam, beginpositie,controller);
        this.maxTaken = maxTaken;
    }
    
    public Personeel(String naam, Point beginpositie, int maxTaken,List<Taken> taken,Controller controller)
    {
        super(naam, beginpositie,controller);
        this.maxTaken = maxTaken;
        this.taken = taken;
    }
    
    @Override
        protected void setPostition(Point p)
        {
            if(Controller.bord[0][0] != null)
            {
                Controller.bord[positie.x][positie.y].setItem(0);
            }
            this.positie = p;
            if(Controller.bord[0][0] != null)
            {
                Controller.bord[p.x][p.y].setItem(7);
            }
        }
    
    public void voegTaakToe(Taken taak)
    {
        taken.add(taak);
    }
        
    @Override
    public void move() throws Exception
    {
        if(taken.isEmpty())
            return;
    }
}
