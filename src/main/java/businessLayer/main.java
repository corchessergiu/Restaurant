package businessLayer;

import java.util.ArrayList;import java.util.HashMap;

import dataLayer.File;
import dataLayer.File;
import dataLayer.RestaurantSerializator;
import presentationLayer.AdministratorGraphicalUserInterface;
import presentationLayer.ChefGraphicalUserInterface;
import presentationLayer.Controler;
import presentationLayer.View;
import presentationLayer.WaiterGraphicalInterface;



public class main {

	public static void main(String[] args) {
		/*MenuItem men1=new BaseProduct(1,"popica",12);
		MenuItem men2=new CompositeProduct(2,"asd2",132);
		CompositeProduct meniu=new CompositeProduct();
		meniu.addProdus(men1);
		meniu.addProdus(men2);
		ArrayList<MenuItem> a=new ArrayList<MenuItem>();
		a=meniu.getListaProduse();*/
		//System.out.println(a.toString());
		//meniu.deleteProdus(men1);
		//System.out.println(a.toString());
		/*Order comanda1=new Order(1,4);
		Order comanda2=new Order(2,5);*/
		//System.out.println(comanda1.toString());
		//System.out.println(comanda2.toString());
		View view=new View();
		AdministratorGraphicalUserInterface admin=new AdministratorGraphicalUserInterface(view);
		WaiterGraphicalInterface waiter=new WaiterGraphicalInterface(view);
		Restaurant rest=new Restaurant();	
		RestaurantSerializator serializare=new RestaurantSerializator();
		File file=new File();
		Controler cont=new Controler(rest,admin,serializare,waiter,file);
		ChefGraphicalUserInterface chef=new ChefGraphicalUserInterface(view,cont,rest);
		cont.addObserver(chef);
		//rest.initializareLista();
		//serializare.serializare(rest.getList());	
		//System.out.println(rest.getMeniu());
	}

}
