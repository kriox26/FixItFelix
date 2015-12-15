package grafica.menu;

import grafica.dinamica.objetos.LadrilloView;
import grafica.dinamica.personajes.FelixView;
import grafica.dinamica.personajes.RalphView;
import grafica.niceland.VentanaView;
// import grafica.dinamica.objetos.PalomaView;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

public class PanelJuego extends JPanel{
	private static final long serialVersionUID = 1L;
	private static final int horEdificio= 250;
    private static final int verEdificio= 120;
    private BufferedImage seccionActual;
    private Map<String, BufferedImage> imagenes;
    private VentanaView[][] building;
    private List<LadrilloView> ladrillos;
    private FelixView fView;
    private RalphView rView;
    private int desde;
    private int hasta;

	public PanelJuego(VentanaView[][] building, Map<String, BufferedImage> imagenes, FelixView fView, RalphView rView, int desde, int hasta){
		this.building = building;
		this.fView = fView;
		this.rView = rView;
		this.desde = desde;
		this.hasta = hasta;
		this.setVisible(true);
		this.setSize(800, 600);
		this.seccionActual = imagenes.get("piso1.png");
    	this.imagenes = imagenes;
    	//this.dibujar(getGraphics());
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		dibujar(g);

	}

	public void actualizar(VentanaView[][] building, FelixView fView, RalphView rView, int desde, int hasta, BufferedImage seccionActual, List<LadrilloView> ladrillos){
		this.building = building;
		this.fView = fView;
		this.rView = rView;
		this.desde = desde;
		this.hasta = hasta;
		this.seccionActual = seccionActual;
        this.ladrillos = ladrillos;
	}

	public void graficarLadrillos(Graphics g){
        for(LadrilloView ladrillo : this.ladrillos){
        	if(!ladrillo.getOculto()){
        		System.out.println("Ladrillo esta en: " + (verEdificio + (230 - 4 * ladrillo.getOffsetY() - 20)));
            	g.drawImage(ladrillo.getImagenActual(), (-10) + horEdificio + (54 * (ladrillo.getOffsetX() + 1)), verEdificio + (230 - 4*ladrillo.getOffsetY()), null);
        	}
        }
	}

	  public void cargarNiceland(Graphics g){
	        g.drawImage(this.seccionActual, horEdificio, verEdificio, null);
	        int alturaActual = 0;
	        int actualX = 0;
	        for (int i = this.desde; i < this.hasta; i++) {
	            for (int j = 0; j < 5; j++) {
	            	VentanaView act = this.building[i][j];
	            	int venX = 10 + horEdificio + actualX + act.getXinicial();
	            	int venY = verEdificio + (230 - (alturaActual + act.getYinicial()));
                g.drawImage(act.getImagenActual(), venX, venY, null);
                if(act.tieneObstaculo()){
                	g.drawImage(act.getObstaculoView().getImagenActual(), venX + act.getObstaculoView().getOffsetX(), venY + act.getObstaculoView().getOffsetY(), null);
                }
								// Si se debe dibujar una tarta  {
									// Entonces se dibuja
									// Se actualiza la informacioón correspondiente
								// }
								//}
	            	if(this.fView.getOffsetX() == j && this.fView.getOffsetY() == i){
	            		g.drawImage(this.fView.getImagenActual(), venX + act.getAjusteX(), venY + act.getAjusteY(), null);
	            	}
                actualX += 54;
	            }
	            if (i == 2 || i == 5 || i == 8) {
	            	alturaActual += 90;
	            }else{
	                alturaActual += 70;
	            }
	            actualX = 0;
	        }
	        g.drawImage(imagenes.get("u_standing_fury_2.png"), horEdificio + (54 * this.rView.getOffsetX() + 1), verEdificio + (230 - alturaActual - 20), null);
	  }



	  public void addKeyboardEvents(KeyAdapter keyadapter){
	        this.addKeyListener(keyadapter);
	    }
	  public void setSeccionActual(BufferedImage img){
	    	this.seccionActual = img;
	    }
	  public void dibujar(Graphics g){
		  this.cargarNiceland(g);
		  this.graficarLadrillos(g);
		  // this.graficarPalomas(g);
	  }

		/*

		// Método que retorna si se debe dibujar o no una tarta
		private boolean dibujarTarta (VentanaView act) {
			if (act instanceof SimpleView) { 													// Si es una ventana simple
				if ((act.getTarta()) || (this.quiereTarta(act))) {			// Si tiene tarta O quiere tenerla a partir de ahora
					return true;
				}
			return false;
		}

		// Método que retorna si una ventana tendrá tarta a partir de ahora
		private boolean quiereTarta(act) {
			NumeroRandom num = new NumeroRandom(1,3);
			if ((!act.getTarta()) && (num % 3 == 0)) {					// Si no tenía tarta Y cumple condición estadística
			// Se agregaría también en la línea anterior la condición "Y hay un nicelander para ponerla"
				return true;
			}
			else {
				return false;
			}
		}

		public void graficarPalomas(Graphics g){
	        Para cada objeto de tipo PalomaView en arreglo de palomas {
							Si no está oculto {}
									Se redibuja;
	        		}
	        }
		}
		*/
}
