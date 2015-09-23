package supermarkt.simulator;

import java.awt.Point;
import java.util.List;

/**
 * Afdeling is een onderdeel van de winkel
 * @author Niels
 */
public class Afdeling extends Pad {

	private final String naam;
	private Personeel personeel = null;
        
        /**
         * Maakt een afdeling aan
         * @param naam de naam van de afdeling
         * @param plaats de plaats van de afdeling
         * @param producten de producten op de afdeling
         * @param max maximum producten in de stelling
         */
        public Afdeling(String naam,List<Point> plaats, List<ProductWrapper> producten,int max)
        {
            super(plaats,producten,max);
            this.naam = naam;
        }
        
        @Override
        public void padPoint(Point p)
        {
            if(naam == "Kaas")
            {
                Controller.bord[p.x][p.y].setItem(5);
            }
            else
            {
                Controller.bord[p.x][p.y].setItem(6);
            }
            
        }
        /**
         * Deze methode aanroepen op het moment dat een personeelslid 
         * de afdeling wil gaan bedienen.
         * @param personeel personeelslid die de afdeling bemand
         * @throws Exception wanneer afdeling al bemand is
         */
	public void bemanAfdeling(Personeel personeel) throws Exception
        {
            if(this.personeel == null)
                this.personeel = personeel;
            else
                throw new Exception("Al bemand");
	}

}
