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
    
    private void makeTaak()
    {
        
    }
        
    @Override
    public void move() throws Exception
    {
        if(taken == null)
        {
            makeTaak();
        }
        if(positie == taak.getEindPunt())
        {
            switch(taak.getTaak())
            {
                case Pad1:
                    if(controller.paden.size() >= 1)
                    {
                        Product product = new Product();
                        Pad pad = controller.paden.get(0);
                        if(pad.heeftProduct(product.getNaam()))
                        {
                            pad.vulProduct();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Pad2:
                    if(controller.paden.size() >= 1)
                    {
                        Product product = new Product();
                        Pad pad = controller.paden.get(0);
                        if(pad.heeftProduct(product.getNaam()))
                        {
                            pad.vulProduct();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Pad3:
                    if(controller.paden.size() >= 1)
                    {
                        Product product = new Product();
                        Pad pad = controller.paden.get(0);
                        if(pad.heeftProduct(product.getNaam()))
                        {
                            pad.vulProduct();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Pad4:
                    if(controller.paden.size() >= 1)
                    {
                        Product product = new Product();
                        Pad pad = controller.paden.get(0);
                        if(pad.heeftProduct(product.getNaam()))
                        {
                            pad.vulProduct();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Afdeling1_Personeel:
                    if(controller.afdelingen.size() >= 1)
                    {
                        Product product = new Product();
                        Afdeling afdeling = controller.afdelingen.get(0);
                        if(afdeling.heeftProduct(product.getNaam()))
                        {
                            afdeling.vulProduct();
                            return;
                        }
                        makeTaak();
                    }
                    return;
                case Afdeling2_Personeel:
                    if(controller.afdelingen.size() >= 1)
                    {
                        Product product = new Product();
                        Afdeling afdeling = controller.afdelingen.get(0);
                        if(afdeling.heeftProduct(product.getNaam()))
                        {
                            afdeling.vulProduct();
                            return;
                        }
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
                    if(controller.kassas.size() >= 1)
                    {
                        Kassa kassa = controller.kassas.get(0);
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
                    if(controller.kassas.size() >= 1)
                    {
                        Kassa kassa = controller.kassas.get(0);
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
                    if(controller.kassas.size() >= 1)
                    {
                        Kassa kassa = controller.kassas.get(0);
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
                    
            }
        }
    }
}
