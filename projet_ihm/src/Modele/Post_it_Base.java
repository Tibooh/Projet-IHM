package Modele;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JTextArea;

public class Post_it_Base extends Post_it_Abstract{
	
	JTextArea jt;
	Font font;
	
	public Post_it_Base(String name,Date d) {
		this.name = name;
		this.date = d;
		this.setLayout(new GridLayout(1, 1));
		font= new Font("Lucida Handwriting", Font.BOLD,12 );
		jt = new JTextArea();
		jt.setFont(font);
		jt.setBackground(new Color(243, 243, 146));
		this.add(this.jt);
	}
	
}
