package supermarkt.simulator;

import java.awt.Point;

public abstract class Persoon {

	protected String naam;
	protected Point positie;
        protected Controller controller;
        
        public Persoon(String naam,Point beginPositie,Controller controller)
        {
            this.naam = naam;
            this.positie = beginPositie;
            this.controller = controller;
            setPostition(positie);
        }
        
        protected abstract void setPostition(Point p);

	public abstract void move() throws Exception;
}
