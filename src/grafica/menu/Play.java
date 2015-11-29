package grafica.menu;

import grafica.niceland.VentanaView;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.main.Main;

public class Play extends Grafica {
	private String imgPath = "src/grafica/niceland/";
	private String backgroundImage = imgPath + "FondoNiceland.jpg";
	private JLabel fondo;
	private static final int horEdificio= 250;
	private static final int verEdificio= 120;
	private Map<String, BufferedImage> secciones = new TreeMap<String, BufferedImage>();

	/*
	 * Se crean todas las imagenes de Niceland, ventanas con obstaculos
	 * todo.
	 */
	public Play(Main main, VentanaView[][] building){
		File imgFondo = new File(backgroundImage);
		JLabel fondo = new JLabel(new ImageIcon(imgFondo.getAbsolutePath()));
		setLayout(new FlowLayout());
		add(goBack);
//		setContentPane(fondo);
		setSize(800, 1028);
		setVisible(true);
		cargarNiceland(building);
		try{
			Thread.sleep(20000);
		} catch(InterruptedException e){
			
		}
	}

	public void addKeyboardEvents(KeyAdapter keyadapter){
		this.addKeyListener(keyadapter);
	}

	public void cargarNiceland(VentanaView[][] building){
        // Dibujar secciones primero
		BufferedImage img = secciones.get("edificio_150_copy.png");
		this.getGraphics().drawImage(img, horEdificio, 0, null);
        // Despues dibujamos ventanas sobre las secciones
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                this.getGraphics().drawImage(building[i][j].getImagenActual(), building[i][j].getOffsetX(), building[i][j].getOffsetY(), null);
            }
        }
	}

	public void paintComponents(Graphics g){
		super.paintComponents(g);
	}
}
