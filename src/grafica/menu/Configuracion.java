package grafica.menu;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Configuracion extends Grafica{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imgPath = "src/grafica/imagenes/";
	private JButton nivel1, nivel2, nivel3;
	private ImageIcon goBackIcon = new ImageIcon(imgPath + "Menu.png");
	private ImageIcon nivel1Boton = new ImageIcon(imgPath + "Nivel1.png");
	private ImageIcon nivel2Boton = new ImageIcon(imgPath + "Nivel2.png");
	private ImageIcon nivel3Boton = new ImageIcon(imgPath + "Nivel3.png");
	
	public Configuracion(){
		setLayout(new FlowLayout());
		//File image = new File(backgroundImage);
		setContentPane(new JLabel());
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		configurarBotones();
		goBack.setContentAreaFilled(false);
		goBack.setBounds(65, 400, 261, 51);
		goBack.setIcon(goBackIcon);
		add(goBack);
		setTitle("Configuracion");
		setSize(400,500);
		this.setBounds(250, 100, 400, 500);
		setVisible(true);
	}
	public void configurarBotones(){
		nivel1 = new JButton();
		nivel2 = new JButton();
		nivel3 = new JButton();
		nivel1.setIcon(nivel1Boton);
		nivel2.setIcon(nivel2Boton); 
		nivel3.setIcon(nivel3Boton);
		nivel1.setBounds(65, 100, 261, 51);
		nivel2.setBounds(65, 155, 261, 51);
		nivel3.setBounds(65, 210, 261, 51);
		add(nivel1);
		add(nivel2);
		add(nivel3);
	}
}
