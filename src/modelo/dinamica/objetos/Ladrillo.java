package modelo.dinamica.objetos;

import modelo.direcciones.Direccion;
import modelo.dinamica.Posicion;

/**
 * La clase Ladrillo, más allá de la diferenciación gráfica, solo
 * se distinge de las demás de tipo Objeto porque su único
 * movimiento posible es en sentido vertical hacia abajo.
 *
 * @author  Santiago Marrone
 * @see modelo.dinamica.direcciones
 */
public class Ladrillo extends Objeto {
    private int velocidad = 1;
    private int movimiento = 30;
    private boolean golpeo = false;

    public boolean getGolpeo(){
        return this.golpeo;
    }
    
    public void setGolpeo(boolean golpeo){
        this.golpeo = golpeo;
    }
	public Ladrillo(){
		Posicion posicion = new Posicion();
		this.golpeo = false;
		super.setPosicion(posicion);
	}

	public Ladrillo(Posicion posicion){
		posicion.setSeccion(0);
		posicion.setFila(2);
		this.golpeo = false;
		super.setPosicion(posicion);
	}

	public Ladrillo(int s, int f, int c){
		Posicion p = new Posicion(2,c,s - 1);
		super.setPosicion(p);
	}
    
	/**
	 * El método caerDesde identifica la caída de un ladrillo: movimiento
	 * desde una posición dada en sentido vertical, siempre hacia abajo
	 *
	 * @param     position	desde dónde es lanzado el ladrillo (provisto por Ralph)
	 */
	public void caerDesde (Posicion position) {
		this.unidireccionar(Direccion.ABAJO); // Unidireccionarlo hacia abajo (en niveles Pro podr�a alterarse la gravedad)
	}
    
    public void mover(Direccion direccion){
        if (this.getPosicion().getSeccion() == 0) {
            if (this.getPosicion().getFila() > 0) {
                super.mover(direccion);
            }
        }
    }
    
    private void caer(){
        if (this.movimiento > 0) {
            movimiento -= velocidad;
            if (movimiento / 10 > 0) {
                this.getPosicion().setFila(movimiento / 10);
            }
        }else if(movimiento == -10){
            this.getPosicion().setFila(0);
            this.movimiento = -20;
        }else{
        	this.movimiento -= velocidad;
        }
    }

    public int getMovimiento(){
    	return this.movimiento;
    }
    
    /*
     * Metodo utilizado para actualizar la posicion del ladrillo. Lo tiene heredado
     * de la clase Objeto.
     */
    public void actualizar(){
        caer();
    }
}
