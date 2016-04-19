package Modele;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Date;

public class Post_it_Dessin extends Post_it_Abstract implements MouseListener, MouseMotionListener{
	ArdoiseMagique a;
	
	public Post_it_Dessin(String name,Date d,Color c) {
		this.name = name;
		this.date = d;
		this.color = c;
		this.setLayout(new GridLayout(1, 1));
		a = new ArdoiseMagique(this.color);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.add(a);
		
		//this.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == e.BUTTON3)
			a.clear();
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		a.newCurve();
	}

	//nok
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//nok
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		//this.pack();
		int x = e.getPoint().x-this.getInsets().left;
		int y= e.getPoint().y-this.getInsets().top;
		a.addPoint(x,y);
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		//a.addPoint(e.getPoint().x,e.getPoint().y);
		
	}

	@Override
	public void setColor(Color color2) {
		this.a.setColor(color2);
	}

}
