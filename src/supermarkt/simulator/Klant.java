package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Een klant van de supermarkt
 * @author Niels
 */
public class Klant extends Persoon {

	private final Groep groep;
	private List<ProductWrapper> boodschappenlijst;
	public List<Product> winkelwagen = new ArrayList<>();
        private Taken taak;
        
        
        /**
         * Maakt nieuwe klant aan
         * @param naam naam van de klant
         * @param beginpositie beginpositie van de klant
         * @param groep de groep van de klant
         * @param controller de controller
         */
        public Klant(String naam,Point beginpositie,Groep groep,Controller controller)
        {
            super(naam, beginpositie,controller);
            this.groep = groep;
            maakBoodschappenlijst();
        }

        /**
         * Maak een boodschappenlijst aan voor de klant
         */
	private void maakBoodschappenlijst()
        {
            boodschappenlijst = new ArrayList<>();
            List<Product> producten = new ArrayList<>(groep.getProducten());
            int aantalP = ThreadLocalRandom.current().nextInt(1, producten.size());
            int prod;
            int aantalPP;
            for(int i = 0; i < aantalP; i++)
            {
                prod = ThreadLocalRandom.current().nextInt(0, producten.size());
                Product product = groep.getProducten().get(prod);
                producten.remove(product);
                aantalPP = ThreadLocalRandom.current().nextInt(1, 4);
                boodschappenlijst.add(new ProductWrapper(product, aantalPP));
            }
	}
        
        @Override
        protected void setPostition(Point p)
        {
            if(Controller.bord[0][0] != null)
            {
                int meer = controller.staanMeerPersonen(positie,this);
                if(meer == -1)
                    Controller.bord[positie.x][positie.y].setItem(0);
                else if(meer == 0)
                    Controller.bord[positie.x][positie.y].setItem(10);
            }
            this.positie = p;
            if(Controller.bord[0][0] != null)
            {
                Controller.bord[p.x][p.y].setItem(9);
            }
        }
        
        /**
         * Pakt een aantal producten uit de paden
         * @param aantal aantal producten
         * @param product naam van het product
         * @param huidigePad de huidige pad
         * @return aantal items gepakt
         */
	public int paktProduct(int aantal, String product, Pad huidigePad) 
        {
            int pakken = aantal > 2 ? 2 : aantal;
            for(int i = 0; i < pakken ;i++)
            {
                try
                {
                    winkelwagen.add(huidigePad.geefProduct(product,this));
                }
                catch(Exception e)
                {
                    //doe iets, stelling is leeg.
                    return i;
                }
            }
            return pakken;
	}
        
        private void makeTaak()
        {
            if(!boodschappenlijst.isEmpty())
            {
                ProductWrapper pw = boodschappenlijst.get(0);
                if(controller.voordeelstraat.heeftProduct(pw.getProductNaam()))
                {
                    taak = new Taken(Taken.Taak.Voordeelstraat);
                    return;
                }
                if(controller.paden.size() >=4 )
                {
                    if(controller.paden.get(0).heeftProduct(pw.getProductNaam()))
                    {
                        taak = new Taken(Taken.Taak.Pad1);
                        return;
                    }
                    if(controller.paden.get(1).heeftProduct(pw.getProductNaam()))
                    {
                        taak = new Taken(Taken.Taak.Pad2);
                        return;
                    }
                    if(controller.paden.get(2).heeftProduct(pw.getProductNaam()))
                    {
                        taak = new Taken(Taken.Taak.Pad3);
                        return;
                    }
                    if(controller.paden.get(3).heeftProduct(pw.getProductNaam()))
                    {
                        taak = new Taken(Taken.Taak.Pad4);
                        return;
                    }
                }
                if(controller.afdelingen.size() >= 2)
                {
                    if(controller.afdelingen.get(0).heeftProduct(pw.getProductNaam()))
                    {
                        taak = new Taken(Taken.Taak.Afdeling1);
                        return;
                    }
                    if(controller.afdelingen.get(1).heeftProduct(pw.getProductNaam()))
                    {
                        taak = new Taken(Taken.Taak.Afdeling2);
                        return;
                    }
                }
            }
            if(!winkelwagen.isEmpty())
            {
                int nr = Kassa.BesteKassa(controller.kassas);
                switch(nr)
                {
                    case 1:
                        taak = new Taken(Taken.Taak.Kassa1);
                        return;
                    case 2:
                        taak = new Taken(Taken.Taak.Kassa2);
                        return;
                    case 3:
                        taak = new Taken(Taken.Taak.Kassa3);
                        return;
                    case 4:
                        taak = new Taken(Taken.Taak.Kassa4);
                        return;
                }               
            }
            taak = new Taken(Taken.Taak.Uitgang);
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
                           ProductWrapper pw = boodschappenlijst.get(0);
                           if(pad.heeftProduct(pw.getProductNaam()))
                           {
                               int aantal = pw.getAantal();
                               int gepakt = paktProduct(aantal, pw.getProductNaam(),pad);
                               pw.setAantal(aantal - gepakt);
                               if(aantal == gepakt)
                               {
                                   boodschappenlijst.remove(0);
                                   taak = null;
                               } 
                               return;
                           }
                        }
                        return;
                    case Pad2:
                        if(controller.paden.size() >= 2)
                        {
                           Pad pad = controller.paden.get(1);
                           ProductWrapper pw = boodschappenlijst.get(0);
                           if(pad.heeftProduct(pw.getProductNaam()))
                           {
                               int aantal = pw.getAantal();
                               int gepakt = paktProduct(aantal, pw.getProductNaam(),pad);
                               pw.setAantal(aantal - gepakt);
                               if(aantal == gepakt)
                               {
                                   boodschappenlijst.remove(0);
                                   taak = null;
                               } 
                               return;
                           }
                        }
                        return;
                    case Pad3:
                        if(controller.paden.size() >= 3)
                        {
                           Pad pad = controller.paden.get(2);
                           ProductWrapper pw = boodschappenlijst.get(0);
                           if(pad.heeftProduct(pw.getProductNaam()))
                           {
                               int aantal = pw.getAantal();
                               int gepakt = paktProduct(aantal, pw.getProductNaam(),pad);
                               pw.setAantal(aantal - gepakt);
                                                              if(aantal == gepakt)
                               {
                                   boodschappenlijst.remove(0);
                                   taak = null;
                               } 
                               return;
                           }
                        }
                        return;
                    case Pad4:
                        if(controller.paden.size() >= 4)
                        {
                           Pad pad = controller.paden.get(3);
                           ProductWrapper pw = boodschappenlijst.get(0);
                           if(pad.heeftProduct(pw.getProductNaam()))
                           {
                               int aantal = pw.getAantal();
                               int gepakt = paktProduct(aantal, pw.getProductNaam(),pad);
                               pw.setAantal(aantal - gepakt);
                               if(aantal == gepakt)
                               {
                                   boodschappenlijst.remove(0);
                                   taak = null;
                               } 
                               return;
                           }
                        }
                        return;
                    case Voordeelstraat:
                        if(controller.voordeelstraat != null)
                        {
                            ProductWrapper pw = boodschappenlijst.get(0);
                           if(controller.voordeelstraat.heeftProduct(pw.getProductNaam()))
                           {
                               int aantal = pw.getAantal();
                               int gepakt = paktProduct(aantal, pw.getProductNaam(),controller.voordeelstraat); // <- kijken of dit goed gaat!
                               pw.setAantal(aantal - gepakt);
                               if(aantal == gepakt)
                               {
                                   boodschappenlijst.remove(0);
                                   taak = null;
                               } 
                               return;
                           }
                        }
                        return;
                    case Afdeling1:
                        if(controller.afdelingen.size() >= 1)
                        {
                            Afdeling af = controller.afdelingen.get(0);
                            ProductWrapper pw = boodschappenlijst.get(0);
                           if(af.heeftProduct(pw.getProductNaam()))
                           {
                               int aantal = pw.getAantal();
                               int gepakt = paktProduct(aantal, pw.getProductNaam(),af); // <- kijken of dit goed gaat!
                               pw.setAantal(aantal - gepakt);
                               if(aantal == gepakt)
                               {
                                   boodschappenlijst.remove(0);
                                   taak = null;
                               } 
                               return;
                           }
                        }
                        return;
                    case Afdeling2:
                        if(controller.afdelingen.size() >= 2)
                        {
                            Afdeling af = controller.afdelingen.get(1);
                            ProductWrapper pw = boodschappenlijst.get(0);
                           if(af.heeftProduct(pw.getProductNaam()))
                           {
                               int aantal = pw.getAantal();
                               int gepakt = paktProduct(aantal, pw.getProductNaam(),af); // <- kijken of dit goed gaat!
                               pw.setAantal(aantal - gepakt);
                               if(aantal == gepakt)
                               {
                                   boodschappenlijst.remove(0);
                                   taak = null;
                               }
                               return;
                           }
                        }
                        return;
                    case Kassa1:
                        if(controller.kassas.size() >= 1)
                        {
                            if(!winkelwagen.isEmpty())
                            {
                                if(!controller.kassas.get(0).isOpen())
                                {
                                    taak = null;
                                    return;
                                }
                                controller.kassas.get(0).klantBijKassa(this);
                                return;
                            }
                            taak = new Taken(Taken.Taak.Uitgang);
                        }
                        return;
                    case Kassa2:
                        if(controller.kassas.size() >= 2)
                        {
                            if(!winkelwagen.isEmpty())
                            {
                                if(!controller.kassas.get(1).isOpen())
                                {
                                    taak = null;
                                    return;
                                }
                                controller.kassas.get(1).klantBijKassa(this);
                                return;
                            }
                            taak = new Taken(Taken.Taak.Uitgang);
                        }
                        return;
                    case Kassa3:
                        if(controller.kassas.size() >= 3)
                        {
                            if(!winkelwagen.isEmpty())
                            {
                                if(!controller.kassas.get(2).isOpen())
                                {
                                    taak = null;
                                    return;
                                }
                                controller.kassas.get(2).klantBijKassa(this);
                                return;
                            }
                            taak = new Taken(Taken.Taak.Uitgang);
                        }
                        return;
                    case Kassa4:
                        if(controller.kassas.size() >= 4)
                        {
                            if(!winkelwagen.isEmpty())
                            {
                                if(!controller.kassas.get(3).isOpen())
                                {
                                    taak = null;
                                    return;
                                }
                                controller.kassas.get(3).klantBijKassa(this);
                                return;
                            }
                            taak = new Taken(Taken.Taak.Uitgang);
                        }
                        return;
                    default:
                        Controller.bord[positie.x][positie.y].setItem(0);
                        controller.deletePersoon(this);
                        return;
                }
            }
            Point p = taak.getTaakBeschrijving(positie);
            setPostition(p);       
        }

}
