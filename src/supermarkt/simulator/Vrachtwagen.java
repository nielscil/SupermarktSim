package supermarkt.simulator;

import java.util.List;

public class Vrachtwagen {

	private List<ProductWrapper> lading;
	private int aangeroepen;

	public List<ProductWrapper> geefLading() {
		return this.lading;
	}

	public int getAangeroepen() {
		return this.aangeroepen;
	}

}
