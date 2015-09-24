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
            endDay = 6000;
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

	private void makeMove() 
        {
            while(personeel.size() < 6)
            {
                int size = personeel.size() + 1;
                personeel.add(new Personeel("personeelslid " + size, new Point(23,1), 2, this)); //naam veranderen
            }
            while(klanten.size() < maxKlanten)
            {
                int size = klanten.size() + 1;
                int randomK = ThreadLocalRandom.current().nextInt(0, groepen.size());
                klanten.add(new Klant("Klant " + size, new Point(1,31), groepen.get(randomK), this)); //naam veranderen
            }
            personeel.stream().forEach((p) ->
            {
                try
                {
                    p.move();
                }
                catch(Exception e){};
            });
            klanten.stream().forEach((k) ->
            {
                try
                {
                    k.move();
                }
                catch(Exception e){};
            });
            ronde++;
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
