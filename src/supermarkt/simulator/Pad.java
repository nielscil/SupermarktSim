package supermarkt.simulator;

import java.awt.Point;
import java.util.List;
import java.util.Observable;

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
        }

        public boolean heeftProduct(String naam)
        {
            return ProductWrapper.Search(naam, producten) != -1;
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

}
