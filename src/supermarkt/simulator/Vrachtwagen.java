package supermarkt.simulator;

import java.util.List;

public class Vrachtwagen {

	private List<ProductWrapper> lading;
	private int aangeroepen;
        private boolean isGeregisteerd = false;
        public boolean  wordtGelost = false;
        
        public Vrachtwagen(List<Product> benodigdeProducten, int aangeroepen)
        {
            benodigdeProducten.stream().forEach((p)->
            {
                lading.add(new ProductWrapper(p, 20));
            });
            this.aangeroepen = aangeroepen + 10;
        }
        
        public boolean ontladen()
        {
            registeerLading();
            ProductWrapper pw = lading.get(0);
            lading.remove(0);
            if(lading.isEmpty())
                return true;
            return false;
        }

	private void registeerLading() 
        {
            if(!isGeregisteerd)
            {
                Database.setProducten(lading);
                isGeregisteerd = true;
            }       
	}

	public int getAangeroepen() 
        {
		return this.aangeroepen;
	}
}
