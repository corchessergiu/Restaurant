package businessLayer;

import java.io.Serializable;
import java.util.ArrayList;

public  class MenuItem implements Serializable{
	protected String name;
	protected int pret;
	protected int id;
	public MenuItem() {}
	public  MenuItem(int id, String name, int pret) {
		this.id=id;
		this.name=name;
		this.pret=pret;
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
