package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Kassa {

	private Personeel bemand = null;

	private int nummer;

	private List<Point> plaats;

	private int wachtendeKlanten = 0;
        
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
