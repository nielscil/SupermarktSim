package supermarkt.simulator;

import java.awt.Point;
import java.util.List;

/**
 * Een klant van de supermarkt
 * @author Niels
 */
public class Klant extends Persoon {

	private Groep groep;
	private List<ProductWrapper> boodschappenlijst;
	private List<Product> winkelwagen;
        
        /**
         * Maakt nieuwe klant aan
         * @param naam naam van de klant
         * @param beginpositie beginpositie van de klant
         * @param groep de groep van de klant
         */
        public Klant(String naam,Point beginpositie,Groep groep)
        {
            super(naam, beginpositie);
            this.groep = groep;
        }

        /**
         * Maak een boodschappenlijst aan voor de klant
         */
	private void maakBoodschappenlijst() 
        {

	}
        
        /**
         * Pakt een aantal producten uit de paden
         * @param aantal aantal producten
         * @param product naam van het product
         * @param huidigePad de huidige pad
         */
	public void paktProduct(int aantal, String product, Pad huidigePad) 
        {
            for(int i = 0; i < aantal;i++)
            {
                try
                {
                    winkelwagen.add(huidigePad.geefProduct(product));
                }
                catch(Exception e)
                {
                    //doe iets, stelling is leeg.
                }
            }
	}
        
        @Override
        public void move()
        {
            
        }

}
