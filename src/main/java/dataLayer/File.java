package dataLayer;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;
import presentationLayer.WaiterGraphicalInterface;

public class File {

	public void afisaredate(HashMap<Order,ArrayList<MenuItem>> comanda)
	{
	    WaiterGraphicalInterface waiter=new  WaiterGraphicalInterface();
		  java.util.Iterator<Entry<Order, ArrayList<MenuItem>>> it = comanda.entrySet().iterator();
		  int i=0;
		  String fileName="Chitanta.txt";
		  System.out.println(comanda.size());
	
		  try {
				FileWriter output=new FileWriter(fileName);
		    while (it.hasNext()) {
		    	String s="";
		  	  	int total=0;
		        HashMap.Entry pair = (HashMap.Entry)it.next();
		        System.out.println("Compozitia chitantei:");
		        System.out.println(pair.getKey() + " = " + pair.getValue()); 
		        Order order=(Order) pair.getKey();
		        output.write("Id-ul comenzii este:"+order.getId()+"\n");
		        output.write(System.lineSeparator());
		        output.write("Data in care a fost realizata comanda:"+order.getData()+"\n");
		        output.write(System.lineSeparator());
		    	output.write("Numarul mesei este:"+order.getTable()+"\n");
		    	 output.write(System.lineSeparator());
		        ArrayList<MenuItem> produse=new ArrayList<MenuItem>();
		        produse=(ArrayList<MenuItem>) pair.getValue();
		        output.write("Comanda contine:");
		        output.write(System.lineSeparator());
		        for (int j=0;j<produse.size();j++)
		        {
		        	output.write(produse.get(j).getName()+" pret:"+produse.get(j).getPret()+"\n");
		        	 output.write(System.lineSeparator());
		        	total+=produse.get(j).getPret();
		        }
			    output.write("Total:"+total+"\n");
			    output.write(System.lineSeparator());
		    }
		    output.close();
		  }
		  catch(Exception ee) {
			  ee.printStackTrace();
		  }
	}
}
