package grafica.menu;
import java.awt.event.MouseAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "MainMenu.png";
	private JButton instrucciones, play, highscores, config;
	private ImageIcon playBoton = new ImageIcon(imgPath + "Play.png");
	private ImageIcon highscoresBoton= new ImageIcon(imgPath + "HighScores.png");
	private ImageIcon instruccionesBoton= new ImageIcon(imgPath + "Instrucciones.png");
	private ImageIcon configBoton = new ImageIcon(imgPath + "Configuracion3.png");
	
	public MainMenu(){
		/*Menu principal que seria lo primero que aparece al lanzar la aplicacion.
		 *Primero Agrego los botones al menu principal.
		 */
        File image = new File(backgroundImage);

		//setLayout(new BorderLayout());
		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));
		setLayout(null);
		configurarBotones();

		/*EL titulo de la Ventana. Creo que igual deberia tener "Fix It Felix".
		 *El tama�o de la ventana � Frame esta justo para la imagen de fondo.
		 */
		setTitle("MainMenu");
		setSize(919,720);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void configurarBotones(){
		instrucciones = new JButton();
		play = new JButton();
		highscores = new JButton();
		config = new JButton();
		play.setIcon(playBoton);
		highscores.setIcon(highscoresBoton);
		instrucciones.setIcon(instruccionesBoton);
		config.setIcon(configBoton);		
		config.setContentAreaFilled(false);
		config.setBounds(840, 50,50,50);
		instrucciones.setBounds(50, 550, 261, 51);
		play.setBounds(320, 550, 261, 51);
		highscores.setBounds(590, 550, 261, 51);
		highscores.setBorder(null);
		play.setBorder(null);
		config.setBorder(null);
		instrucciones.setBorder(null);
		add(highscores); add(play);
		add(instrucciones);	
		add(config);
	}
	public void addMouseEvents(MouseAdapter mouseAdap, MouseAdapter mouseAdap2, 
			MouseAdapter mouseAdap3, MouseAdapter mouseAdap4){
		play.addMouseListener(mouseAdap);
		highscores.addMouseListener(mouseAdap2);
		instrucciones.addMouseListener(mouseAdap3);
		config.addMouseListener(mouseAdap4);
	}

	public void turnOn(){
		setVisible(true);
	}

	public void turnOff(){
		setVisible(false);
	}

}
