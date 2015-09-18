package supermarkt.simulator;

import java.awt.Point;

public abstract class Persoon {

	protected String naam;

	protected Point positie;
        
        public Persoon(String naam,Point beginPositie)
        {
            this.naam = naam;
            this.positie = beginPositie;
        }

	public abstract void move();
}
