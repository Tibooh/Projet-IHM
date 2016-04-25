package Modele;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Vue.Post_it_vue;


public class PanelColor extends JPanel {
	
	
	Color c;
	
	JSlider js1;
	JSlider js2;
	JSlider js3;
	
	JTextField jt1;
	JTextField jt2;
	JTextField jt3;
	
	JTextField jt4;
	JTextArea jta;
	
	JPanel jp1;
	JPanel jp2;
	JPanel jp3;

	public PanelColor() {
		ChangeListener l1 = new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				jt1.setText(String.valueOf(js1.getValue()));	
				jt2.setText(String.valueOf(js2.getValue()));
				jt3.setText(String.valueOf(js3.getValue()));
				
				c = new Color(js1.getValue(),js2.getValue(),js3.getValue());
				
				jt4.setText("#"+Integer.toHexString(c.getRGB()).substring(2));
				
				jta.setBackground(c);
			}
		};
		
		c = new Color(219,219,96);
		
//		this.setLayout();
	
		jp1 = new JPanel();
		jp1.setLayout(new BoxLayout(jp1,BoxLayout.PAGE_AXIS));
		
		jp2 = new JPanel();
		jp2.setLayout(new BoxLayout(jp2,BoxLayout.PAGE_AXIS));
		
		jp3= new JPanel();
		jp3.setLayout(new BoxLayout(jp3,BoxLayout.PAGE_AXIS));
		
		
		js1 = new JSlider(0,255);
		js1.setValue(219);
		js1.addChangeListener(l1);
		js2 = new JSlider(0,255);
		js2.setValue(219);
		js2.addChangeListener(l1);
		js3 = new JSlider(0,255);
		js3.setValue(96);
		js3.addChangeListener(l1);
		jp1.add(js1);
		jp1.add(js2);
		jp1.add(js3);
		
		jt1= new JTextField("219    ");
		jt1.setFocusable(false);
		jt2= new JTextField("219    ");
		jt2.setFocusable(false);
		jt3= new JTextField("96     ");
		jt3.setFocusable(false);
		jp2.add(jt1);
		jp2.add(jt2);
		jp2.add(jt3);
		
		jt4=new JTextField("#"+Integer.toHexString(c.getRGB()).substring(2));
		jt4.setFocusable(false);
		jta = new JTextArea();
		jta.setBackground(c);
		jta.setFocusable(false);
		
		jp3.add(jta);
		jp3.add(jt4);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		this.setPreferredSize(new Dimension(320,100));
		this.setSize(320, 100);
	}
	
	public Color getColor(){
		return this.c;				
	}
		
}
