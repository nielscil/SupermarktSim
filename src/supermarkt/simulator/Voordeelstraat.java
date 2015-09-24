package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

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
        plaats.stream().forEach((p)->
        {
            padPoint(p);
        });
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
    
    @Override
    public void padPoint(Point p)
    {
            Controller.bord[p.x][p.y].setItem(11);
    }
    
    public static List<Point> loadVoordeelstraat()
        {                    
            List<Point> voordeelstraat = new ArrayList<>();
            File file = new File("src\\supermarkt\\simulator\\Voordeelstraat.txt");
            try
            {
                Scanner sc = new Scanner(file);
                while(sc.findInLine("\\s*\\(\\s*(\\d+)\\s*\\,\\s*(\\d+)\\s*\\)") != null) //"\\d+\\s\\d+\\s\\t"
                {
                    MatchResult result = sc.match();
                    voordeelstraat.add(new Point(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2))));
                }
            } catch (Exception e)
            {
                return voordeelstraat;
            }
            return voordeelstraat;
        } 
}
