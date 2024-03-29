package supermarkt.simulator;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
//javaDoc volledig ingevuld
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
        super(plaats,producten,max,"Voordeelstraat");
        plaats.stream().forEach((p)->
        {
            padPoint(p);
        });
    }
    
    /**
    * Geeft de punten van het bord waar de voordeelstraten komen te staan
    * @param p punt waar de voordeelstraten staan, 
    * de voordeelstraat wordt aangegeven dmv SuperMarkView.DrawCell()
    */
    @Override
    public void padPoint(Point p)
    {
            Controller.bord[p.x][p.y].setItem(11);
    }
    
    /**
    * Laadt de punten waar de voordeelstraat komen te staan uit een .txt bestand
    * @return een ArrayList met punten waar voordeelstraten komen te staan
    */
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
