package Vue;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import Controleur.Creer_Post_it;


public class Principale extends JFrame{
	
	public Principale(){
		Container jp = this.getContentPane();
		JButton buttonCreer = new JButton("Creer");
		buttonCreer.addActionListener(new Creer_Post_it());
		jp.add(buttonCreer);
		this.setPreferredSize(new Dimension(320,100));
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Principale();

	}

}
