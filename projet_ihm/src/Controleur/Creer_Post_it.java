package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Post_it_Base;
import Modele.Post_it_Dessin;
import Vue.Post_it_vue;
import Vue.Principale;

public class Creer_Post_it implements ActionListener {

	Principale p;
	
	public Creer_Post_it(Principale principale) {
		this.p = principale;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(p.text=="Text")
			new Post_it_vue(new Post_it_Base());
		else if(p.text=="Dessin"){
			new Post_it_vue(new Post_it_Dessin());
		}
	}

}
