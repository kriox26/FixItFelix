package grafica.menu;

import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputName extends Grafica {
	private String imgPath = "src/grafica/imagenes/";
	private JTextField input;
	private String backgroundImage =imgPath + "high_scores.jpg";
	private ImageIcon goBackIcon = new ImageIcon(imgPath+"Menu.png"); 

	public InputName(){
		setLayout(null);
		setContentPane(new JLabel());
		File Image = new File(backgroundImage);
		setContentPane(new JLabel(new ImageIcon(Image.getAbsolutePath())));
		input = new JTextField();
		input.setBounds(0, 0, 200, 75);
		input.setBackground(Color.BLACK);
		input.setSize(200, 75);
		input.setVisible(true);
		goBack.setIcon(goBackIcon);
		goBack.setBounds(0, 100, 216, 51);
		add(goBack);
		add(input);
		setSize(919, 720);
		setResizable(false);
		setVisible(true);
	}
}
