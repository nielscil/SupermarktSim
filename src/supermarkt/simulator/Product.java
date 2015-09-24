package supermarkt.simulator;

public class Product {

	private String naam;
	private double prijs;
	private boolean voordeel;
	private int afdeling;
        
        public Product(String naam, double prijs,int isAfdeling)
        {
            this.naam = naam;
            this.prijs = prijs;
            this.afdeling = isAfdeling;
        }

	public String getNaam() {
		return this.naam;
	}

	public double getPrijs() {
		return this.prijs;
	}

	public boolean isVoordeel() {
		return this.voordeel;
	}

	public int getAfdeling() {
		return this.afdeling;
	}

}
