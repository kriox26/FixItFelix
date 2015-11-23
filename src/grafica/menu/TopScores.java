package grafica.menu;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class TopScores extends JFrame{
	private Button goBack;


	public TopScores(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		goBack = new Button("Menu");
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
