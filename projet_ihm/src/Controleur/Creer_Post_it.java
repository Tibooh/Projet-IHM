package Controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

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
		
		String name =p.getNomDuP();
		Date dat = p.getDate();
		Color c = p.getColor();
		Boolean couleur = p.getcoulDyn();
		Boolean son = p.getSonDyn();

		if(p.text=="Text"){
			Post_it_Base pi = new Post_it_Base(name,dat,c);
			p.nouveauPost_it(pi);
			new Post_it_vue(p,pi,couleur,son);
		}
		else if(p.text=="Dessin"){
			new Post_it_vue(p,new Post_it_Dessin(name,dat,c),couleur,son);
		}
	}

}
