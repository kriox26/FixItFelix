package grafica.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instrucciones extends JFrame{
	private JButton goBack;
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "guia.jpg";
	private ImageIcon goBackIcon = new ImageIcon("src/grafica/imagenes/Menu.png");


	public Instrucciones(){
		setLayout(new BorderLayout());
//		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));

        File image = new File(backgroundImage);

		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));

		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 620));

		goBack = new JButton();
		goBack.setIcon(goBackIcon);
		goBack.setBorder(null);
		add(goBack);

		goBack.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				MainMenu mn = new MainMenu();
			}
		});

//		setLayout(new FlowLayout(FlowLayout.CENTER, 100, 550));
		setTitle("Instrucciones de Juego");
		setSize(919, 720);
		setVisible(true);
	}
}
