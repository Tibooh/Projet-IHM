package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Principal;

import javax.swing.JMenuItem;

import Modele.Post_it_Abstract;
import Modele.Post_it_Interface;
import Vue.Post_it_vue;
import Vue.Principale;

public class MenuListener implements ActionListener {

	Post_it_vue p;
	
	public MenuListener(Post_it_vue p) {
		this.p=p;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem jm = (JMenuItem) e.getSource();
		if(jm.getText()=="Cacher")
			this.p.setVisible(false);
		else if(jm.getText()=="Terminer Tache"){
			p.ajoute_po(p.get_po());
			this.p.dispose();
		}
	}

}
