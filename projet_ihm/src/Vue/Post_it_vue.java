package Vue;

import java.awt.Dimension;

import javax.swing.JFrame;

import Modele.Post_it_Interface;

public class Post_it_vue extends JFrame {

	Post_it_Interface p;
	public Post_it_vue(Post_it_Interface p) {
		this.p = p;
		
		this.setPreferredSize(new Dimension(320,100));
		this.setSize(320, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
	}
	public Post_it_vue() {	
		this.setPreferredSize(new Dimension(320,100));
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}
	
}
