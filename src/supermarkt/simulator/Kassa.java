package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Kassa {

	private Personeel bemand = null;
        private List<Klant> rij = new ArrayList<>();
	private final int nummer;
	private final List<Point> plaats;
        
        public Kassa(int nummer,List<Point> plaats)
        {
            this.nummer = nummer;
            this.plaats = plaats;
            for(Point p : plaats)
            {
                kassaPoint(p);
            }
        }

	public void bemanKassa(Personeel personeel) 
        {
            this.bemand = personeel;
	}
        
        public void onbemanKassa()
        {
            bemand = null;
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
                Database.lowerWinkelproduct(p);
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
        
        public void kassaPoint(Point p)
        {
            Controller.bord[p.x][p.y].setItem(7);
        }
        
        public static List<Kassa> loadKassa()
        {                    
            List<Kassa> kassas = new ArrayList<>();
            File file = new File("src\\supermarkt\\simulator\\Kassa.txt");
            try
            {
                Scanner sc = new Scanner(file);
                int i = 1;
                while(sc.hasNextLine())
                {
                    List<Point> kassa = new ArrayList<>();
                    while(sc.findInLine("\\s*\\(\\s*(\\d+)\\s*\\,\\s*(\\d+)\\s*\\)") != null) //"\\d+\\s\\d+\\s\\t"
                    {
                        MatchResult result = sc.match();
                        kassa.add(new Point(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2))));
                    }
                    kassas.add(new Kassa(i, kassa));
                    i++;
                    sc.skip("\\s*");
                }
            } catch (Exception e)
            {
                return kassas;
            }
            //inlezen
            //voor elke regel lees punten in
            //maak kassa aan
            //voeg aan lijst toe
            return kassas;
        } 
}
