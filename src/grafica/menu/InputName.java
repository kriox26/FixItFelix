package grafica.menu;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class InputName extends Grafica {
	private String imgPath = "src/grafica/imagenes/";
	private JTextField input;
	private String backgroundImage;
	private ImageIcon goBackIcon = new ImageIcon(imgPath+"Menu.png"); 

	public InputName(){
		File Image = new File(backgroundImage);
		input = new JTextField();
		input.setSize(300, 75);
		input.setVisible(true);
		goBack.setIcon(goBackIcon);
		goBack.setBounds(300, 500, 216, 51);
		add(goBack);
		add(input);
		this.setVisible(true);
		this.setSize(800, 600);
	}
}
