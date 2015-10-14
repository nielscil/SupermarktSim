/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * View voor paden statistieken
 * @author Niels
 */
public class padenView extends JPanel
{
    private Controller controller;
    /**
     * Maak padenView aan
     * @param controller de controller
     */
    public padenView(Controller controller)
    {
        setPreferredSize(new Dimension(300, 763));
        setFocusable(false);
        this.controller = controller;
        this.setLayout(new GridLayout(0,2));       
    }
    
    /**
     * Maak per pad een padView aan
     */
    public void setPaden()
    {
        controller.paden.stream().forEach((p)->
        {
            this.add(new padView(p));
        });
        controller.afdelingen.stream().forEach((f)->
        {
            this.add(new padView(f));
        });
        this.add(new padView(controller.voordeelstraat));
    }
    
    /**
     * Laat gegevens zien van een pad
     */
    public class padView extends JPanel implements Observer
    {       
        private Pad pad;
        private DefaultListModel listModel = new DefaultListModel();
        private JList list;
        
        /**
         * Maakt padView aan
         * @param pad pad
         */
        public padView(Pad pad)
        {
            setPreferredSize(new Dimension(150, 50));
            setFocusable(false);
            this.pad = pad;
            pad.setpadenView(this);
            list = new JList(listModel);
            list.setBackground(Color.LIGHT_GRAY);
            this.add(list);
            this.setBackground(Color.LIGHT_GRAY); 
            checkProducts();
        }
        
        /**
         * Controleert de producten en zet ze in de lijst
         */
        private void checkProducts()
        {
            listModel.clear();
            listModel.add(0, pad.logString);
            pad.producten.stream().forEach((p)->
            {
                listModel.addElement(p.getProductNaam() + " | " + p.getAantal());
            });
        }
        /**
         * Bij update controleren van de producten
         * @param o obserable
         * @param arg object
         */
        @Override
        public void update(Observable o, Object arg)
        {
            checkProducts();
        }
    }
}


