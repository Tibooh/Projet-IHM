package Modele;



import java.awt.Color;
import java.util.Date;

import javax.swing.JPanel;

public abstract class Post_it_Abstract extends JPanel implements Post_it_Interface{

	protected String name;
	protected Date date;
	protected Color color;
	
	public String getName(){
		return this.name;
	}

	public Date getDate(){
		return this.date;
	}
	public Color getColor(){
		return this.color;
	}

	public abstract void setColor(Color color2);
	
}
