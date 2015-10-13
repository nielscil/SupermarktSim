package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
//javaDoc volledig ingevuld
/**
 * De kassa klasse
 * @author Niels
 */
public class Kassa {

	private Personeel bemand = null; //Maak public om te testen
        private List<Klant> rij = new ArrayList<>(); //Maak public om te testen
	private final int nummer;
	private final List<Point> plaats;
        
        /**
         * Maakt de kassa aan
         * @param nummer het kassanummer
         * @param plaats plaats van de kassa
         */
        public Kassa(int nummer,List<Point> plaats)
        {
            this.nummer = nummer;
            this.plaats = plaats;
            for(Point p : plaats)
            {
                kassaPoint(p);
            }
        }
        
        /**
         * Kassa wordt bemand door personeelslid
         * @param personeel personeelslid
         */
	public void bemanKassa(Personeel personeel) 
        {
            this.bemand = personeel;
	}
        
        /**
         * Personeel verlaat kassa
         */
        public void onbemanKassa()
        {
            bemand = null;
        }
        
        /**
         * Rekent de producten in de het lijstje van winkelwagen af
         * @throws Exception als de kassa niet bemand is
         */
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
        
        /**
         * Maakt een lijstje van alle producten, wordt gebruikt in methode 'rekenAf'
         * @param winkelwagen lijst met producten die de klant bij zich heeft
         */
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
                Appview.Log("rekent product " + p.getNaam() + " af van klant " + rij.get(0).naam + " bij kassa " + nummer, bemand);
                i++;
            }
        }
        
        /**
         * Kijkt hoeveel klanten er in de rij staan voor de kassa
         * @return het aantal klanten in de rij
         */
	public int checkKlanten() 
        {
            return rij.size();
	}
        
        /**
         * Kijkt of de kassa open/bemand is
         * @return boolean of de kassa bemand is
         */
        public boolean isOpen()
        {
            return bemand != null;
        }
        
        /**
         * Voegt klanten toe aan de rij bij de kassa
         * @param klant klanten in de rij bij de kassa
         */
        public void klantBijKassa(Klant klant)
        {
            if(!rij.contains(klant))
            {
                rij.add(klant);
            }
        }
        
        /**
         * Kijkt naar welke kassa de klant het beste toe kan
         * @param kassas lijst van kassa's die vergeleken worden
         * @return de index van de beste kassa
         */
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
        
        /**
         * Zet kassa punt
         * @param p punt waar de kassa's staan, de kassa wordt aangegeven dmv SuperMarkView.DrawCell()
         */
        public void kassaPoint(Point p)
        {
            Controller.bord[p.x][p.y].setItem(7);
        }
        
        /**
         * Laadt de punten waar de kassa's komen te staan uit een .txt bestand
         * @return een ArrayList met punten waar kassa's komen te staan
         */
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
            return kassas;
        } 
}
