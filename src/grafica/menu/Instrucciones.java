package grafica.menu;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Instrucciones extends JFrame{
	private Button goBack;


	public Instrucciones(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		goBack = new Button("Menu");
		add(goBack);
		goBack.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				MainMenu mn = new MainMenu();
			}
		});
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		setTitle("Instrucciones de Juego");
		setSize(919, 720);
		setVisible(true);
	}
}
