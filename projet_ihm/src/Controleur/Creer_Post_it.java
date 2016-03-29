package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vue.Post_it_vue;

public class Creer_Post_it implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new Post_it_vue();
	}

}
