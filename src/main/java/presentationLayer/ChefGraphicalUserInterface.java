package presentationLayer;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import businessLayer.Order;
import businessLayer.Restaurant;

public class ChefGraphicalUserInterface implements Observer{
	public View view;
	public JFrame frame;
	public JLabel comenzi=new JLabel("Istoric comenzi:");
	public JTextArea text=new JTextArea();
	public Controler observer=new Controler();
	public Restaurant rest=new Restaurant();
   public ChefGraphicalUserInterface(View view,Controler ovserver,Restaurant rest) {
	   this.view=view;
	   this.rest=rest;
	   this.observer=observer;
	   view.cheflistener(new ListenerChef());
   }
   class ListenerChef implements ActionListener
   {

	public void actionPerformed(ActionEvent e) {
		frame=new JFrame();
		frame.setSize(600,600);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		comenzi.setBounds(10,10, 400, 20);
		panel.add(comenzi);
		text.setBounds(10, 40,600,400);
		panel.add(text);
		frame.add(panel);
		frame.setVisible(true);
	}
	   
   }
public void update(Observable o, Object arg) {
	text.append("O noua comanda a fost plasata!\n");
	HashMap<Order, ArrayList<businessLayer.MenuItem>> comenzi=rest.getComenziAfisare();
	  Iterator<Entry<Order, ArrayList<businessLayer.MenuItem>>> it = comenzi.entrySet().iterator();
	  int i=0;
	    while (it.hasNext()) {
	    	String s="";
	        HashMap.Entry pair = (HashMap.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        Order order=(Order) pair.getKey();
	        text.append(String.valueOf("Id-ul comenzii:"+order.getId()+"\n"));
	        text.append(String.valueOf("Data realizarii comenzi:"+order.getData()+"\n"));
	        text.append(String.valueOf("Numar masa:"+order.getTable()+"\n"));
	        it.remove(); 
	    }
	    }
}
