package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Controller {

	private final int endDay;
        private final int maxKlanten = 10;
        private int ronde = 0;
        private Appview view;
	private List<Klant> klanten = new ArrayList<>();
	private List<Personeel> personeel = new ArrayList<>();
	public List<Pad> paden = new ArrayList<>();
	public List<Afdeling> afdelingen = new ArrayList<>();
	public List<Kassa> kassas = new ArrayList<>();
        private List<Product> producten = new ArrayList<>();
	public Voordeelstraat voordeelstraat;
	public Vrachtwagen vrachtwagen = null;
	private Database voorrraad = new Database();
        public static BordPunt[][] bord = new BordPunt[SupermarkView.aantalBlokjes][SupermarkView.aantalBlokjes];
        
        public Controller()
        {
            view = new Appview();
            createWinkel();
            endDay = 100;
            //set GUI
            //add listener
        }
        
        public void deletePersoon(Persoon persoon)
        {
            if(persoon instanceof Klant)
                klanten.remove(persoon);
            else if(persoon instanceof Personeel)
                personeel.remove(persoon);
        }

	private void saveData() 
        {
            
	}

	private void makeMove() 
        {
            while(personeel.size() < 6){
                //maak personeel aan
            }
            while(klanten.size() < maxKlanten){
                //maak klanten aan
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
            saveData();
            ronde++;
	}

	private void setVoordeelstraat() 
        {
            List<ProductWrapper> voordeel = new ArrayList<>();
            List<Product> choose = new ArrayList<>(producten);
            for(int i = 0; i < 2; i++)
            {
                int index = ThreadLocalRandom.current().nextInt(0, choose.size() -1);
                voordeel.add(new ProductWrapper(choose.get(index)));
                choose.remove(index);
            }
            voordeelstraat = new Voordeelstraat(Voordeelstraat.getVoordeelstraatPoints(),voordeel,5);
	}

	private void createPersonen()
        {
            //load groepen
            //maak klanten
            //maak personeel
	}

	private void createWinkel() 
        {
            for(int i= 0; i < SupermarkView.aantalBlokjes; i++)
            {
                for(int j = 0; j < SupermarkView.aantalBlokjes; j++)
                {
                    if((j == SupermarkView.aantalBlokjes -1 && i > 0 && i < 3))
                    {
                        bord[i][j] = new BordPunt(i,j,2,view.getSupermarkView());
                    }
                    else if((i == (SupermarkView.aantalBlokjes + 1) / 2 && j < 4 && j > 1))
                    {
                        bord[i][j] = new BordPunt(i,j,3,view.getSupermarkView());
                    }
                    else if((j == 0 && i > SupermarkView.aantalBlokjes - 8 && i < SupermarkView.aantalBlokjes - 2))
                    {
                        bord[i][j] = new BordPunt(i,j,4,view.getSupermarkView());
                    }
                    else if(i == 0 || j == 0 || i == SupermarkView.aantalBlokjes -1 || j == SupermarkView.aantalBlokjes -1 || (j == 5 && i > (SupermarkView.aantalBlokjes + 1) / 2) || (i == (SupermarkView.aantalBlokjes + 1) / 2 && j <=5) || (i > 3 && i < 15 && j == SupermarkView.aantalBlokjes - 6))
                    {
                        bord[i][j] = new BordPunt(i,j,1,view.getSupermarkView());
                    }
                    else
                    {
                        bord[i][j] = new BordPunt(i,j,0,view.getSupermarkView());
                    }
                }
            }
            //load kassa's
            //load paden
            //load afdelingen
            //setVoordeelstraat();
            //createPersonen();
	}
}
