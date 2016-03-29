package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import Vue.Principale;

public class Cb_Listener implements ActionListener {

	Principale p;
	
	public Cb_Listener(Principale principale) {
		this.p=principale;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> jc = (JComboBox<String>) e.getSource();
		this.p.text=jc.getSelectedItem().toString();
	}

}
