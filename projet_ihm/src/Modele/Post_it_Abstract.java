package Modele;



import java.util.Date;

import javax.swing.JPanel;

public abstract class Post_it_Abstract extends JPanel implements Post_it_Interface{

	protected String name;
	protected Date date;
	
	public String getName(){
		return this.name;
	}

	public Date getDate(){
		return this.date;
	}
}
