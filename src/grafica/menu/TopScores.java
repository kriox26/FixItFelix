package grafica.menu;

import java.awt.Component;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class TopScores extends Grafica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "high_scores.jpg";
	private ImageIcon goBackIcon = new ImageIcon(imgPath + "Menu.png");
	private Object[][] data = {{"Matias", "123"},
								{"Jorge","123124"}, 
								{"Santi", "123412"}};
	private String[] cabecera = {"Nombre","Score"};
	private JScrollPane scroll= new JScrollPane();


	public TopScores(){
		setLayout(null);
		File image = new File(backgroundImage);
		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));
		configurarTabla();
		goBack.setIcon(goBackIcon);
		goBack.setBorder(null);
		goBack.setBounds(10, 625, 216, 51);
		goBack.setContentAreaFilled(false);
		add(goBack);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Top Scores");
		setSize(919, 720);
		setVisible(true);
	}
	
	public void configurarTabla(){
		JTable tabla = new JTable(data, cabecera);
		tabla.setOpaque(false);
		tabla.setBorder(null);
		tabla.setBackground(getBackground());
		JScrollPane js = new JScrollPane(tabla);
		js.setSize(400, 150);
		js.setBounds(250, 200, 400, 250);
		js.setBorder(null);
		js.setOpaque(false);
		js.getViewport().setBorder(null);
		js.getViewport().setOpaque(false);
		add(js);
	}
}
