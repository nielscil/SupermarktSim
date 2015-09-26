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
            int meer = controller.staanMeerPersonen(positie,this);
            if(meer == -1)
                Controller.bord[positie.x][positie.y].setItem(0);
            else if(meer == 1)
                Controller.bord[positie.x][positie.y].setItem(9);
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
        if(!controller.openTaken.isEmpty())
        {
            List<Integer> openTaken = controller.openTaken;
           for(int i = 0; i < openTaken.size();i++)
           {
               switch(openTaken.get(i))
               {
                   case 1:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Kassa1_Personeel)
                           {
                               taak = new Taken(Taken.Taak.Kassa1_Personeel);
                               controller.kassas.get(0).bemanKassa(this);
                               controller.openTaken.remove(Integer.valueOf(1));
                               return;
                           } 
                       }
                       //kassa1
                       break;
                   case 2:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Kassa2_Personeel)
                           {
                               taak = new Taken(Taken.Taak.Kassa2_Personeel);
                               controller.kassas.get(1).bemanKassa(this);
                               controller.openTaken.remove(Integer.valueOf(2));
                               return;
                           } 
                       }
                       //kassa2
                       break;
                   case 3:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Kassa3_Personeel)
                           {
                               taak = new Taken(Taken.Taak.Kassa3_Personeel);
                               controller.kassas.get(2).bemanKassa(this);
                               controller.openTaken.remove(Integer.valueOf(3));
                               return;
                           }   
                       }
                       //kassa3
                       break;
                   case 4:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Kassa4_Personeel)
                           {
                               taak = new Taken(Taken.Taak.Kassa4_Personeel);
                               controller.kassas.get(3).bemanKassa(this);
                               controller.openTaken.remove(Integer.valueOf(4));
                               return;
                           }  
                       }
                       //kassa4
                       break;
                   case 5:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Afdeling1_Personeel)
                           {
                               taak = new Taken(Taken.Taak.Afdeling1_Personeel);
                               controller.afdelingen.get(0).setTaak();
                               controller.afdelingen.get(0).bemanAfdeling(this);
                               controller.openTaken.remove(Integer.valueOf(5));
                               return;
                           }    
                       }
                       //afdeling1
                       break;
                   case 6:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Afdeling2_Personeel)
                           {
                               taak = new Taken(Taken.Taak.Afdeling2_Personeel);
                               controller.afdelingen.get(1).setTaak();
                               controller.afdelingen.get(1).bemanAfdeling(this);
                               controller.openTaken.remove(Integer.valueOf(6));
                               return;
                           }  
                       }
                       //afdeling2
                       break;
                   case 7:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Pad1)
                           {
                               taak = new Taken(Taken.Taak.Pad1);
                               controller.afdelingen.get(0).setTaak();
                               controller.openTaken.remove(Integer.valueOf(7));
                               return;
                           }
                       }
                       //pad 1
                       break;
                   case 8:
                       for(Taken t : taken)
                       {
                            if(t.getTaak() == Taken.Taak.Pad2)
                           {
                               taak = new Taken(Taken.Taak.Pad2);
                               controller.afdelingen.get(1).setTaak();
                               controller.openTaken.remove(Integer.valueOf(8));
                               return;
                           }
                       }
                       //pad2
                       break;
                   case 9:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Pad3)
                           {
                               taak = new Taken(Taken.Taak.Pad3);
                               controller.afdelingen.get(2).setTaak();
                               controller.openTaken.remove(Integer.valueOf(9));
                               return;
                           }
                       }
                       //pad3
                       break;
                   case 10:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Pad3)
                           {
                               taak = new Taken(Taken.Taak.Pad4);
                               controller.paden.get(3).wordtGevuld = true;
                               controller.openTaken.remove(Integer.valueOf(10));
                               return;
                           }
                       }
                       //pad4
                       break;
                   case 11:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Voordeelstraat)
                           {
                               taak = new Taken(Taken.Taak.Voordeelstraat);
                               controller.voordeelstraat.setTaak();
                               controller.openTaken.remove(Integer.valueOf(11));
                               return;
                           }
                       }
                       //voordeel
                       break;
                   case 12:
                       for(Taken t : taken)
                       {
                           if(t.getTaak() == Taken.Taak.Vrachtwagen)
                           {
                               taak = new Taken(Taken.Taak.Vrachtwagen);
                               controller.vrachtwagen.wordtGelost = true;
                               controller.openTaken.remove(Integer.valueOf(12));
                               return;
                           }
                       }
                       //vrachtwagen
                       break;
                   case 13:
                       for(Taken t : taken)
                       {
                          if(t.getTaak() == Taken.Taak.Magazijn)
                           {
                               taak = new Taken(Taken.Taak.Magazijn);
                               controller.openTaken.remove(Integer.valueOf(13));
                               return;
                           }
                       }
                       break;
               }
           }
        }
        taak = new Taken(Taken.Taak.Pauze);
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
                        pad.wordtGevuld = false;
                        makeTaak();
                    }
                    return;
                case Pad2:
                    if(controller.paden.size() >= 2)
                    {
                        Pad pad = controller.paden.get(1);
                        if(!pad.vulProduct())
                           return;
                        pad.wordtGevuld = false;
                        makeTaak();
                    }
                    return;
                case Pad3:
                    if(controller.paden.size() >= 3)
                    {
                        Pad pad = controller.paden.get(2);
                        if(!pad.vulProduct())
                           return;
                        pad.wordtGevuld = false;
                        makeTaak();
                    }
                    return;
                case Pad4:
                    if(controller.paden.size() >= 4)
                    {
                        Pad pad = controller.paden.get(3);
                        if(!pad.vulProduct())
                           return;
                        pad.wordtGevuld = false;
                        makeTaak();
                    }
                    return;
                case Afdeling1_Personeel:
                    if(controller.afdelingen.size() >= 1)
                    {
                        Afdeling afdeling = controller.afdelingen.get(0);
                        if(!afdeling.vulProduct()) //<- nog wat voor bedenken
                           return;
                        //afdeling.onbemanAfdeling();
                        //makeTaak();
                    }
                    return;
                case Afdeling2_Personeel:
                    if(controller.afdelingen.size() >= 2)
                    {
                        Afdeling afdeling = controller.afdelingen.get(1);
                        if(!afdeling.vulProduct()) //<-nog wat voor bedenken
                           return;
                        //afdeling.onbemanAfdeling();
                        //makeTaak();
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
                        kassa.onbemanKassa();
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
                        kassa.onbemanKassa();
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
                        kassa.onbemanKassa();
                        makeTaak();
                    }
                    return;
                case Voordeelstraat:
                    if(controller.voordeelstraat != null)
                    {
                        if(!controller.voordeelstraat.vulProduct())
                            return;
                        controller.voordeelstraat.wordtGevuld = false;
                        makeTaak();
                    }
                    return;
                case Vrachtwagen:
                    if(controller.vrachtwagen != null)
                    {
                        if(!controller.vrachtwagen.ontladen())
                            return;
                        controller.vrachtwagen = null;
                        makeTaak();
                    }
                    return;
                case Magazijn:
                    if(controller.vrachtwagen != null)
                    {
                        makeTaak();
                        return;
                    }
                    List<Product> producten = new ArrayList<>();
                    List<ProductWrapper> magazijn = Database.getProducten();
                    magazijn.stream().forEach((p)->
                    {
                        if(p.getAantal() < 5)
                            producten.add(p.getProduct());
                    });
                    controller.requestVrachtwagen(producten);
                    return;
                case Pauze:
                    makeTaak();
                    return;
            }
        }
        Point p = taak.getTaakBeschrijving(positie);
        setPostition(p);  
    }
}
