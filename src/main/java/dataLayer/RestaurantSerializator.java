package dataLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import businessLayer.MenuItem;

public class RestaurantSerializator implements Serializable{
  public void serializare(ArrayList<MenuItem> lista)
  {
	  try {
		  FileOutputStream fileout=new FileOutputStream("Data.txt");
		  ObjectOutputStream out =new ObjectOutputStream(fileout);
		  System.out.println("Obiectele din lista sunt"+lista);
		  out.writeObject(lista);
		  out.close();
		   fileout.close();
	  }
	  catch (IOException e) {
	         e.printStackTrace();
	      }
  }
  
  public ArrayList<MenuItem> deserializare()
  {
	  try {
	  FileInputStream filein = new FileInputStream("Data.txt");
	  ObjectInputStream in=new ObjectInputStream(filein);
	  ArrayList<MenuItem> datefisier= (ArrayList<MenuItem>)in.readObject();
	 
	  for (int i=0;i<datefisier.size();i++) {
	    	System.out.println("Produsele curente sunt:");
	    	System.out.println(datefisier.get(i).getId()+" "+datefisier.get(i).getName()+" "+datefisier.get(i).getPret()); 
	    	}
	  in.close();
	  filein.close();
	  return datefisier;
	  }
	  catch(IOException e)
	  {
		  e.printStackTrace();
	  }
	  catch (ClassNotFoundException c) {
	         System.out.println("Nu s-au gasit date");
	         c.printStackTrace();
	      }
	return null;
	 
  }
}
