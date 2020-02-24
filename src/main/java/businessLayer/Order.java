package businessLayer;

import java.util.ArrayList;
import java.util.Date;

public class Order {
  public int id;
  public Date data;
  public int table;
  public Order() {
  }
    public Order(int id,int table)
    {
    	this.id=id;
    	this.table=table;
    	this.data=new Date();
    }
   /* public ArrayList<MenuItem> getListaComenzi()
    {
    	return this.produsecomanda;
    }
    public void add(MenuItem comandanoua)
    {
    	produsecomanda.add(comandanoua);
    }
    public void deleteComanda(int id)
    {
    	for (int i=0;i<produsecomanda.size();i++)
    	{
    		if (produsecomanda.get(i).getId()==id)
    			produsecomanda.remove(i);
    	}
    }*/
    public int hashCode()
    {
    	return this.id;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	public String toString()
	{
		String s="";
		s+="ID comanda: "+this.id+" numar masa:"+this.table+" data comenzii: "+this.data+"\n";
		 return s;
	}
}
