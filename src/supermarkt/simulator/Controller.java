package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.SwingWorker;

/**
 * De controller klasse van de applicatie
 * @author Niels
 */
public class Controller {

	private final int endDay;
        public static int DAG = 0;
        private final int maxKlanten = 10;
        private static int ronde = 0;
        private Appview view;
	private List<Klant> klanten = new ArrayList<>();
	private List<Personeel> personeel = new ArrayList<>();
        private List<Groep> groepen;
	public List<Pad> paden = new ArrayList<>();
	public List<Afdeling> afdelingen = new ArrayList<>();
	public List<Kassa> kassas = new ArrayList<>();
        private List<Product> producten;
	public Voordeelstraat voordeelstraat;
	public Vrachtwagen vrachtwagen = null;
        public static List<Integer> openTaken = new ArrayList<>();
        public static BordPunt[][] bord = new BordPunt[SupermarkView.aantalBlokjes][SupermarkView.aantalBlokjes];
        public static Voorraad voorraad;
        public Simulatie sim;
        
        /**
         * Maakt de controller aan
         */
        public Controller()
        {
            DAG = Database.getDay();
            producten = Database.getProductTypes();
            groepen = Database.loadGroepen();
            voorraad = new Voorraad();
            view = new Appview(this,DAG);
            if(producten.isEmpty() || groepen.isEmpty())
                System.exit(1);
            createWinkel();
            try
            {
                Thread.sleep(1000);
            }catch(Exception e){};
            endDay = 8000;
            sim = new Simulatie();
            sim.execute();
        }
        
        /**
         * Verwijdert persoon van de lijst en applicatie
         * @param persoon persoon die verwijderd wordt
         */
        public void deletePersoon(Persoon persoon)
        {
            if(persoon instanceof Klant)
                klanten.remove(persoon);
            else if(persoon instanceof Personeel)
                personeel.remove(persoon);
        }

        /**
         * Vraagt vrachtwagen aan
         * @param benodigd lijst met benodigde producten
         */
        public void requestVrachtwagen(List<Product> benodigd)
        {
            vrachtwagen = new Vrachtwagen(benodigd, ronde);
        }

        /**
         * Voert een move ronde uit
         */
	private void makeMove() 
        {
            checkWinkel();
            while(personeel.size() < 6)
            {
                createPersoneel();
            }
            while(klanten.size() < 1 && ronde > 20)
            {
                createKlant();
                break;
            }
            for(int i = 0; i < personeel.size();i++)
            {
                try
                {
                    personeel.get(i).move();
                }
                catch(Exception e){};
            }
            for(int i = 0; i < klanten.size();i++)
            {
                try
                {
                    klanten.get(i).move();
                }
                catch(Exception e){};
            }
            ronde++;
            try
            {
                Thread.sleep(300);
            }catch(Exception e){};
	}
        
        /**
         * Maakt 6 personeelsleden aan
         * lid 1 & 2 zijn overal inzetbaar
         * lid 3 & 4 zitten/vullen de afdelingen
         * lid 5 vult de voordeelstraat en kan achter de kassa zitten
         * lid 6 zit standaard achter de kassa
         */
        private void createPersoneel()
        {
            int size = personeel.size() + 1;
                List<Taken> taken = new ArrayList<>();
                switch (size)
                {
                    case 1:
                        taken.add(new Taken(Taken.Taak.Pad1));
                        taken.add(new Taken(Taken.Taak.Pad2));
                        taken.add(new Taken(Taken.Taak.Pad3));
                        taken.add(new Taken(Taken.Taak.Pad4));
                        taken.add(new Taken(Taken.Taak.Voordeelstraat));
                        taken.add(new Taken(Taken.Taak.Vrachtwagen));
                        taken.add(new Taken(Taken.Taak.Magazijn));
                        taken.add(new Taken(Taken.Taak.Kassa3_Personeel));
                        break;
                    case 2:
                        taken.add(new Taken(Taken.Taak.Pad1));
                        taken.add(new Taken(Taken.Taak.Pad2));
                        taken.add(new Taken(Taken.Taak.Pad3));
                        taken.add(new Taken(Taken.Taak.Pad4));
                        taken.add(new Taken(Taken.Taak.Voordeelstraat));
                        taken.add(new Taken(Taken.Taak.Vrachtwagen));
                        taken.add(new Taken(Taken.Taak.Magazijn));
                        taken.add(new Taken(Taken.Taak.Kassa4_Personeel));
                        break;
                    case 3:
                        taken.add(new Taken(Taken.Taak.Afdeling1_Personeel));
                        taken.add(new Taken(Taken.Taak.Vrachtwagen));
                        break;
                    case 4:
                        taken.add(new Taken(Taken.Taak.Afdeling2_Personeel));
                        taken.add(new Taken(Taken.Taak.Vrachtwagen));
                        break;
                    case 5:
                        taken.add(new Taken(Taken.Taak.Voordeelstraat));
                        taken.add(new Taken(Taken.Taak.Kassa2_Personeel));
                        taken.add(new Taken(Taken.Taak.Magazijn));
                        taken.add(new Taken(Taken.Taak.Vrachtwagen));
                        break;
                    case 6:
                        taken.add(new Taken(Taken.Taak.Kassa1_Personeel));
                        break;
                }
                personeel.add(new Personeel("personeelslid " + size, new Point(23,1), 2,taken, this)); //naam veranderen
        }
        
        /**
         * Klaten worden aangemaakt en in groepen gedeeld
         */
        private void createKlant()
        {
            int size = klanten.size() + 1;
            int randomK = ThreadLocalRandom.current().nextInt(0, groepen.size());
            klanten.add(new Klant("Klant " + size, new Point(1,31), groepen.get(randomK), this)); //naam veranderen
        }

        /**
         * De voordeelstraat wordt aangemaakt
         * De voordeelstraat wordt random gevuld met producten
         */
	private void setVoordeelstraat() 
        {
            List<ProductWrapper> voordeel = new ArrayList<>();
            List<Product> choose = new ArrayList<>(producten);
            if(choose.size() > 0){
            for(int i = 0; i < 2; i++)
            {
                int index = ThreadLocalRandom.current().nextInt(0, choose.size());
                voordeel.add(new ProductWrapper(choose.get(index)));
                choose.remove(index);
            }
            }
            voordeelstraat = new Voordeelstraat(Voordeelstraat.loadVoordeelstraat(),voordeel,5);
	}
        
        /**
         * Controleert over er iets moet gebeuren in de winkel
         */
        private void checkWinkel() //werkt nog niet helemaal goed
        {
            int index = 1;
            boolean needsKassa = false;
            int kassaCount = 0;
            for(Kassa k : kassas)
            {
                if(k.isOpen())
                {
                    kassaCount++;
                    if(k.checkKlanten() > 3)
                    {
                        needsKassa = true;
                        continue;
                    }
                    needsKassa = false;
                }
            }
            if(kassaCount == 0)
                needsKassa = true;
            for(Kassa k : kassas)
            {
                if(!k.isOpen() && needsKassa)
                {
                    if(!openTaken.contains(index))
                    {
                        openTaken.add(index);
                    }
                    needsKassa = false;
                }
                index++;
            }
            for(Afdeling af : afdelingen)
            {
                if(af.productChecken() != null && !af.wordtGevuld || !af.isBemand()) //check mensen
                    if(!openTaken.contains(index))
                        openTaken.add(index);
                index++;
            }
            for(Pad p : paden)
            {
                if(p.productChecken() != null && !p.wordtGevuld)
                    if(!openTaken.contains(index))
                        openTaken.add(index);
                index++;
            }
            if(voordeelstraat.productChecken() != null && !voordeelstraat.wordtGevuld)
                if(!openTaken.contains(index))
                    openTaken.add(index);
            index++;
            if(vrachtwagen != null)
            {
                if(vrachtwagen.getAangeroepen() == ronde && !vrachtwagen.wordtGelost)
                    if(!openTaken.contains(index))
                        openTaken.add(index);
            }
            index++;
        }
        
        /**
         * Haalt de actuele ronde op
         * @return de ronde
         */
        public static int getRonde()
        {
            return ronde;
        }
        
        /**
         * Checkt of er meer personen staan
         * @param p punt 
         * @param persoon persoon
         * @return 1 wanneer er een klant staat, 0 wanneer personeel , -1 wanneer geen een.
         */
        public int staanMeerPersonen(Point p,Persoon persoon)
        {
            for(Klant k : klanten)
            {
                if(k.equals(persoon))
                    continue;
                if(k.positie.equals(p))
                    return 1;
            }
            for(Personeel ps : personeel)
            {
                if(ps.equals(persoon))
                    continue;
                if(ps.positie.equals(p))
                    return 0;
            }
            return -1;
        }

        /**
         * De muren en deuren van de winkel worden in het veld gezet
         */
	private void createWinkel()
        {
            for(int i= 0; i < SupermarkView.aantalBlokjes; i++)
            {
                for(int j = 0; j < SupermarkView.aantalBlokjes; j++)
                {
                    if((j == SupermarkView.aantalBlokjes -1 && i > 0 && i < 3))
                    {
                        bord[i][j] = new BordPunt(i,j,0,view.getSupermarkView());
                    }
                    else if((i == (SupermarkView.aantalBlokjes + 1) / 2 && j < 4 && j > 1))
                    {
                        bord[i][j] = new BordPunt(i,j,0,view.getSupermarkView());
                    }
                    else if((j == 0 && i > SupermarkView.aantalBlokjes - 8 && i < SupermarkView.aantalBlokjes - 2))
                    {
                        bord[i][j] = new BordPunt(i,j,0,view.getSupermarkView());
                    }
                    else if(i == 0 || j == 0 || i == SupermarkView.aantalBlokjes -1 || j == SupermarkView.aantalBlokjes -1 || (j == 5 && i > (SupermarkView.aantalBlokjes + 1) / 2) || (i == (SupermarkView.aantalBlokjes + 1) / 2 && j <=5) || (i > 2 && i < 14 && j == SupermarkView.aantalBlokjes - 5) || (i == SupermarkView.aantalBlokjes - 2 && j == SupermarkView.aantalBlokjes - 5))
                    {
                        bord[i][j] = new BordPunt(i,j,1,view.getSupermarkView());
                    }
                    else
                    {
                        bord[i][j] = new BordPunt(i,j,0,view.getSupermarkView());
                    }
                }
            }
            kassas = Kassa.loadKassa();
            List<List<ProductWrapper>> pws = ProductWrapper.loadProductWrappers();
            paden = Pad.loadPad(pws);
            afdelingen = Afdeling.loadAfdeling(pws);
            afdelingen.stream().forEach((k)->
            {
                k.setMax(Database.getGemiddelde(k));
            });
            setVoordeelstraat();
	}
        
        /**
         * De klasse die de simulatie uitvoerd
         */
        public class Simulatie extends SwingWorker<BordPunt[][], BordPunt[][]>
        {
            private boolean pauze = false;
            
            /**
             * Zet pauze
             */
            public void setPauze()
            {
                pauze = !pauze;
            }
            
            /**
             * Zet resume
             */
            public synchronized void resume() 
            {
                pauze = false;
                this.notify();
            }
            
            /**
             * Verwerkt Lijst met bordpunten
             * @param chunks lijst met bordpunten
             */
            @Override
            protected void process(List<BordPunt[][]> chunks)
            {
                super.process(chunks); //To change body of generated methods, choose Tools | Templates.
            }

            /**
             * Voert de simulatie uit
             * @return bordpunt
             * @throws Exception 
             */
            @Override
            protected BordPunt[][] doInBackground() throws Exception
            {
                while(ronde <= endDay) //andere thread
                {
                    if(pauze)
                    {
                        try 
                        {
                            synchronized(this)
                            {
                                wait(1000);
                            }
                        } 
                        catch (InterruptedException ex) 
                        {
                            System.out.println("Background interrupted");
                        }
                    }
                    else
                    {
                        makeMove();
                    }                 
                }
                return bord;
            }
            
        }
}
