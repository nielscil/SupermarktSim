package supermarkt.simulator;

import java.awt.Point;

/**
 * Persoon klasse
 * @author Niels
 */
public abstract class Persoon {

	protected String naam;
	protected Point positie;
        protected Controller controller;
        
        /**
         * Maakt persoon aan
         * @param naam naam van persoon
         * @param beginPositie begin positie van het persoon
         * @param controller controller klasse
         */
        public Persoon(String naam,Point beginPositie,Controller controller)
        {
            this.naam = naam;
            this.positie = beginPositie;
            this.controller = controller;
            setPostition(positie);
        }
        
        /**
         * Zet de positie van het persoon
         * @param p positie
         */
        protected abstract void setPostition(Point p);

        /**
         * Voert move uit van persoon
         * @throws Exception wanneer fout in afrekenen etc.
         */
	public abstract void move() throws Exception;
}
