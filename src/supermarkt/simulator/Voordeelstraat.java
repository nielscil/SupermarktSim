package supermarkt.simulator;

import java.awt.Point;
import java.util.List;

/**
 * Een voordeelstraat met verschillende voordeel producten
 * @author Niels
 */
public class Voordeelstraat extends Pad 
{
    /**
     * Aanmaken van een voordeelstraat
     * @param plaats de plaats in de supermarkt
     * @param producten de producten die in de voordeelstraat staan
     * @param max maximaal aantal producten
     */
    public Voordeelstraat(List<Point> plaats,List<ProductWrapper> producten,int max)
    {
        super(plaats,producten,max);
    }
    
    /**
     * Vult de product bij in de voordeelstraat
     * @param product naam van het product
     * @throws Exception wanneer de voordeelstraat vol zit
     */
    @Override
    public void vulProduct(String product) throws Exception
    {
        this.producten = ProductWrapper.Add(product, producten, maxProduct);
    }
}
