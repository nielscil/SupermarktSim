package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Personeel extends Persoon 
{

    private int maxTaken;
    private List<Taken> taken = new ArrayList<>();
    private Taken taak;
    
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
            Controller.bord[p.x][p.y].setItem(10);
        }
    }
    
    public void voegTaakToe(Taken taak)
    {
        taken.add(taak);
    }
    
    private void makeTaak()
    {
        if(taak != null)
        {
            taken.add(taak);
        }
        taak = new Taken(taken.get(0).getTaak());
        taken.remove(0);
        //deze nog joris
    }
        
    @Override
    public void move() throws Exception
    {
        if(taak == null)
        {
            makeTaak();
        }
        if(positie.equals(taak.getEindPunt()))
        {
            switch(taak.getTaak())
            {
                case Pad1:
                    if(controller.paden.size() >= 1)
                    {
                        Pad pad = controller.paden.get(0);
                        if(!pad.vulProduct())
                           return;
                        makeTaak();
                    }
                    return;
                case Pad2:
                    if(controller.paden.size() >= 2)
                    {
                        Pad pad = controller.paden.get(1);
                        if(!pad.vulProduct())
                           return;
                        makeTaak();
                    }
                    return;
                case Pad3:
                    if(controller.paden.size() >= 3)
                    {
                        Pad pad = controller.paden.get(2);
                        if(!pad.vulProduct())
                           return;
                        makeTaak();
                    }
                    return;
                case Pad4:
                    if(controller.paden.size() >= 4)
                    {
                        Pad pad = controller.paden.get(3);
                        if(!pad.vulProduct())
                           return;
                        makeTaak();
                    }
                    return;
                case Afdeling1_Personeel:
                    if(controller.afdelingen.size() >= 1)
                    {
                        Afdeling afdeling = controller.afdelingen.get(0);
                        if(!afdeling.vulProduct())
                           return;
                        makeTaak();
                    }
                    return;
                case Afdeling2_Personeel:
                    if(controller.afdelingen.size() >= 2)
                    {
                        Afdeling afdeling = controller.afdelingen.get(1);
                        if(!afdeling.vulProduct())
                           return;
                        makeTaak();
                    }
                    return;
                case Kassa1_Personeel:                    
                    if(controller.kassas.size() >= 1)
                    {
                        Kassa kassa = controller.kassas.get(0);                                             
                        kassa.bemanKassa(this);
                        kassa.rekenAf(); 
                        return;
                    }
                    return;
                case Kassa2_Personeel:
                    if(controller.kassas.size() >= 2)
                    {
                        Kassa kassa = controller.kassas.get(1);
                        if(!kassa.isOpen())
                        {
                            kassa.bemanKassa(this);
                            kassa.rekenAf();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Kassa3_Personeel:
                    if(controller.kassas.size() >= 3)
                    {
                        Kassa kassa = controller.kassas.get(2);
                        if(!kassa.isOpen())
                        {
                            kassa.bemanKassa(this);
                            kassa.rekenAf();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Kassa4_Personeel:
                    if(controller.kassas.size() >= 4)
                    {
                        Kassa kassa = controller.kassas.get(3);
                        if(!kassa.isOpen())
                        {
                            kassa.bemanKassa(this);
                            kassa.rekenAf();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Voordeelstraat:
                    //deze nog joris
            }
        }
        Point p = taak.getTaakBeschrijving(positie);
        setPostition(p);  
    }
}
