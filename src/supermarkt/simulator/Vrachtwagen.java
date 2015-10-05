package supermarkt.simulator;

import java.util.ArrayList;
import java.util.List;

public class Vrachtwagen {

	private List<ProductWrapper> lading = new ArrayList<>();
	private int aangeroepen;
        private boolean isGeregisteerd = false;
        public boolean  wordtGelost = false;
        
        public Vrachtwagen(List<Product> benodigdeProducten, int aangeroepen)
        {
            benodigdeProducten.stream().forEach((p)->
            {
                lading.add(new ProductWrapper(p,50));
            });
            this.aangeroepen = aangeroepen + 10;
        }
        
        public boolean ontladen()
        {
            registeerLading();
            if(lading.isEmpty())
                return true;
            ProductWrapper pw = lading.get(0);
            lading.remove(0);
            return false;
        }

	private void registeerLading() 
        {
            if(!isGeregisteerd)
            {
                //Database.setProducten(lading);
                Controller.voorraad.setProducten(lading);
                isGeregisteerd = true;
            }       
	}

	public int getAangeroepen() 
        {
		return this.aangeroepen;
	}
}
