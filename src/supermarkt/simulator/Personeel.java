package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Personeel extends Persoon 
{

    private int maxTaken;
    private List<Taken> taken = new ArrayList<>();
    
    public Personeel(String naam, Point beginpositie, int maxTaken)
    {
        super(naam, beginpositie);
        this.maxTaken = maxTaken;
    }
    
    public Personeel(String naam, Point beginpositie, int maxTaken,List<Taken> taken)
    {
        super(naam, beginpositie);
        this.maxTaken = maxTaken;
        this.taken = taken;
    }
    
    public void voegTaakToe(Taken taak)
    {
        taken.add(taak);
    }
        
    @Override
    public void move()
    {
        if(taken.size() == 0)
            return;
    }
}
