/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.util.List;

/**
 * Het magazijn van de winkel
 * @author Niels
 */
public class Voorraad
{
    private List<ProductWrapper> voorraad; //Maak public voor test!!
    
    /**
     * Haalt de voorraad uit de database
     */
    public Voorraad()
    {
        this.voorraad = Database.getProducten();
    }
    
    /**
     * Verlaagt de voorraad van een product
     * @param product product waar de voorraad van verlaagd wordt
     */
    public void lowerProduct(String product)
    {
        int pos = ProductWrapper.Search(product, voorraad);
        ProductWrapper pw = voorraad.get(pos);       
        try
        {
            pw.pakEen();
        }
        catch(Exception e)
        {
            if(!Controller.openTaken.contains(13))
                Controller.openTaken.add(13);
        }
    }
    
    /**
     * Verhoogd het aantal van de meegegeven producten
     * @param producten de producten die verhoogd moeten worden
     */
    public void setProducten(List<ProductWrapper> producten)
    {
        producten.stream().forEach((pw)->
        {
            int pos = ProductWrapper.Search(pw.getProductNaam(), voorraad);
            if(pos != -1)
            {
                ProductWrapper voorraadP = voorraad.get(pos);
                voorraadP.setAantal(voorraadP.getAantal() + pw.getAantal());
            }
        });
    }
    
    /**
     * Geeft een lijst van producten
     * @return voorraad van producten
     */
    public List<ProductWrapper> getProducts()
    {
        return voorraad;
    }
    
    /**
     * Kijkt of het product in de voorraad aanwezig is 
     * @param product product
     * @return de voorraad (0 of hoger)
     */
    public boolean checkProduct(String product)
    {
        int pos = ProductWrapper.Search(product, voorraad);
        ProductWrapper voorraadP = voorraad.get(pos);
        return voorraadP.getAantal() > 0;
    }
    
}
