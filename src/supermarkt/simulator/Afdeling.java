package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

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
            for(Point p : plaats)
            {
                padPoint(p);
            }
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
        
        public static List<Afdeling> loadAfdeling()
        {                    
            List<Afdeling> afdelingen = new ArrayList<>();
            File file = new File("src\\supermarkt\\simulator\\Afdeling.txt");
            try
            {
                Scanner sc = new Scanner(file);
                int i = 1;
                String naam = "Kaas";
                while(sc.hasNextLine())
                {
                    List<Point> afdeling = new ArrayList<>();
                    while(sc.findInLine("\\s*\\(\\s*(\\d+)\\s*\\,\\s*(\\d+)\\s*\\)") != null) //"\\d+\\s\\d+\\s\\t"
                    {
                        MatchResult result = sc.match();
                        afdeling.add(new Point(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2))));
                    }
                    afdelingen.add(new Afdeling(naam, afdeling, new ArrayList<ProductWrapper>() ,4));
                    i++;
                    naam = "Vers";
                    sc.skip("\\s*");
                }
            } 
            catch (Exception e)
            {
                return afdelingen;
            }
            //inlezen
            //voor elke regel lees punten in
            //maak kassa aan
            //voeg aan lijst toe
            return afdelingen;
        } 

}
