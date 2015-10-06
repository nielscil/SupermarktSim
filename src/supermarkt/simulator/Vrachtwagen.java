package supermarkt.simulator;

import java.util.ArrayList;
import java.util.List;
//javaDoc volledig ingevuld
/**
 * De vrachtwagen die voorraad aan komt vullen
 * @author Joris
 */
public class Vrachtwagen {

	private List<ProductWrapper> lading = new ArrayList<>(); //Maak public voor test
	private int aangeroepen; //Maak public voor test
        private boolean isGeregisteerd = false;
        public boolean  wordtGelost = false;
        
        /**
         * Maakt vrachtwagen aan
         * @param benodigdeProducten producten die de vrachtwagen moet leveren
         * @param aangeroepen Kijkt welke ronde de vrachtwagen aangeroepen wordt
         */
        public Vrachtwagen(List<Product> benodigdeProducten, int aangeroepen)
        {
            benodigdeProducten.stream().forEach((p)->
            {
                lading.add(new ProductWrapper(p,50));
            });
            this.aangeroepen = aangeroepen + 10;
        }
        
        /**
         * kijkt of de vrachtwagen uitgeladen wordt
         */
        public boolean ontladen()
        {
            registeerLading();
            if(lading.isEmpty())
                return true;
            ProductWrapper pw = lading.get(0);
            lading.remove(0);
            return false;
        }
        
        /**
         * Zet producten in de voorraad
         */
	private void registeerLading() 
        {
            if(!isGeregisteerd)
            {
                //Database.setProducten(lading);
                Controller.voorraad.setProducten(lading);
                isGeregisteerd = true;
            }       
	}

        /**
         * Geeft de ronde waarin de vrachtwagen aan komt
         * @return de ronde, dit is een getal
         */
	public int getAangeroepen() 
        {
		return this.aangeroepen;
	}
}
