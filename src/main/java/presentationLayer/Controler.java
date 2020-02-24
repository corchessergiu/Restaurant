package presentationLayer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;

import businessLayer.BaseProduct;
import businessLayer.CompositeProduct;
import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.Restaurant;
import dataLayer.File;
import dataLayer.File;
import dataLayer.RestaurantSerializator;
public class Controler extends Observable{
public AdministratorGraphicalUserInterface admin;
public static Restaurant restaurant;
public RestaurantSerializator rest;
public boolean dacaexistaid=false;
public WaiterGraphicalInterface waiter;
public File file;
public Controler(Restaurant restaurant,AdministratorGraphicalUserInterface admin, RestaurantSerializator rest,WaiterGraphicalInterface waiter,File file)
{
	this.admin=admin;
	this.rest=rest;
	this.file=file;
	this.waiter=waiter;	
	waiter.listfactura(new ListFactura());
	waiter.btncomanda(new Comanda());
	waiter.btnafisare(new AfisareDate());
	admin.listeneradauga(new ButonAdauga());
	admin.listenercompus(new ProdCompus());
	admin.stergerebtn(new StergereProdus());
	admin.modificare(new Modificare());
	admin.btnvizualizare(new VizualizareDate());
	admin.back(new Back());
	this.restaurant=restaurant;
}
public Controler() {}
class ListFactura implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		file.afisaredate(restaurant.getComenzi());
}
}
class AfisareDate implements ActionListener{

	public void actionPerformed(ActionEvent e) {
	waiter.settable(restaurant.returntabelhash());
	waiter.frametabel();		
	}	
}
class Comanda implements ActionListener
{

	public void actionPerformed(ActionEvent e) {
		String s=waiter.getComanda();
		String [] componentecomanda=s.split(",");
	    int id=waiter.idcom();
	    int idmasa=waiter.idmasa();
	    ArrayList<MenuItem> produsecomanda=new ArrayList<MenuItem>();
	    ArrayList<MenuItem> verificare=restaurant.getList();
	    boolean ok=true;
	    for (int i=0;i<componentecomanda.length;i++)
		{
			for (int j=0;j<verificare.size();j++)
			{
			if (!(verificare.get(j).getName().equals(componentecomanda[i])))
				ok=false;
			if (verificare.get(j).getName().equals(componentecomanda[i]))
			{
				ok=true;
				break;
			}
			}
		}    
	    if (ok==true)
	    {	    	
			 for (int i=0;i<componentecomanda.length;i++)
			 {
				 for (int j=0;j<verificare.size();j++) {
				 if (componentecomanda[i].equals(verificare.get(j).getName())) {
					if (verificare.get(j) instanceof BaseProduct)	{							
						BaseProduct produs=new BaseProduct(1,verificare.get(j).getName(),verificare.get(j).getPret());
						produsecomanda.add(produs);
					}
						if (verificare.get(j) instanceof CompositeProduct)
						{
							CompositeProduct produscompus=new CompositeProduct(1,verificare.get(j).getName(),verificare.get(j).getPret());
							produsecomanda.add(produscompus);
						}
				 }
			   }
	    }
			 System.out.println("Lungimea:"+produsecomanda.size());
			 Order order=new Order(id,idmasa);	 
			 System.out.println("das->"+order.toString());	 
			 restaurant.comanda.put(order,produsecomanda);
			 restaurant.comenziafisaredetali.put(order,produsecomanda);
			 restaurant.afisareobserver.put(order,produsecomanda);
			 setChanged();
			 notifyObservers();
			 System.out.println("das->"+produsecomanda.toString());
	}
	}	
}
class Back implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		admin.frameadmin.dispose();
	}	
}
class VizualizareDate implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		admin.setTable(restaurant.returnaredatetabel());
		admin.vizualizaredate();		
	}
}
class Modificare implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String denumireveche=admin.vecheaDenumire();
		String denumireanoua=admin.nouaDenumire();
		int pretvechi=admin.pretVechi();
		int  pretnou=admin.pretNou();
		System.out.println("Noua denumire"+denumireanoua+"aia veche"+denumireveche);
		ArrayList<MenuItem> verificare=restaurant.getList();		
		 for(int i=0;i<verificare.size();i++)
		 {
			 if (denumireveche.equals(verificare.get(i).getName()))
					 verificare.get(i).setName(denumireanoua);
			 if (pretvechi==verificare.get(i).getPret())
				 verificare.get(i).setPret(pretnou);
		 } 
	}	
}
class StergereProdus implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		ArrayList<MenuItem> verificare=restaurant.getList();
		  for (int i=0;i<verificare.size();i++)
		  {
			  if (verificare.get(i) instanceof BaseProduct) {
			  if (admin.stergere().equals(verificare.get(i).getName()))
					verificare.remove(i);  
			  for(int k=0;k<verificare.size();k++)
			  {
				  if (verificare.get(i) instanceof CompositeProduct)
				  {
					  CompositeProduct men=new CompositeProduct();
					  ArrayList<MenuItem> produs=men.getListaProduse();
					  	for (int j=0;j<produs.size();j++)
					  	{
					  		if (produs.get(j).getName().equals(admin.stergere())) {
					  			verificare.remove(i);
					  			break;
					  		}
					  	}
				  }
			  }	
			  }
			   if (verificare.get(i) instanceof CompositeProduct)
				   verificare.remove(i);
		  }
	}	
}
class ProdCompus implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		boolean ok=true;
		int pret=0;
		int id=admin.getidcompus();
		String denumire=admin.getNumecompus();
		String componente=admin.getComponenteCompus();
		String[] comp=componente.split(",");
		ArrayList<MenuItem> verificare=restaurant.getList();
		for (int i=0;i<comp.length;i++)
		{
			for (int j=0;j<verificare.size();j++)
			{
			if (!(verificare.get(j).getName().equals(comp[i])))
				ok=false;
			if (verificare.get(j).getName().equals(comp[i]))
			{
				ok=true;
				break;
			}
			}
		}
		  if (ok==true) {
			  System.out.println("Pretu este:"+pret);
				 for (int i=0;i<verificare.size();i++)
				 {
					 if (id==verificare.get(i).getId())
					 {
						 dacaexistaid=false;
						 break;
					 }
				 }
				 if (ok==true) {
					ArrayList<MenuItem> compuse=new ArrayList<MenuItem>();
					 for (int i=0;i<comp.length;i++)
					 {
						 for (int j=0;j<verificare.size();j++) {
						 if (comp[i].equals(verificare.get(j).getName())) {
							if (verificare.get(j) instanceof BaseProduct)	{							
								BaseProduct produs=new BaseProduct(id,verificare.get(j).getName(),verificare.get(j).getPret());
								compuse.add(produs);
							}
								if (verificare.get(j) instanceof CompositeProduct)
								{
									CompositeProduct produscompus=new CompositeProduct(id,verificare.get(j).getName(),verificare.get(j).getPret());
									compuse.add(produscompus);
								}
						 }
					   }
						   CompositeProduct calcularepret=new CompositeProduct(0,"pret",0,compuse);
						  pret=calcularepret.computePrice();
					 }					 
					 CompositeProduct compus=new CompositeProduct(id,denumire,pret,compuse);
					 restaurant.addProdusMeniu(compus);
				 }
		  }
	}
}
class ButonAdauga implements ActionListener
{

	public void actionPerformed(ActionEvent e) {
		int id=admin.getId();
		String nume=admin.getnume();
		int pret=admin.getpret();
		ArrayList<MenuItem> produse=new ArrayList<MenuItem>();
		produse=restaurant.getList();
		 for (int i=0;i<produse.size();i++)
		 {
			 if (id==produse.get(i).getId())
			 {
				 dacaexistaid=true;
				 break;
			 }
		 }
		 if (dacaexistaid==false) {
		BaseProduct produs=new BaseProduct(id,nume,pret);
		System.out.println(produs.toString());
		restaurant.addProdusMeniu(produs);
		 }
	}
}
}
