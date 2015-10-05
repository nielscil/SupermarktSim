/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niels
 */
public class Voorraad
{
    private List<ProductWrapper> voorraad = new ArrayList<>();
    
    public Voorraad()
    {
        this.voorraad = Database.getProducten();
    }
    
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
    
    public void setProducten(List<ProductWrapper> producten)
    {
        producten.stream().forEach((pw)->
        {
            int pos = ProductWrapper.Search(pw.getProductNaam(), voorraad);
            ProductWrapper voorraadP = voorraad.get(pos);
            voorraadP.setAantal(voorraadP.getAantal() + pw.getAantal());
        });
    }
    
    public List<ProductWrapper> getProducts()
    {
        return voorraad;
    }
    
    public boolean checkProduct(String product)
    {
        int pos = ProductWrapper.Search(product, voorraad);
        ProductWrapper voorraadP = voorraad.get(pos);
        return voorraadP.getAantal() > 0;
    }
    
}
