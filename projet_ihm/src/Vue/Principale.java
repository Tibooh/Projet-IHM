package Vue;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Controleur.Cb_Listener;
import Controleur.Creer_Post_it;
import Modele.PanelColor;
import Modele.Post_it_Abstract;

public class Principale extends JFrame {

	JButton buttonCreer;
	JTabbedPane onglets;
	public static String text = "Text";

	ArrayList<Post_it_Abstract> listeTermine;
	ArrayList<Post_it_Abstract> listeEnCour;

	JList<String> lencours;
	JList<String> lterm;
	DefaultListModel<String> modelListeEnCours;
	DefaultListModel<String> modelListeTerm;

	JTextField j;
	JTextField m;
	JTextField a;
	JTextField h;
	JTextField mi;

	JTextField name;
	
	Checkbox couleur;
	Checkbox son ;
	
	PanelColor pc;

	public Principale() {

		/* Liste pour les sauvegardes */
		listeTermine = new ArrayList<>();
		listeEnCour = new ArrayList<>();


		
		Container jp = this.getContentPane();
		onglets = new JTabbedPane(SwingConstants.TOP);
		buttonCreer = new JButton("Creer");

		JPanel creation = new JPanel();
		creation.setLayout(new BoxLayout(creation, BoxLayout.Y_AXIS));

		name = new JTextField();
		buttonCreer.addActionListener(new Creer_Post_it(this));

		JComboBox<String> cb = new JComboBox<>();
		cb.addItem("Text");
		cb.addItem("Dessin");
		cb.addActionListener(new Cb_Listener(this));

		
		
		JPanel date = new JPanel();
		date.setLayout(new GridLayout(2, 5));
		date.add(new JLabel("Jour"));
		date.add(new JLabel("Mois"));
		date.add(new JLabel("Ann�e"));
		date.add(new JLabel("Heure"));
		date.add(new JLabel("Minutes"));

		j = new JTextField("0");
		m = new JTextField("0");
		a = new JTextField("0");
		h = new JTextField("0");
		mi = new JTextField("0");

		date.add(j);
		date.add(m);
		date.add(a);
		date.add(h);
		date.add(mi);

		
		JPanel type = new JPanel();
		type.setBorder(new TitledBorder("Type"));
		type.add(cb);
		creation.add(type);
		
		JPanel titre = new JPanel();
		titre.setBorder(new TitledBorder("Titre"));
		name.setPreferredSize(new Dimension(200, 22));
		titre.add(name);
		creation.add(titre);
		
		this.pc = new PanelColor();
		pc.setBorder(new TitledBorder("Couleur"));
		creation.add(pc);
		
		JPanel expiration = new JPanel();
		expiration.setLayout(new BoxLayout(expiration, BoxLayout.Y_AXIS));
		expiration.setBorder(new TitledBorder("Expiration"));
		
		expiration.add(date);
		//creation.add(new JLabel("Couleur d'expiration dynamique"));
		couleur = new Checkbox("Couleur d'expiration dynamique", false);
		son = new Checkbox("Son d'expiration", false);
		expiration.add(couleur);
		expiration.add(son);
		
		creation.add(expiration);
		creation.add(buttonCreer);
		

		//JPanel dropbox = new JPanel();

		JPanel gestion = new JPanel();
		gestion.setLayout(new BoxLayout(gestion, BoxLayout.Y_AXIS));

		gestion.add(new JLabel("Taches en cours"));
		modelListeEnCours = new DefaultListModel<>();
		lencours = new JList<>(modelListeEnCours);
		lencours.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 3));
		lencours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lencours.setMaximumSize(new Dimension(250, 100));
		lencours.setMinimumSize(new Dimension(250, 100));
		lencours.setPreferredSize(new Dimension(250, 100));
		lencours.setSize(new Dimension(250, 100));
		lencours.setVisibleRowCount(5);
		JScrollPane scrollPane = new JScrollPane(lencours);
		scrollPane.setPreferredSize(new Dimension(250, 100));
		scrollPane.setBackground(new Color(1f, 1f, 1f, .5f));
		// scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// ajouter les post its dedans
		gestion.add(scrollPane, BorderLayout.SOUTH);
		JButton b = new JButton("Afficher");
		gestion.add(b);

		gestion.add(new JLabel("Taches termine"));
		modelListeTerm = new DefaultListModel<>();
		lterm = new JList<>(modelListeTerm);
		// ajouter les post its dedans
		lterm.setMaximumSize(new Dimension(250, 100));
		lterm.setMinimumSize(new Dimension(250, 100));
		lterm.setPreferredSize(new Dimension(250, 100));
		lterm.setSize(new Dimension(250, 100));
		lterm.setBorder(BorderFactory.createLineBorder(new Color(100, 100, 100), 3));
		lterm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lterm.setBackground(new Color(1f, 1f, 1f, .5f));
		lterm.setVisibleRowCount(5);
		JScrollPane scrollPane2 = new JScrollPane(lterm);
		scrollPane2.setPreferredSize(new Dimension(250, 100));
		scrollPane2.setBackground(new Color(1f, 1f, 1f, .5f));
		// scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		gestion.add(scrollPane2);
		JButton b2 = new JButton("Revoir");
		gestion.add(b2);

		JPanel param = new JPanel();

		onglets.addTab("Creation", creation);
		onglets.addTab("Gestion", gestion);
		//onglets.addTab("Parametres", param);
		//onglets.addTab("DropBox", dropbox);
		onglets.setOpaque(true);

		jp.add(onglets);
		this.setSize(370, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
/*
		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				// System.out.println("tic");
				synchronized (listeEnCour) {

					// for (Post_it_Abstract p : listeEnCour)
					for (int i = 0; i < listeEnCour.size(); i++)
						if (new Date().after(listeEnCour.get(i).getDate()))
							term_pi(listeEnCour.get(i));

				}

			}
		}, 1000, 1000);
		*/
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Principale();
	}

	public String getNomDuP() {
		return this.name.getText();
	}

	public void nouveauPost_it(Post_it_Abstract po) {
		modelListeEnCours.addElement(po.getName());

		lencours.setModel(modelListeEnCours);
		synchronized (listeEnCour) {
			listeEnCour.add(po);
		}
	}

	public void term_pi(Post_it_Abstract p) {

		listeTermine.add(p);

		modelListeEnCours.removeElement(p.getName());
		modelListeTerm.addElement(p.getName());

		lencours.setModel(modelListeEnCours);
		lterm.setModel(modelListeTerm);

		synchronized (listeEnCour) {
			listeEnCour.remove(p);
		}

	}

	public Date getDate() {
		Date date = new Date();
		// System.out.println(date);
		// System.out.println(simpleDateFormat.parse(this.j.getText()+"/"+this.m.getText()+"/"+this.a.getText()+"
		// "+this.h.getText()));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(this.j.getText()));
		cal.add(Calendar.YEAR, Integer.parseInt(this.a.getText()));
		cal.add(Calendar.MONTH, Integer.parseInt(this.m.getText()));
		cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(this.h.getText()));
		cal.add(Calendar.MINUTE, Integer.parseInt(this.mi.getText()));
		// System.out.println(cal.getTime());
		return cal.getTime();
		// simpleDateFormat.parse(this.j.getText()+"/"+this.m.getText()+"/"+this.a.getText()+"
		// "+this.h.getText());
	}

	public Color getColor() {
		return this.pc.getColor();
	}

	public Boolean getcoulDyn() {
		return this.couleur.getState();
	}
	public Boolean getSonDyn() {
		return this.son.getState();
	}

}
