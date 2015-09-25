package supermarkt.simulator;

import java.util.List;

/**
 * Groep voor klanten
 * @author Niels
 */
public class Groep {

	private String naam;
	private List<Product> productKeus;
        
        /**
         * Maakt groep aan
         * @param naam de naam van de groep
         * @param productKeus de producten die deze groep klanten koopt
         */
        public Groep(String naam, List<Product> productKeus)
        {
            this.naam = naam;
            this.productKeus = productKeus;
        }

        /**
         * Haalt lijst met de producten op
         * @return de lijst met producten
         */
	public List<Product> getProducten() {
		return productKeus;
	}
}
