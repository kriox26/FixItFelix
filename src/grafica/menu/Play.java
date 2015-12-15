package grafica.menu;

import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import controlador.Controlador;
import grafica.dinamica.objetos.LadrilloView;
import grafica.dinamica.personajes.FelixView;
import grafica.dinamica.personajes.RalphView;
import grafica.niceland.VentanaView;

public class Play extends Grafica {
	private static final long serialVersionUID = 1L;
    private PanelJuego panel;
    private BufferedImage seccionActual;
   
    
    /*
    * Se crean todas las imagenes de Niceland, ventanas con obstaculos
    * todo.
    */
    public Play(Controlador ctrl, VentanaView[][] building, Map<String, BufferedImage> imagenes, FelixView felix, RalphView rView, int desde, int hasta){
    	this.setResizable(false);
    	this.setVisible(true);
    	this.seccionActual = imagenes.get("piso1.png");
    	panel = new PanelJuego(building,imagenes, felix, rView, desde, hasta);
    	this.add(panel);
        setSize(800, 600);
    	Timer timer = new Timer("Turnos");
    	timer.schedule(ctrl, 0, 100);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addKeyboardEvents(KeyAdapter keyadapter){
        this.addKeyListener(keyadapter);
    }

    public void setSeccionActual(BufferedImage img){
    	this.seccionActual = img;
    }
    
    public void repintar(VentanaView[][] building, FelixView fView, RalphView rView, int desde, int hasta, List<LadrilloView> ladrillos){
        this.panel.actualizar(building, fView, rView, desde, hasta, this.seccionActual, ladrillos);
        this.panel.repaint();
    }

    public PanelJuego getPanel(){
    	return this.panel;
    }
    
}
