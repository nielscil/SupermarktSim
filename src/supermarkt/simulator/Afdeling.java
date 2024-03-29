package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
//javaDoc volledig ingevuld
/**
 * Afdeling is een onderdeel van de winkel
 * @author Niels
 */
public class Afdeling extends Pad {

	private final String naam;
        private Personeel personeel = null;
	// public Personeel personeel = null; //Public om te testen
        
        /**
         * Maakt een afdeling aan
         * @param naam de naam van de afdeling
         * @param plaats de plaats van de afdeling
         * @param producten de producten op de afdeling
         * @param max maximum producten in de stelling
         */
        public Afdeling(String naam,List<Point> plaats, List<ProductWrapper> producten,int max)
        {
            super(plaats,producten,max,naam + " Afdeling");
            this.naam = naam;
            plaats.stream().forEach((p)->
            {
                padPoint(p);
            });
        }
        
        /**
         * Geeft de punten van de afdelingen op het spelbord
         * Kaas afdeling heeft een andere kleur dan de vers afdeling
         * @param p punt in het brod
         */
        @Override
        public void padPoint(Point p)
        {
            if(naam == null)
                return;
            if(naam.equals("Kaas"))
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
         */
	public void bemanAfdeling(Personeel personeel)
        {
            if(this.personeel == null)
            {
                this.personeel = personeel;
                wordtGevuld = true;
            }
                
	}
        /**
         * Zet het maximale aantal producten in de afdeling
         * @param max maximale aantal producten
         */
        public void setMax(int max)
        {
            maxProduct = max;
        }

        /**
         * Onbeman de afdeling
         */
        public void onbemanAfdeling()
        {
            this.personeel = null;
            wordtGevuld = false;
        }
        
        /**
         * Check of de afdeling bemand is
         */
        public boolean isBemand()
        {
            return personeel != null;
        }
        
        /**
         * Haalt naam op van de afdeling
         * @return naam
         */
        public String getNaam()
        {
            return naam;
        }
        
        /**
         * Laadt de punten waar de afdelingen komen te staan uit een .txt bestand
         * @param productWrappers Lijst van producten op de afdelingen
         * @return een ArrayList met punten waar de afdelingen komen te staan
         */
        public static List<Afdeling> loadAfdeling(List<List<ProductWrapper>> productWrappers)
        {                    
            List<Afdeling> afdelingen = new ArrayList<>();
            File file = new File("src\\supermarkt\\simulator\\Afdeling.txt");
            try
            {
                Scanner sc = new Scanner(file);
                int i = 0;
                String naam = "Kaas";
                while(sc.hasNextLine())
                {
                    List<Point> afdeling = new ArrayList<>();
                    while(sc.findInLine("\\s*\\(\\s*(\\d+)\\s*\\,\\s*(\\d+)\\s*\\)") != null) //"\\d+\\s\\d+\\s\\t"
                    {
                        MatchResult result = sc.match();
                        afdeling.add(new Point(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2))));
                    }
                    afdelingen.add(new Afdeling(naam, afdeling, productWrappers.get(i) ,10));
                    i++;
                    naam = "Vers";
                    sc.skip("\\s*");
                }
            } 
            catch (Exception e)
            {
                return afdelingen;
            }
            return afdelingen;
        } 

}
