package controlador;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import grafica.menu.Configuracion;
import grafica.menu.Grafica;
import grafica.menu.Instrucciones;
import grafica.menu.MainMenu;
import grafica.menu.Play;
import grafica.menu.TopScores;
import grafica.niceland.IrrompibleView;
import grafica.niceland.PuertaView;
import grafica.niceland.SemiCircularView;
import grafica.niceland.SimpleView;
import grafica.niceland.VentanaView;
import modelo.direcciones.Direccion;
import modelo.main.Main;
import modelo.niceland.Irrompible;
import modelo.niceland.Niceland;
import modelo.niceland.Puerta;
import modelo.niceland.Semicircular;
import modelo.niceland.Simple;
import modelo.niceland.Ventana;

public class Controlador {
	private Grafica view;
	private Main model;
	private static MainMenu MENU = new MainMenu();
	private Map<String, BufferedImage> imagenes = new TreeMap<String, BufferedImage>();
    private VentanaView[][] edificio;
    
    
	public Controlador(){}

	public Controlador(Main model, int nivel){
		this.model= model;
		cargarImagenes();
        edificio = new VentanaView[nivel * 3][5];
     //   crearEdificio(nivel);
        MENU.addMouseEvents(new ManejaPlayAdapter(), new ManejaTopScoresAdapter(), 
        		new ManejaInstrucciones(), new ManejaConfiguracion());
	}

	private void cargarImagenes(){
		File carpeta = new File("src/grafica/imagenes/");
		File[] lista = carpeta.listFiles();
		cargaRecursiva(lista);
	}

	private void cargaRecursiva(File[] lista){
		for(File act : lista){
			if(act.isDirectory()){
				cargaRecursiva(act.listFiles());
			}else{
				try{
					BufferedImage imagen = ImageIO.read(act);
					imagenes.put(act.getName(), imagen);
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	    
    private void crearEdificio(int nivel){
        int x = 0;
        int y = 0;
        Niceland building = model.getNiceland();
        for (int i = 0; i < nivel * 3 ; i++) {
            Ventana[][] ventanas = building.getSecciones()[i].getVentanas();
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 5; j++) {
                    Ventana act = ventanas[k + i][j];
                    if(act instanceof Irrompible)
                        edificio[k + i][j] = generarViewIrrompible(act, x, y);
                    else if(act instanceof Simple)
                        edificio[k + i][j] = generarViewSimple(act, x, y);
                    else if(act instanceof Puerta)
                        edificio[k + i][j] = generarViewPuerta(act, x, y);
                    else if(act instanceof Semicircular)
                        edificio[k + i][j] = generarViewSemiCircular(act, x, y);
                }
            }
        }
    }
    
    public IrrompibleView generarViewIrrompible(Ventana ven, int x, int y){
        switch (ven.getObstaculo().getDireccion()) {
            case DERECHA: return new IrrompibleView(imagenes.get("irrompible_derecha.png"), x, y);
            
            case IZQUIERDA: return new IrrompibleView(imagenes.get("irrompible_izquierda.png"), x, y);
            
            default: return new IrrompibleView(imagenes.get("irrompible_cerrada.png"), x, y);
        }
    }
    
    public SimpleView generarViewSimple(Ventana ven, int x, int y){
        SimpleView act = new SimpleView();
        switch (ven.estadoTotal()) {
            case 0: act = new SimpleView(imagenes.get("simple.png"), x, y);// Esta arreglada
                    break;
            case 1: act = new SimpleView(imagenes.get("media_rota_abajo.png"), x, y); // La ventana esta media rota abajo
                    break;
            case 2: act = new SimpleView(imagenes.get("media_rota_ambos.png"), x, y); // La ventana esta media rota en ambos
                    break;
            case 3: act = new SimpleView(imagenes.get("media_rota_arriba.png"), x, y);// La ventana media rota arriba
                    break;
            case 4: act = new SimpleView(imagenes.get("rota_arriba.png"), x, y);// La ventana esta rota arriba nada mas
                    break;
            case 5: act = new SimpleView(imagenes.get("rota_abajo.png"), x, y);// La ventana esta rota abajo nada mas
                    break;
            case 6: act = new SimpleView(imagenes.get("rota_ambos.png"), x, y);// La ventana esta completamente rota
                    break;
        }
        switch (ven.getTipoObstaculo()) {
            case "moldura": // Agregar imagen de moldura
                            break;
            case "maceta": // Agregar imagen de maceta
                           break;
            default: break; // nada
        }
        return act;
    }
    
    public PuertaView generarViewPuerta(Ventana ven, int x, int y){
        return new PuertaView(); // Falta implementar
    }
    
    public SemiCircularView generarViewSemiCircular(Ventana ven, int x, int y){
        return new SemiCircularView(); // Falta implementar
    }

	public Grafica getView(){
		return this.view;
	}

	public void setView(Grafica view){
		this.view = view;
	}

	public Main getModel(){
		return this.model;
	}
	
	/*Creo que de esta forma se deberia manejar con el Controlador. Cualquier cosa si ven
	 * que se puede cambiar lo que sea para hacerlo mejor, mporque no se si les va a parecer 
	 * un lio de clases, pero bueno jaj. Lo que va a relacionar el modelo con la grafica
	 * va a ser el Boton Play, que ahi cree la clase, pero no mas que eso por cuestiones
	 * que se puede relacionar de muchas formas y no se como empezar.
	 */
	public static void main (String[] args){
		Controlador ctrl = new Controlador(new Main(false, 0), 1);
	}

	class ManejaEventosTeclado extends KeyAdapter{
		public void keyPressed(KeyEvent e){
			int movek = e.getKeyCode();
			//Point P = Posicion de Imagen de Felix a usar creo
			switch(movek){
			case KeyEvent.VK_UP:		//Arriba
				model.getDvp().getFelix().mover(Direccion.ARRIBA);
				//P.setLocation(new Point((int) p.getX()),new Point((int) p.getY()+10);
				break;
			case KeyEvent.VK_DOWN:		//Abajo
					model.getDvp().getFelix().mover(Direccion.ABAJO);
					//P.setLocation(new Point((int) p.getX()),new Point((int) p.getY()-10);
					break;
			case KeyEvent.VK_LEFT: //Izquierda
				model.getDvp().getFelix().mover(Direccion.IZQUIERDA);
				//P.setLocation(new Point((int) p.getX()-10),new Point((int) p.getY());
				break;
			case KeyEvent.VK_RIGHT: //Derecha
				model.getDvp().getFelix().mover(Direccion.DERECHA);
				//P.setLocation(new Point((int) p.getX()+10),new Point((int) p.getY());
				break;
			default: 
				break;
			}
		}
	}

	class ManejaPlayAdapter extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			MENU.turnOff();
			view = new Play(model, edificio);
			view.addKeyboardEvents(new ManejaEventosTeclado());
			view.addBackMenu(new VolverAMenu());
		}
	}


	class VolverAMenu extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			view.turnOff();
			MENU.turnOn();
		}
	}
	class ManejaTopScoresAdapter extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			MENU.turnOff();
			view = new TopScores();
			view.addBackMenu(new VolverAMenu());
		}
	}
	class ManejaInstrucciones extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			MENU.turnOff();
			view = new Instrucciones();
			view.addBackMenu(new VolverAMenu());
		}
	}
	class ManejaConfiguracion extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			view = new Configuracion();
			view.addBackMenu(new VolverAMenu());
		}
	}
	
}
