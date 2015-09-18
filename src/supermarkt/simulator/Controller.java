package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Controller {

	private final int endDay;
        private int ronde = 0;
	private List<Klant> klanten = new ArrayList<>();
	private List<Personeel> personeel = new ArrayList<>();
	private List<Pad> paden = new ArrayList<>();
	private List<Afdeling> afdelingen = new ArrayList<>();
	private List<Kassa> kassas = new ArrayList<>();
        private List<Product> producten = new ArrayList<>();
	private Voordeelstraat voordeelstraat;
	private Vrachtwagen vrachtwagen = null;
	private Database voorrraad = new Database();
        
        public Controller()
        {
            createWinkel();
            endDay = 100;
            //set GUI
            //add listener
        }

	private void saveData() 
        {
            
	}

	private void makeMove() 
        {
            personeel.stream().forEach((p) ->
            {
                p.move();
            });
            klanten.stream().forEach((k) ->
            {
                k.move();
            });
            saveData();
            ronde++;
	}

	private void setVoordeelstraat() 
        {             
            //get 2 random products
            voordeelstraat = new Voordeelstraat(new ArrayList<Point>(),new ArrayList<ProductWrapper>(),0);
	}

	private void createPersonen() 
        {
            
	}

	private void createWinkel() 
        {
            //load view
            //set observer
            //load kassa's
            //load paden
            //load afdelingen
            setVoordeelstraat();
            createPersonen(); 
	}
}
