package grafica.menu;

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
	private Map<String, BufferedImage> secciones = new TreeMap<String, BufferedImage>();
	private Map<String, BufferedImage> ventanas = new TreeMap<String, BufferedImage>();

	/*
	 * Se crean todas las imagenes de Niceland, ventanas con obstaculos
	 * todo.
	 */
	public Play(Main main){
		cargarEdificio();
		File imgFondo = new File(backgroundImage);
		JLabel fondo = new JLabel(new ImageIcon(imgFondo.getAbsolutePath()));
		setLayout(new FlowLayout());
		add(goBack);
//		setContentPane(fondo);
		setSize(800, 1028);
		setVisible(true);
		cargarNiceland();
		try{
			Thread.sleep(20000);
		} catch(InterruptedException e){
			
		}
	}

	public void addKeyboardEvents(KeyAdapter keyadapter){
		this.addKeyListener(keyadapter);
	}

	public void cargarNiceland(){
		BufferedImage img = secciones.get("edificio_150_copy.png");
		this.getGraphics().drawImage(img, horEdificio, 0, null);
	}

	public void paintComponents(Graphics g){
		super.paintComponents(g);
	}

	private void cargarEdificio(){
		File folder = new File("src/grafica/imagenes/edificio/");
		File[] filesList = folder.listFiles();
		cargarImagenes(this.secciones, filesList);

		folder = new File("src/grafica/imagenes/ventanas_y_panel");
		filesList = folder.listFiles();
		cargarImagenes(this.ventanas, filesList);
	}

	private void cargarImagenes(Map<String, BufferedImage> imagenes, File[] filesList){
		for(File img : filesList){
			try{
				BufferedImage imagen = ImageIO.read(img);
				imagenes.put(img.getName(), imagen);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

}
