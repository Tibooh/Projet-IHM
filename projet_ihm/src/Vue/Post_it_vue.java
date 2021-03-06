package Vue;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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
	Timer timer;
	private boolean audioLaunched=false;
	Boolean coul;
	Boolean son;

	public Post_it_vue(Principale prin, final Post_it_Abstract pi,final Boolean coul,final Boolean son) {
		this.prin = prin;
		this.mouseDownCompCoords = null;
		this.p = pi;
		this.add(this.p);
		this.coul=coul;
		this.son = son;
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				mouseDownCompCoords = null;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				mouseDownCompCoords = e.getPoint();
				int b = e.getButton();
				if (b == e.BUTTON3) {
					JPopupMenu pop = new JPopupMenu();
					JMenuItem param = new JMenuItem("Parametres");
					JMenuItem ter = new JMenuItem("Terminer Tache");
					JMenuItem cach = new JMenuItem("Cacher");
					JMenuItem nom = new JMenuItem(p.getName());

					pop.add(nom);
					pop.add(param);
					pop.add(ter);
					pop.add(cach);
					pop.show(e.getComponent(), e.getX(), e.getY());

					ter.addActionListener(new MenuListener(t));
					cach.addActionListener(new MenuListener(t));
					param.addActionListener(new MenuListener(t));

				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
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

		timer = new Timer();
		timer.schedule(new TimerTask() {
			//changement de couleur
			float r = p.getColor().getRed();
			float g = p.getColor().getGreen();
			float b = p.getColor().getBlue();
			
			float R=255;
			float G=0;
			float B=0;
			float sec =1+ ((p.getDate().getTime())-(new Date().getTime()) )/1000;

			float ticR = (R-r)/(sec);
			float ticG = (G-g)/(sec);
			float ticB = (B-b)/(sec);
			
			@Override
			public void run() {
				// System.out.println("tic");
				if (new Date().after(p.getDate())){
					ajoute_po(p);
					this.cancel();
				}

				if(r<R)
					r+=ticR;
				
				if(g>G)
					g+=ticG;
				
				if(b>B)
					b+=ticB;
				
				if((r<255&&g>G&&b>B)&&coul)
					p.setColor(new Color((int)r,(int)g,(int)b));
				
				//System.out.println("tic = "+sec+" r : "+r+" g : "+g+" b : "+b);
				if ( son&& ((int) r > 250 && (int) g < 5 && (int) b < 5
						&& audioLaunched == false) ) {
					System.out.println("Fin du temps");
					try {
						AudioInputStream audioIn = AudioSystem
								.getAudioInputStream(new BufferedInputStream(new FileInputStream(
										"projet_ihm/resources/beep-01a.wav")));
						// Get a sound clip resource.
						Clip clip = AudioSystem.getClip();
						// Open audio clip and load samples from the audio input
						// stream.
						clip.open(audioIn);
						clip.start();
					} catch (UnsupportedAudioFileException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (LineUnavailableException e) {
						e.printStackTrace();
					}
					audioLaunched = true;
				}

			}
		}, 1000, 1000);

	}

	public Post_it_vue() {
		this.setSize(250, 250);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public Post_it_Abstract get_po() {
		return this.p;
	}

	public void ajoute_po(Post_it_Abstract p) {
		this.prin.term_pi(p);
	}

}
