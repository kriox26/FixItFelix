package grafica.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Instrucciones extends Grafica{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "guia.jpg";
	private ImageIcon goBackIcon = new ImageIcon("src/grafica/imagenes/Menu.png");


	public Instrucciones(){
		setLayout(new BorderLayout());
        File image = new File(backgroundImage);
		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 620));
		goBack = new JButton();
		goBack.setIcon(goBackIcon);
		goBack.setBorder(null);
		goBack.setContentAreaFilled(false);
		add(goBack);
		setTitle("Instrucciones de Juego");
		setSize(919, 720);
		setVisible(true);
	}
}
