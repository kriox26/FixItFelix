package grafica.menu;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Instrucciones extends JFrame{
	private JButton goBack;
	private ImageIcon goBackBoton = new ImageIcon("src/grafica/imagenes/Menu.png");


	public Instrucciones(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		goBack = new JButton();
		goBack.setIcon(goBackBoton);
		goBack.setBorder(null);
		goBack.setContentAreaFilled(false);
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
