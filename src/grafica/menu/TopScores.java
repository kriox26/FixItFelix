package grafica.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class TopScores extends Grafica {

	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "high_scores.jpg";
	private ImageIcon goBackIcon = new ImageIcon(imgPath + "Menu.png");


	public TopScores(){
		setLayout(new BorderLayout());
        File image = new File(backgroundImage);
		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 620));
		add(goBack);
		setTitle("Top Scores");
		setSize(919, 720);
		setVisible(true);
	}
}
