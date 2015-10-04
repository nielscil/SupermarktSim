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
        protected boolean wordtGevuld = false;
        private String logString = "";
        
        /**
         * Maakt een nieuw pad aan
         * @param plaats de plek van het pad in de winkel 
         * @param producten de producten met aantallen in dit pad
         * @param logString de string die wordt gebruikt om aan te geven dat het in dit pad gebeurd
         * @param max maximaal aantal per product in dit pad
         */
        public Pad(List<Point> plaats,List<ProductWrapper> producten,int max,String logString)
        {
            this.plaats = plaats;
            this.producten = new ArrayList<>(producten);
            this.maxProduct = max;
            this.logString = logString;
            this.setChanged();
            this.notifyObservers();
            plaats.stream().forEach((p)->
            {
                padPoint(p);
            });
        }

        public boolean heeftProduct(String naam)
        {
            return ProductWrapper.Search(naam, producten) != -1;
        }
        /**
         * Geef een product vanuit het pad aan de klant
         * @param product het gevraagde product
         * @param klant de klant die het product wil
         * @return het product wat wordt gegeven
         * @throws Exception wanneer de voordeelstraat vol zit
         */
	public Product geefProduct(String product,Klant klant) throws Exception
        {
                int index = ProductWrapper.Search(product, producten);
                ProductWrapper pw = this.producten.get(index);
                Product p = this.producten.get(index).pakEen();
                Appview.Log("pakt " + pw.getProductNaam() + " uit " + logString, klant);
		return p;
	}

        /**
         * Vul een product in het pad door een personeelslid
         * @param p het personeelslid die het pad vult
         * @return true als hij klaar is met vullen , anders false
         * @throws Exception wanneer de voordeelstraat vol zit
         */
	public boolean vulProduct(Personeel p) throws Exception
        {
            String product = productVullen();
            
            if(product == null)
            {
                return true;
            }
            if(!Controller.voorraad.checkProduct(product))
            {
                if(!Controller.openTaken.contains(13))
                        Controller.openTaken.add(13);
                return true;
            }
            Appview.Log("Heeft " + product + " bij gevuld in " + logString, p);
            try
            {
                Controller.voorraad.lowerProduct(product);
                //Database.setWinkelproduct(product);
                this.producten = ProductWrapper.Add(product, producten,maxProduct);
            }
            catch(Exception e)
            {
                if(!e.getMessage().equals("Stelling is vol"))
                {
                    if(!Controller.openTaken.contains(13))
                        Controller.openTaken.add(13);
                }
                return true;   
            }
            return false;
	}
        
        public void setTaak()
        {
            wordtGevuld = true;
        }
        
        public void unsetTaak()
        {
            wordtGevuld = false;
        }
        
        protected void padPoint(Point p)
        {
            Controller.bord[p.x][p.y].setItem(8);    
        }
        
        public static List<Pad> loadPad(List<List<ProductWrapper>> pws)
        {                    
            List<Pad> paden = new ArrayList<>();
            File file = new File("src\\supermarkt\\simulator\\Pad.txt");
            try
            {
                Scanner sc = new Scanner(file);
                int i = 2;
                while(sc.hasNextLine())
                {
                    List<Point> pad = new ArrayList<>();
                    while(sc.findInLine("\\s*\\(\\s*(\\d+)\\s*\\,\\s*(\\d+)\\s*\\)") != null) //"\\d+\\s\\d+\\s\\t"
                    {
                        MatchResult result = sc.match();
                        pad.add(new Point(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2))));
                    }
                    paden.add(new Pad(pad, pws.get(i) ,10,"Pad " + (i - 1)));
                    i++;
                    sc.skip("\\s*");
                }
            } 
            catch (Exception e)
            {
                return paden;
            }
            return paden;
        } 
        
        public String productChecken()
        {
            
            for(ProductWrapper product : producten)
            {
                if(product.getAantal() < 3)
                {
                    return product.getProductNaam();
                }
            }
            return null;
        }
        
        public String productVullen()
        {
            
            for(ProductWrapper product : producten)
            {
                if(product.getAantal() < maxProduct)
                {
                    return product.getProductNaam();
                }
            }
            return null;
        }
}
