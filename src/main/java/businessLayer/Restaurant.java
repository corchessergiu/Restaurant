package businessLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;

import javax.swing.JTable;
import javax.swing.text.html.HTMLDocument.Iterator;

import dataLayer.RestaurantSerializator;
import presentationLayer.AdministratorGraphicalUserInterface;

public class Restaurant {
 public  HashMap<Order,ArrayList<MenuItem>> comanda;
 public  HashMap<Order,ArrayList<MenuItem>> comenziafisaredetali;
 public  HashMap<Order,ArrayList<MenuItem>> afisareobserver;
 public ArrayList<MenuItem> meniu = new ArrayList<MenuItem>();
   public Restaurant()
   {
	   RestaurantSerializator restaurant=new RestaurantSerializator();
      this.meniu=restaurant.deserializare(); 
	   if (meniu.size()==0) {
		   System.out.println("Nu este nimic in fisier");
		   meniu = new ArrayList<MenuItem>();	
	   }
	   this.afisareobserver=new HashMap<Order,ArrayList<MenuItem>>();
	   this.comenziafisaredetali=new HashMap<Order,ArrayList<MenuItem>>();
	   this.comanda=new HashMap<Order,ArrayList<MenuItem>>();	
   }
   public JTable returnaredatetabel()
   {
	 String[] captabel= {"Id produs","Denumire produs","Pret produs","Compozitie"};
	 Object[][] datetabel=new Object[meniu.size()][4];
	 for (int i=0;i<meniu.size();i++) {
      datetabel[i][0]=meniu.get(i).getId();
      datetabel[i][1]=meniu.get(i).getName();
      datetabel[i][2]=meniu.get(i).getPret();
       if (meniu.get(i) instanceof BaseProduct)
    	   datetabel[i][3]=meniu.get(i).getName();	 
        if (meniu.get(i) instanceof CompositeProduct)
        {
        	CompositeProduct produs=new CompositeProduct();
        	 ArrayList<MenuItem> produse=((CompositeProduct) meniu.get(i)).getListaProduse();
        	 String s="";
        	 for (int k=0;k<produse.size();k++)
        	 {
        		s+=produse.get(k).getName()+" ";
        	 }
        	  datetabel[i][3]=s;
        }
	 }
	  JTable tabel=new JTable(datetabel,captabel);
	  return tabel;
   }
   public JTable returntabelhash()
   {
	  String[] captabel= {"ID order","Data comenzii","Masa","Continut comanda"};
	  System.out.println("Am comanda de lungime"+comanda.size());
	  Object[][] datetabel=new Object[comanda.size()][4];
	  java.util.Iterator<Entry<Order, ArrayList<MenuItem>>> it = comanda.entrySet().iterator();
	  int i=0;
	    while (it.hasNext()) {
	    	String s="";
	        HashMap.Entry pair = (HashMap.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        Order order=(Order) pair.getKey();
	        datetabel[i][0]=order.getId();
	        datetabel[i][1]=order.getData();
	        datetabel[i][2]=order.getTable();
	        ArrayList<MenuItem> produse=new ArrayList<MenuItem>();
	        produse=(ArrayList<MenuItem>) pair.getValue();
	    	 for (int k=0;k<produse.size();k++)
        	 {
        		s+=produse.get(k).getName()+" ";
        	 }
	        datetabel[i][3]=s;
	        i++;
	        it.remove(); 
	    }
	   JTable tabel=new JTable(datetabel,captabel);
		  return tabel;
   }
   public HashMap<Order,ArrayList<MenuItem>> getComenziAfisare()
   {
	  return this.afisareobserver;
   }
   public HashMap<Order,ArrayList<MenuItem>> getComenzi()
   {
	  return this.comenziafisaredetali;
   }
   public String componente()
   {
	   String s="";
	   if (meniu.size()!=0) {	   
	   for (int i=0;i<meniu.size();i++)
		   s+=meniu.get(i).getName()+",";
	   s=s.substring(0, s.length()-1);
   }
	  return s;
   }
  public void initializareLista()
  {
	  RestaurantSerializator restaurant=new RestaurantSerializator();
	   this.meniu=restaurant.deserializare();
  }
   public void addProdusMeniu(MenuItem men)
   {
	   if (meniu != null)
		   this.meniu.add(men);
   }
   public ArrayList<MenuItem> getList()
   {
	   return this.meniu;
   }
   public String getMeniu()
   {
	   String s="";
	   System.out.println(meniu.size());
	    for (int i=0;i<meniu.size();i++) {
	    	System.out.println("das");
	    	s+="Id produs:"+meniu.get(i).getId()+"   nume:  "+meniu.get(i).getName()+" pret:   "+meniu.get(i).getPret()+"\n";
	    }
	   return s;
   }
}
