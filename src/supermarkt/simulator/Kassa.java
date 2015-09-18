package supermarkt.simulator;

import java.awt.Point;
import java.util.List;

public class Kassa {

	private Personeel bemand = null;

	private int nummer;

	private List<Point> plaats;

	private int wachtendeKlanten = 0;
        
        public Kassa(int nummer,List<Point> plaats)
        {
            this.nummer = nummer;
            this.plaats = plaats;
        }

	public void bemanKassa(Personeel personeel) 
        {
            this.bemand = personeel;
	}

	public void rekenaf(List<Product> producten) throws Exception
        {
            if(bemand == null)
                throw new Exception("Geen personeel bij kassa");
            //reken af
	}

	public int checkKlanten() 
        {
            return wachtendeKlanten;
	}
        
        public void klantBijKassa()
        {
            wachtendeKlanten++;
        }

}
