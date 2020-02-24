package presentationLayer;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import businessLayer.MenuItem;
import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;

public class AdministratorGraphicalUserInterface {
public 	View view;
public JFrame frameadmin;
public JLabel mesaj=new JLabel("Adaugati un produs de baza:");
public JLabel idprod=new JLabel("Adaugati id-ul produsului:");
public JTextArea idprodus=new JTextArea();
public JLabel nume=new JLabel("Adaugati numele produsului:");
public JTextArea numeprod=new JTextArea();
public JLabel pret=new JLabel("Adaugati pretul produsului:");
public JTextArea prett=new JTextArea();
public JButton adaugareprod=new JButton("Adauga produs");
public JLabel prodcomp=new JLabel("Introduceti un produs compus:");
public JLabel mesajcomp=new JLabel("Produsele de baza din care puteti creea un produs compus sunt:");
public JTextArea componente=new JTextArea();
public JLabel denumire=new JLabel("Introduceti denumirea produsului compus:");
public JTextArea compcompus=new JTextArea();
public JLabel introduce=new JLabel("Introduceti produsele din care este alcatuit produsul compus:");
public JTextArea compus=new JTextArea();
public JButton adaugareprodcompus=new JButton("Adaugare produs");
public JLabel idcompus=new JLabel("Introduceti id-ul pentru produsul compus:");
public JTextArea idcompustext=new JTextArea();
public JTextArea dacaexistaid=new JTextArea();
public JLabel textsterge=new JLabel("Introduceti produsul pe care doriti sa il stergeti:");
public JTextArea stergere=new JTextArea();
public JButton stergerebtn=new JButton("Sterge produsul");
public JLabel textupdate=new JLabel("Introduceti datele pentru produsul pe care doriti sa faceti update:");
public JLabel vecheadenumire=new JLabel("Introduceti vechea denumire a produsului:");
public JTextArea denumireaveche=new JTextArea();
public JLabel nouadenumire=new JLabel("Introduceti noua denumire a produsului:");
public JTextArea denumireanoua=new JTextArea();
public JLabel vechiulpret=new JLabel("Introduceti vechiul pret al produsului:");
public JTextArea pretvechi=new JTextArea();
public JLabel noulpret=new JLabel("Introduceti noul pret al produsului:");
public JTextArea pretnou=new JTextArea();
public JButton update=new JButton("Update!");
public JButton vizualizaredate=new JButton("Vizualizati produsele din meniu!");
public JFrame date;
public JTable tabel=new JTable();
public JButton back=new JButton("BACK");
//public JTextArea dd=new JTextArea();
public AdministratorGraphicalUserInterface() {}
public AdministratorGraphicalUserInterface(View view)
{
	this.view=view;
	view.adminlistener(new ListenerAdmin());
}
class ListenerAdmin implements ActionListener
{
	public void actionPerformed(ActionEvent e) {
		frameadmin=new JFrame();
	//	frameadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameadmin.setSize(900,740);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		mesaj.setBounds(20, 30,250,20);
		panel.add(mesaj);
		idprod.setBounds(20,50,180, 20);
		panel.add(idprod);
		idprodus.setBounds(180, 50,80,20);
		panel.add(idprodus);
		nume.setBounds(20, 75,190,20);
		panel.add(nume);
		numeprod.setBounds(190, 75, 80,20);
		panel.add(numeprod);
		pret.setBounds(20, 100,190, 20);
		panel.add(pret);
		prett.setBounds(180,100,80, 20);
		panel.add(prett);
		adaugareprod.setBounds(70, 130,140,50);
		panel.add(adaugareprod);
		mesajcomp.setBounds(20,190,390,20);
		panel.add(mesajcomp);
		componente.setBounds(20,210,400,150);
		Restaurant rest=new Restaurant();
		componente.setText(rest.componente());
		panel.add(componente);
		denumire.setBounds(20, 380,260,20);
		panel.add(denumire);
		compcompus.setBounds(275, 380,100, 20);
		panel.add(compcompus);
		introduce.setBounds(20, 410,380, 20);
		panel.add(introduce);
		compus.setBounds(20,430,400,150);
		panel.add(compus);
		adaugareprodcompus.setBounds(120, 590,150,50);
		panel.add(adaugareprodcompus);
		idcompus.setBounds(20,650,240, 20);
		panel.add(idcompus);
		idcompustext.setBounds(260, 650,80,20);
		panel.add(idcompustext);
		textsterge.setBounds(300, 30,280,20);
		panel.add(textsterge);
		stergere.setBounds(580, 30,100, 20);
		panel.add(stergere);
		stergerebtn.setBounds(530,70,150,70);
		panel.add(stergerebtn);
		textupdate.setBounds(450, 140,420, 20);
		panel.add(textupdate);
		vecheadenumire.setBounds(450,170,260, 20);
		panel.add(vecheadenumire);
		denumireaveche.setBounds(700,170,80, 20);
		panel.add(denumireaveche);
		nouadenumire.setBounds(450,200,260,20);
		panel.add(nouadenumire);
		denumireanoua.setBounds(700, 200,80,20);
		panel.add(denumireanoua);
		vechiulpret.setBounds(450,230,260, 20);
		panel.add(vechiulpret);
		pretvechi.setBounds(670,230,80, 20);
		panel.add(pretvechi);
		noulpret.setBounds(450,260,260,20);
		panel.add(noulpret);
		pretnou.setBounds(670, 260,80,20);
		panel.add(pretnou);
		update.setBounds(550, 290,150,50);
		panel.add(update);
		vizualizaredate.setBounds(510,380, 240, 50);
		panel.add(vizualizaredate);
		back.setBounds(570, 460,100,50);
		panel.add(back);
		//dd.setBounds(650,650,100,20);
		//panel.add(dd);
		frameadmin.add(panel);
		frameadmin.setVisible(true);	
		frameadmin.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
            	RestaurantSerializator rest = new RestaurantSerializator();
            	rest.serializare(Controler.restaurant.getList());
                e.getWindow().dispose();
            }
        });
	}
}
public void back(ActionListener e)
{
	back.addActionListener(e);
}
public void setTable(JTable tabel)
{
	this.tabel=tabel;
}
public void vizualizaredate()
{
	date=new JFrame("DateTable");
	date.setSize(800,600);
	date.add(new JScrollPane(this.tabel));	
	date.setVisible(true);
}
public void btnvizualizare(ActionListener e)
{
	vizualizaredate.addActionListener(e);
}
public void modificare(ActionListener e)
{
	update.addActionListener(e);
}
public int pretVechi()
{
	return Integer.parseInt(pretvechi.getText());
}
public int pretNou()
{
	return Integer.parseInt(pretnou.getText());
}
public String nouaDenumire()
{
	return String.valueOf(denumireanoua.getText());
}
public String vecheaDenumire()
{
	return String.valueOf(denumireaveche.getText());
}
public String stergere()
{
	return String.valueOf(stergere.getText());
}
public void stergerebtn(ActionListener e)
{
	stergerebtn.addActionListener(e);
}
public int getidcompus()
{
	return Integer.parseInt(idcompustext.getText());
}
public String getComponenteCompus()
{
	return String.valueOf(compus.getText());
}
public String getNumecompus()
{
	return String.valueOf(compcompus.getText());
}
public void listeneradauga(ActionListener e)
{
	adaugareprod.addActionListener(e);
}
public void listenercompus(ActionListener e)
{
	adaugareprodcompus.addActionListener(e);
}
public int getId()
{
	return Integer.parseInt(idprodus.getText());
}
public String getnume()
{
	return String.valueOf(numeprod.getText());		
}
public int getpret()
{
	return Integer.parseInt(prett.getText());
}
public String getProdusCompus()
{
	String s=compus.getText();
	return s;
}
}
