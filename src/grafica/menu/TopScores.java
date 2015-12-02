package grafica.menu;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TopScores extends Grafica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "high_scores.jpg";
	private ImageIcon goBackIcon = new ImageIcon(imgPath + "Menu.png");
	private String[] titulo = {"Nombre","Score"};
	private Object[][] data = {{"Matias", "123"},{"Jorge","123124"}, {"Santi", "123412"}};
	//private JTable tabla = new JTable(data,titulo);


	public TopScores(){
		DefaultTableModel dtm = new DefaultTableModel(data, titulo);
		final JTable tabla = new JTable(dtm);
		tabla.setBounds(250, 150, 400, 250);
		setLayout(null);
		File image = new File(backgroundImage);
		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));
		goBack.setIcon(goBackIcon);
		goBack.setBorder(null);
		goBack.setBounds(10, 625, 216, 51);
		goBack.setContentAreaFilled(false);
		add(goBack);
		add(tabla);
		setTitle("Top Scores");
		setSize(919, 720);
		setVisible(true);
	}
}
