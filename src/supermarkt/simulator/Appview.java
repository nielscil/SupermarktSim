/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarkt.simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
//javaDoc volledig ingevuld
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Niels
 */
public class Appview
{
    private static final int GAP = 5;
    private SupermarkView bord;
    private DefaultListModel listModel;
    private JList list;
    private Controller controller;
    private static  List<String> logging = new ArrayList<>();
    private boolean pauze = false;
    private JButton pauzebut;
    
    /**
     * Maakt GUI aan
     */
    public Appview(Controller controller,int dag)
    {
        this.controller = controller;
        listModel = new DefaultListModel();
        JFrame frame = new JFrame();
        JPanel framePanel = new JPanel ();
        framePanel.setBorder (BorderFactory.createEmptyBorder (GAP, GAP, GAP, GAP));
        framePanel.setLayout (new BorderLayout (GAP, GAP));
        bord = new SupermarkView();
        framePanel.add (bord, BorderLayout.WEST);
        JPanel listpanel = new JPanel();
        listpanel.setBackground(Color.LIGHT_GRAY);
        list = new JList(listModel);
        list.setBackground(Color.LIGHT_GRAY);
        listpanel.add(list);
        JScrollPane pane = new JScrollPane(listpanel);
        pane.setPreferredSize(new Dimension(400, pane.getPreferredSize().height));
        framePanel.add(pane,BorderLayout.EAST);
        
        JPanel pauzePanel = new JPanel();
        pauzePanel.setLayout(new FlowLayout());
        pauzebut = new JButton("Pauze");
        pauzebut.addMouseListener(listener);
        pauzePanel.add(pauzebut);
        framePanel.add(pauzePanel,BorderLayout.SOUTH);
        frame.add (framePanel);
        frame.setTitle ("The Sims: Supermarkt Simulator DLC");
        logging.add("The Sims: Supermarkt Simulator DLC");
        logging.add("Dag: " + dag);
        (new ListUpdater()).execute();
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable (false);
        frame.pack ();
        frame.setLocationRelativeTo (null);
        frame.addWindowListener(new WindowListener()
        {           
            @Override
            public void windowOpened(java.awt.event.WindowEvent e)
            {
                
            }

            @Override
            public void windowClosed(java.awt.event.WindowEvent e)
            {

            }

            @Override
            public void windowIconified(java.awt.event.WindowEvent e)
            {

            }

            @Override
            public void windowDeiconified(java.awt.event.WindowEvent e)
            {

            }

            @Override
            public void windowActivated(java.awt.event.WindowEvent e)
            {

            }

            @Override
            public void windowDeactivated(java.awt.event.WindowEvent e)
            {

            }
            
            @Override
            public void windowClosing(java.awt.event.WindowEvent e)
            {
                Database.setProducten(Controller.voorraad.getProducts());
                List<ProductWrapper> producten = new ArrayList<>();
                controller.paden.stream().forEach((p)->
                {
                    producten.addAll(p.producten);
                });
                Database.setWinkelproduct(producten);
                System.exit(0);
            }
        });
        frame.setVisible (true);
        try
        {
            Thread.sleep(100);
        }
        catch(InterruptedException e){}
    }
    
    public static void Log(String logString,Persoon persoon)
    {
        logging.add(0, persoon.naam + " " + logString + " | ronde: " + Controller.getRonde());
    }
    
    public SupermarkView getSupermarkView()
    {
        return bord;
    }
    
    private void updateList (List<String> entries) {
        listModel.removeAllElements();
        for (String entry : entries) {
            listModel.addElement(entry);
        }
    }
    
    private class ListUpdater extends SwingWorker<List<String>, List<String>>
    {

        @Override
        protected List<String> doInBackground() throws Exception
        {
            while (true) {
                publish(new ArrayList<>(logging));
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {}
            }
            //return null;
        }

        @Override
        protected void done()
        {
            super.done(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        protected void process(List<List<String>> chunks)
        {
            for (List<String> entry : chunks) {
                updateList(entry);
            }
        }
        
    }
    
    private MouseListener listener = new MouseListener()
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(pauze)
            {
                controller.sim.resume();
                pauze = false;
                pauzebut.setText("Pause");
            }
            else
            {
                controller.sim.setPauze();
                pauze = true;
                pauzebut.setText("Resume");
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e)
        {

        }

        @Override
        public void mouseReleased(MouseEvent e)
        {

        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            
        }
    };
}
