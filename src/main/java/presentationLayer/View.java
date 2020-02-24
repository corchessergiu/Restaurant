package presentationLayer;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
   public JFrame frame1;
   public JButton administrator=new JButton("Admin");
   public JButton chef=new JButton("Chef");
   public JButton waiter=new JButton("Waiter");
   public View()
   {
	   frame1=new JFrame();
	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame1.setSize(820,300);   
	   JPanel panel=new JPanel();
	   panel.setLayout(null);
	   administrator.setBounds(50, 50, 200,130);
	   panel.add(administrator);
	   chef.setBounds(300, 50, 200, 130);
	   panel.add(chef);
	   waiter.setBounds(550, 50,200,130);
	   panel.add(waiter);
	   frame1.add(panel);
	   frame1.setVisible(true);
   }
   public void adminlistener(ActionListener e)
   {
	   administrator.addActionListener(e);
   }
  public void cheflistener(ActionListener e)
  {
	  chef.addActionListener(e);
  }
  public void waiter(ActionListener e)
  {
	  waiter.addActionListener(e);
  }
}
