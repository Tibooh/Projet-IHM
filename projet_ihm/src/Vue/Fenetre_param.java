package Vue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Fenetre_param extends JFrame {

	Post_it_vue p;
	
	public Fenetre_param(Post_it_vue p) {
		
		this.p=p;
		
		JPanel param = new JPanel();
		param.setLayout(new BoxLayout(param, BoxLayout.Y_AXIS));
		param.add(new JLabel("Transparence"));
		JSlider slider = new JSlider(0,100);
		slider.setMajorTickSpacing(1);
		slider.setMinorTickSpacing ((int) 0.1);
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				float v = ((JSlider)e.getSource()).getValue();
				gerer_transparence(v);
			}


		});
		slider.setMajorTickSpacing(10);
		param.add(slider);
		param.add(new JLabel("Couleur"));
		param.add(new JLabel("Font"));
		
		
		this.add(param);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setVisible(true);
	}
	private void gerer_transparence(float v) {
		this.p.setOpacity((v/100));
	}
}
