package grafica.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;


public class TopScores extends Grafica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "high_scores.jpg";
	private ImageIcon goBackIcon = new ImageIcon(imgPath + "Menu.png");
	private JTable tabla = new JTable();


	public TopScores(){
		
		tabla.setFillsViewportHeight(true);
		setLayout(new BorderLayout());
		File image = new File(backgroundImage);
		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 620));
		goBack.setIcon(goBackIcon);
		goBack.setBorder(null);
		goBack.setContentAreaFilled(false);
		add(goBack);
		add(tabla);
		setTitle("Top Scores");
		setSize(919, 720);
		setVisible(true);
	}
}
