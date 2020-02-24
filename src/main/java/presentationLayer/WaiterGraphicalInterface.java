package presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import businessLayer.Restaurant;
import dataLayer.RestaurantSerializator;

public class WaiterGraphicalInterface {
public View view;
public JFrame frame;
public JLabel idcomanda=new JLabel("Introduceti id-ul comenzii:");
public JTextArea icom=new JTextArea();
public JLabel idmasa=new JLabel("Introduceti numarul mesei:");
public JTextArea idmasaa=new JTextArea();
public JLabel introdu=new JLabel("Produsele din meniu sunt:");
public JTextArea produse=new JTextArea();
public JButton realizarecomanda=new JButton("Realizati comanda!");
public JLabel produsecomanda=new JLabel("Introduceti produsele pe care le v-a contine comanda:");
public JTextArea comanda=new JTextArea();
public JButton btntabel=new JButton("Afisare comenzi!");
public JTable tabel=new JTable();
public JFrame frametabel;
public JButton factura=new JButton("Obtine factura");
public WaiterGraphicalInterface()
{
}
public WaiterGraphicalInterface(View view)
{
	this.view=view;
	view.waiter(new ListenerWaiter());
}

class ListenerWaiter implements ActionListener
{
	public void actionPerformed(ActionEvent e) {
		frame=new JFrame();
		frame.setSize(600,700);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		idcomanda.setBounds(20, 20,200,20);
		panel.add(idcomanda);
		icom.setBounds(170,20,80,20);
		panel.add(icom);
		idmasa.setBounds(20,45,180,20);
		panel.add(idmasa);
		idmasaa.setBounds(180, 45, 80,20);
		panel.add(idmasaa);
		introdu.setBounds(20,70, 150, 20);
		panel.add(introdu);
		produse.setBounds(20,95,540,200);
		Restaurant rest=new Restaurant();
		produse.setText(rest.getMeniu());
		panel.add(produse);
		realizarecomanda.setBounds(20,540,150,60);
		panel.add(realizarecomanda);
		produsecomanda.setBounds(20,300,360, 20);
		panel.add(produsecomanda);
		comanda.setBounds(20,325,540, 200);
		btntabel.setBounds(200,540,150, 60);
		panel.add(btntabel);
		panel.add(comanda);
		factura.setBounds(380,540,150, 60);
		panel.add(factura);
		frame.add(panel);
		frame.setVisible(true);	
	}
}
public void listfactura(ActionListener e)
{
	factura.addActionListener(e);
}
public void frametabel()
{
	frametabel=new JFrame();
	frametabel.setSize(800,600);
	frametabel.add(new JScrollPane(this.tabel));	
	frametabel.setVisible(true);
}
public void settable(JTable tabel)
{
	this.tabel=tabel;
}
public void btnafisare(ActionListener e)
{
	btntabel.addActionListener(e);
}
public void btncomanda(ActionListener e)
{
	realizarecomanda.addActionListener(e);
}
public String getComanda()
{
   return String.valueOf(comanda.getText());
}
public int idcom()
{
	return Integer.parseInt(icom.getText());
}
public int idmasa()
{
	return Integer.parseInt(idmasaa.getText());
}
}
