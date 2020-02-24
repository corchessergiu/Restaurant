package businessLayer;

public class BaseProduct extends MenuItem {
	public BaseProduct(int id,String nume,int pret)
	{
		super(id,nume,pret);
	}
	public String toString()
	{
		return "ID:"+this.id+" nume:"+this.name+" pret: "+this.pret;
	}
	public int computePrice()
	{
		return this.pret;
	}
}
