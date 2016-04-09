package Vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Controleur.MenuListener;
import Modele.Post_it_Abstract;

public class Post_it_vue extends JFrame {
	
	Principale prin;
	Post_it_Abstract p;
	Point mouseDownCompCoords;
	Post_it_vue t = this;
	
	public Post_it_vue(Principale prin,final Post_it_Abstract p) {
		this.prin=prin;
		this.mouseDownCompCoords=null;
		this.p = p;
		this.add(this.p);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				 mouseDownCompCoords = null;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				 mouseDownCompCoords = e.getPoint();
				 int b = e.getButton();
				 if(b==e.BUTTON3){
				 JPopupMenu pop = new JPopupMenu();
				 JMenuItem ter = new JMenuItem("Terminer Tache");
				 JMenuItem cach = new JMenuItem("Cacher");
				 JMenuItem nom = new JMenuItem(p.getName());

				 pop.add(nom);
				 pop.add(ter);
				 pop.add(cach);
				 pop.show(e.getComponent(), e.getX(), e.getY());
				 
				 ter.addActionListener(new MenuListener(t));
				 cach.addActionListener(new MenuListener(t));
				 
				 }
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
			}
		});
		this.setUndecorated(true);
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.GRAY));		
		this.setSize(210, 210);
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public Post_it_vue() {	
		this.setSize(250, 250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public Post_it_Abstract get_po(){
		return this.p;
	}
	public void ajoute_po(Post_it_Abstract p) {
		this.prin.term_pi(p);
	}
	
}
