package businessLayer;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem {
	public ArrayList<MenuItem> item=new ArrayList<MenuItem>();
	public CompositeProduct(int id, String name, int pret,ArrayList<MenuItem> produs) {
		super(id, name, pret);
		this.item=produs;
	}
	public CompositeProduct(int id, String name, int pret) {
		super(id, name, pret);
	}
	public CompositeProduct() {}
   public String toString()
   {
	   return "ID: "+this.id+" nume:"+this.name+" pret:"+this.pret;
   }

	public int computePrice()
	{
		int pret=0;
		for(int i=0;i<item.size();i++)
			pret+=item.get(i).getPret();
	return pret;
	}
	 public ArrayList<MenuItem> getListaProduse()
	   {
		   return this.item;
	   }
	   public void addProdus(MenuItem produs)
	   {
		   item.add(produs);
	   }
	   public void deleteProdus(MenuItem produs)
	   {
		   item.remove(produs);
	   }
}
