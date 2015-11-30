package grafica.menu;

import grafica.niceland.VentanaView;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.main.Main;

public class Play extends Grafica {
	private String imgPath = "src/grafica/niceland/";
	private String backgroundImage = imgPath + "FondoNiceland.jpg";
	private JLabel fondo;
	private static final int horEdificio= 250;
	private static final int verEdificio= 120;
	private static final int offsetYVentanas = 68;
	private static final int offsetXVentanas = 30;
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
		setSize(800, 600);
		setVisible(true);
		cargarNiceland(building);
		try{
			Thread.sleep(200000);
		} catch(InterruptedException e){
			
		}
	}

	public void addKeyboardEvents(KeyAdapter keyadapter){
		this.addKeyListener(keyadapter);
	}

	public void cargarNiceland(VentanaView[][] building){
        // Dibujar secciones primero
		File imagen = new File("src/grafica/imagenes/edificio/edificio_150_seccion1.png");
		BufferedImage img = null;
		try{
			img = ImageIO.read(imagen);
		}catch(IOException e){
			e.printStackTrace();
		}
		this.getGraphics().drawImage(img, horEdificio, verEdificio, null);
		this.getGraphics().drawImage(building[0][0].getImagenActual(), horEdificio + offsetXVentanas, verEdificio + (340 - offsetYVentanas), null);
		this.getGraphics().drawImage(building[0][1].getImagenActual(), horEdificio + (2*offsetXVentanas)+10, verEdificio + (340 - offsetYVentanas), null);
		this.getGraphics().drawImage(building[0][2].getImagenActual(), horEdificio + (3*offsetXVentanas)+30, verEdificio + (340 - 97), null);
		this.getGraphics().drawImage(building[0][3].getImagenActual(), horEdificio + (4*offsetXVentanas)+80, verEdificio + (340 - offsetYVentanas), null);
		this.getGraphics().drawImage(building[0][4].getImagenActual(), horEdificio + (5*offsetXVentanas)+90, verEdificio + (340 - offsetYVentanas), null);
		this.getGraphics().drawImage(building[1][0].getImagenActual(), horEdificio + offsetXVentanas, verEdificio + (340 - 2*offsetYVentanas - 18), null);
		this.getGraphics().drawImage(building[1][1].getImagenActual(), horEdificio + (2*offsetXVentanas)+10, verEdificio + (340 - 2*offsetYVentanas - 18), null);
		this.getGraphics().drawImage(building[1][2].getImagenActual(), horEdificio + (3*offsetXVentanas)+30, verEdificio + (340 - 2*offsetYVentanas - 18), null);
		this.getGraphics().drawImage(building[1][3].getImagenActual(), horEdificio + (4*offsetXVentanas)+80, verEdificio + (340 - 2*offsetYVentanas - 18), null);
		this.getGraphics().drawImage(building[1][4].getImagenActual(), horEdificio + (5*offsetXVentanas)+90, verEdificio + (340 - 2*offsetYVentanas - 18), null);
        // Despues dibujamos ventanas sobre las secciones
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 5; j++) {
//                this.getGraphics().drawImage(building[i][j].getImagenActual(), building[i][j].getOffsetX(), building[i][j].getOffsetY(), null);
//            }
//        }
	}

	public void paintComponents(Graphics g){
		super.paintComponents(g);
	}
}
