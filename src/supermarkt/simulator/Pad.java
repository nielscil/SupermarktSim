package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * Een pad met verschillende producten
 * @author Niels
 */
public class Pad extends Observable
{

	protected List<ProductWrapper> producten;
	protected int maxProduct;
	protected List<Point> plaats;
        
        /**
         * Maakt een nieuw pad aan
         * @param plaats de plek van het pad in de winkel 
         * @param producten de producten met aantallen in dit pad
         * @param max maximaal aantal per product in dit pad
         */
        public Pad(List<Point> plaats,List<ProductWrapper> producten,int max)
        {
            this.plaats = plaats;
            this.producten = producten;
            this.maxProduct = max;
            this.setChanged();
            this.notifyObservers();
            for(Point p : plaats)
            {
                padPoint(p);
            }
        }

        /**
         * Geef een product vanuit het pad aan de klant
         * @param product het gevraagde product
         * @return het product wat wordt gegeven
         * @throws Exception wanneer de voordeelstraat vol zit
         */
	public Product geefProduct(String product) throws Exception
        {
                int index = ProductWrapper.Search(product, producten);
		return this.producten.get(index).pakEen();
	}

        /**
         * Vul een product in het pad door een personeelslid
         * @param product het product
         * @throws Exception wanneer de voordeelstraat vol zit
         */
	public void vulProduct(String product) throws Exception
        {
            this.producten = ProductWrapper.Add(product, producten,maxProduct);
	}
        
        public void padPoint(Point p)
        {
            Controller.bord[p.x][p.y].setItem(8);    
        }
        
        public static List<Pad> loadPad()
        {                    
            List<Pad> paden = new ArrayList<>();
            File file = new File("src\\supermarkt\\simulator\\Pad.txt");
            try
            {
                Scanner sc = new Scanner(file);
                int i = 1;
                while(sc.hasNextLine())
                {
                    List<Point> pad = new ArrayList<>();
                    while(sc.findInLine("\\s*\\(\\s*(\\d+)\\s*\\,\\s*(\\d+)\\s*\\)") != null) //"\\d+\\s\\d+\\s\\t"
                    {
                        MatchResult result = sc.match();
                        pad.add(new Point(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2))));
                    }
                    paden.add(new Pad(pad, new ArrayList<ProductWrapper>() ,4));
                    i++;
                    sc.skip("\\s*");
                }
            } 
            catch (Exception e)
            {
                return paden;
            }
            //inlezen
            //voor elke regel lees punten in
            //maak kassa aan
            //voeg aan lijst toe
            return paden;
        } 

}
