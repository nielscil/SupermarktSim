package supermarkt.simulator;

/**
 * Product klasse
 * @author Niels
 */
public class Product {

	private String naam;
	private double prijs;
	private boolean voordeel;
	private int pad;
        
        /**
         * Maakt product aan
         * @param naam naam van product
         * @param prijs prijs van product
         * @param pad het afdeling/pad
         */
        public Product(String naam, double prijs,int pad)
        {
            this.naam = naam;
            this.prijs = prijs;
            this.pad = pad;
        }

        /**
         * Haalt de naam op van het product
         * @return de naam
         */
	public String getNaam() {
		return this.naam;
	}

        /**
         * Haalt de prijs op van product
         * @return de prijs
         */
	public double getPrijs() {
		return this.prijs;
	}

        /**
         * Checkt of het in de voordeel is
         * @return true wanneer voordeel, false anders
         */
	public boolean isVoordeel() {
		return this.voordeel;
	}

        /**
         * Haalt de afdeling op
         * @return haal het pad op
         */
	public int getAfdeling() {
		return this.pad;
	}

}
