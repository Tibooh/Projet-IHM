package Vue;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import Controleur.Cb_Listener;
import Controleur.Creer_Post_it;


public class Principale extends JFrame{
	
	JButton buttonCreer;
	JTabbedPane onglets;
	public static String text="Text"; 
	
	public Principale(){
		Container jp = this.getContentPane();
		onglets = new JTabbedPane(SwingConstants.TOP);
		buttonCreer = new JButton("Creer");
		
		JPanel creation = new JPanel();
		creation.setLayout(new GridLayout(4, 4));
		
		buttonCreer.addActionListener(new Creer_Post_it(this));

		
		JComboBox<String> cb = new JComboBox<>();
		cb.addItem("Text");
		cb.addItem("Dessin");
		cb.addActionListener(new Cb_Listener(this));
		
		creation.add(cb);
		creation.add(buttonCreer);
		
		JPanel dropbox = new JPanel();

		
		
		onglets.addTab("Creation", creation);
		onglets.addTab("DropBox", dropbox);
		onglets.setOpaque(true);
		
		jp.add(onglets);
		this.setPreferredSize(new Dimension(320,100));
		this.setSize(300,400);
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
