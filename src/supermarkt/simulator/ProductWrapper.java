package supermarkt.simulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper die een product koppelt met een aantal
 * @author Niels
 */
public class ProductWrapper {

	private Product product; //Maak public voor test!
	private int aantal; //Maak public voor test!
        
        /**
         * Aanmaken van een productwrapper
         * @param product het product van deze productwrapper
         * @param aantal het aantal aanwezig van deze producten
         */
        public ProductWrapper(Product product,int aantal)
        {
            this.product = product;
            this.aantal = aantal;
        }
        
        /**
         * Aanmaken van een productwrapper met aantal 0
         * @param product het product van deze productwrapper
         */
        public ProductWrapper(Product product)
        {
            this(product,0);
        }

        /**
         * Pas het aantal van deze producten aan
         * @param aantal het aantal producten
         */
	public void setAantal(int aantal) 
        {
            this.aantal = aantal;
	}
        
        /**
         * Verhoog het aantal met 1
         */
        public void setAantal()
        {
            this.aantal++;
        }

        /**
         * Zet het product van de productwrapper
         * @param product product voor de wrapper
         */
	public void setProduct(Product product) 
        {
            this.product = product;
	}

        /**
         * Pakt een product uit de wrapper en verlaagt het aantal producten
         * @return product
         * @throws Exception wanneer er geen producten meer zijn
         */
	public Product pakEen() throws Exception
        {
            if(aantal > 0)
            {
                aantal--;
                return product;
            }
            throw new Exception("Is op");
	}

        /**
         * Haalt het aantal op van het product
         * @return aantal
         */
	public int getAantal() 
        {
		return aantal;
	}

        /**
         * Haalt de productnaam op
         * @return productnaam
         */
	public String getProductNaam() 
        {
		return product.getNaam();
	}
        
                public Product getProduct()
        {
            return product;
        }
        
        /**
         * Zoek of bepaald product in een lijst van ProductWrappers zit
         * @param product naam van het product
         * @param lijst de lijst
         * @return de index van het product
         */
        public static int Search(String product,List<ProductWrapper> lijst)
        {
            for(int i = 0; i < lijst.size(); i++)
            {
                String name = lijst.get(i).getProductNaam();
                if(lijst.get(i).getProductNaam().equals(product))
                    return i;
            }
            return -1;
        }
        
        /**
         * Verhoogd het aantal van een bepaald product met 1 in een lijst van ProductWrappers
         * @param product naam van het product
         * @param lijst de lijst met ProductWrappers
         * @return de lijst met toegevoegde
         */
        public static List<ProductWrapper> Add( String product, List<ProductWrapper> lijst)
        {
            int index = Search(product, lijst);
            if(index == -1)
            {
                return lijst;
            }
            ProductWrapper productwrap = lijst.get(index);
            productwrap.setAantal();
            lijst.set(index, productwrap);
            return lijst;
        }
        
        /**
         * Zet het aantal van een bepaald product in een lijst van ProductWrappers
         * @param product de naam van het product
         * @param aantal het aantal van het product
         * @param lijst de lijst van ProductWrappers
         * @return de lijst met het veranderde product aantal
         */
        public static List<ProductWrapper> Add( String product,int aantal ,List<ProductWrapper> lijst)
        {
            int index = Search(product, lijst);
            if(index == -1)
                return lijst;
            ProductWrapper productwrap = lijst.get(index);
            productwrap.setAantal(aantal);
            lijst.set(index, productwrap);
            return lijst;
        }
        
        /**
         * Verhoogd het aantal van een bepaald product met 1 in een lijst van ProductWrappers
         * @param product naam van het product
         * @param lijst de lijst met ProductWrappers
         * @param max maximaal aantal van producten in de te zetten ProductWrapper
         * @return de lijst met het veranderde product aantal
         * @throws Exception wanneer het maximum overschreden wordt
         */
        public static List<ProductWrapper> Add( String product, List<ProductWrapper> lijst,int max) throws Exception
        {
            int index = Search(product, lijst);
            if(index == -1)
                return lijst;            
            ProductWrapper productwrap = lijst.get(index);
            if(productwrap.getAantal()>= max)
                throw new Exception("Stelling is vol");
            productwrap.setAantal();
            lijst.set(index, productwrap);
            return lijst;
        }
        
        /**
         * Zet het aantal van een bepaald product in een lijst van ProductWrappers
         * @param product naam van het product
         * @param aantal het aantal van het product
         * @param lijst de lijst met ProductWrappers
         * @param max het maximale aantal van producten in de te zetten ProductWrapper
         * @return de lijst met het veranderde product aantal
         * @throws Exception wanneer het maximum overschreden wordt
         */
        public static List<ProductWrapper> Add( String product,int aantal ,List<ProductWrapper> lijst,int max) throws  Exception
        {
            int index = Search(product, lijst);
            if(index == -1)
                return lijst;            
            ProductWrapper productwrap = lijst.get(index);
            if(productwrap.getAantal()>= max)
                throw new Exception("Stelling is vol");
            productwrap.setAantal(aantal);
            lijst.set(index, productwrap);
            return lijst;
        }
        
        /**
         * Laad de productwrappers in
         * @return de lijst met de lijst van de productwrappers
         */
        public static List<List<ProductWrapper>> loadProductWrappers()
        {
            List<ProductWrapper> pws = Database.getWinkelproducten();
            List<List<ProductWrapper>> padPws = new ArrayList<>();
            for(int i = 0; i < 6; i++)
            {
                padPws.add(new ArrayList<>());
            }
            pws.stream().forEach((p)->
            {
                if(p.product.getAfdeling() == 1)
                    padPws.get(0).add(p);
                else if(p.product.getAfdeling() == 2)
                    padPws.get(1).add(p);
                else if(p.product.getAfdeling() == 3)
                    padPws.get(2).add(p);
                else if(p.product.getAfdeling() == 4)
                    padPws.get(3).add(p);
                else if(p.product.getAfdeling() == 5)
                    padPws.get(4).add(p);
                else if(p.product.getAfdeling() == 6)
                    padPws.get(5).add(p);
            });
            return padPws;
        }
}
