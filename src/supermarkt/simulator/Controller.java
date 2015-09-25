package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {

	private final int endDay;
        public static int DAG = 0;
        private final int maxKlanten = 10;
        private int ronde = 0;
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
        public List<Integer> openTaken = new ArrayList<>();
        public static BordPunt[][] bord = new BordPunt[SupermarkView.aantalBlokjes][SupermarkView.aantalBlokjes];
        
        public Controller()
        {
            view = new Appview();
            DAG = Database.getDay();
            producten = Database.getProductTypes();
            groepen = Database.loadGroepen();
            if(producten.isEmpty() || groepen.isEmpty())
                System.exit(1);
            createWinkel();
            try
            {
                Thread.sleep(1000);
            }catch(Exception e){};
            endDay = 8000;
            while(ronde <= endDay) //andere thread
            {
                makeMove();
            }
        }
        
        public void deletePersoon(Persoon persoon)
        {
            if(persoon instanceof Klant)
                klanten.remove(persoon);
            else if(persoon instanceof Personeel)
                personeel.remove(persoon);
        }

        
        public void requestVrachtwagen(List<Product> benodigd)
        {
            vrachtwagen = new Vrachtwagen(benodigd, ronde);
        }

	private void makeMove() 
        {
            checkWinkel();
            while(personeel.size() < 6)
            {
                createPersoneel();
            }
            while(klanten.size() < maxKlanten && ronde > 20)
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
                    case 4:
                        taken.add(new Taken(Taken.Taak.Afdeling2_Personeel));
                        taken.add(new Taken(Taken.Taak.Vrachtwagen));
                    case 5:
                        taken.add(new Taken(Taken.Taak.Voordeelstraat));
                        taken.add(new Taken(Taken.Taak.Kassa2_Personeel));
                        taken.add(new Taken(Taken.Taak.Magazijn));
                        taken.add(new Taken(Taken.Taak.Vrachtwagen));
                    case 6:
                        taken.add(new Taken(Taken.Taak.Kassa1_Personeel));                   
                }
                personeel.add(new Personeel("personeelslid " + size, new Point(23,1), 2,taken, this)); //naam veranderen
        }
        
        private void createKlant()
        {
            int size = klanten.size() + 1;
            int randomK = ThreadLocalRandom.current().nextInt(0, groepen.size());
            klanten.add(new Klant("Klant " + size, new Point(1,31), groepen.get(randomK), this)); //naam veranderen
        }

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
        
        private void checkWinkel() //werkt nog niet helemaal goed
        {
            openTaken.clear();
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
                    openTaken.add(index);
                    needsKassa = false;
                }
                index++;
            }
            for(Afdeling af : afdelingen)
            {
                if(af.productVullen() != null && !af.wordtGevuld || !af.isBemand()) //check mensen
                    openTaken.add(index);
                index++;
            }
            for(Pad p : paden)
            {
                if(p.productVullen() != null && !p.wordtGevuld)
                    openTaken.add(index);
                index++;
            }
            if(voordeelstraat.productVullen() != null && !voordeelstraat.wordtGevuld)
                openTaken.add(index);
            index++;
            if(vrachtwagen != null)
            {
                if(vrachtwagen.getAangeroepen() == ronde && !vrachtwagen.wordtGelost)
                    openTaken.add(index);
            }
            index++;
            if(ronde % 10 == 0)
                openTaken.add(index);
        }
        
        public int staanMeerPersonen(Point p)
        {
            for(Klant k : klanten)
            {
                if(k.positie.equals(p))
                    return 1;
            }
            for(Personeel ps : personeel)
            {
                if(ps.positie.equals(p))
                    return 0;
            }
            return -1;
        }

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
            setVoordeelstraat();
	}
}
