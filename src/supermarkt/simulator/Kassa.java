package supermarkt.simulator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Kassa {

	private Personeel bemand = null;
        private List<Klant> rij = new ArrayList<>();
	private final int nummer;
	private final List<Point> plaats;
        
        public Kassa(int nummer,List<Point> plaats)
        {
            this.nummer = nummer;
            this.plaats = plaats;
        }

	public void bemanKassa(Personeel personeel) 
        {
            this.bemand = personeel;
	}

	public void rekenAf() throws Exception
        {
            if(bemand == null)
                throw new Exception("Geen personeel bij kassa");
            if(!rij.isEmpty())
            {
                Klant k = rij.get(0);
                rekenAf(k.winkelwagen);
                if(k.winkelwagen.isEmpty())
                    rij.remove(0);
            }
	}
        private void rekenAf(List<Product> winkelwagen)
        {
            int i = 0;
            while(i < 2)
            {
                if(winkelwagen.isEmpty())
                    break;
                Product p = winkelwagen.get(0);
                winkelwagen.remove(0);
                //verander in db
                i++;
            }
        }

	public int checkKlanten() 
        {
            return rij.size();
	}
        
        public boolean isOpen()
        {
            return bemand != null;
        }
        
        public void klantBijKassa(Klant klant)
        {
            if(!rij.contains(klant))
            {
                rij.add(klant);
            }
        }
        
        public static int BesteKassa(List<Kassa> kassas)
        {
            List<Kassa> sortedlist = new ArrayList<>();
            kassas.stream().forEach((k)->
            {
                if(k.isOpen())
                    sortedlist.add(k);
            });
            sortedlist.sort((o1,o2)->
            {
                if(o1.checkKlanten() < o2.checkKlanten())
                        return -1;
                    else if(o1.checkKlanten() > o2.checkKlanten())
                        return 1;
                    else
                        return 0;
            });
            if(sortedlist.isEmpty())
                return -1;
            return sortedlist.get(0).nummer;
        }

}
