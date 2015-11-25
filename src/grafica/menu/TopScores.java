package grafica.menu;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TopScores extends JFrame{
	private JButton goBack;
	private ImageIcon goBackBoton = new ImageIcon("src/grafica/imagenes/Menu.png");

	public TopScores(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		goBack = new JButton();
		goBack.setIcon(goBackBoton);
		goBack.setBorder(null);
		goBack.setContentAreaFilled(false);
		goBack.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				MainMenu mn = new MainMenu();
			}
		});
		add(goBack);
		setTitle("Top Scores");
		setSize(919, 720);
		setVisible(true);
	}
}
