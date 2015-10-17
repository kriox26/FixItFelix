package modelo.dinamica.personajes;
import modelo.dinamica.Posicion;

public class Ralph extends Personaje {
	private int ladrillos;
	private static int cuantosTira = 1;
    
    public Ralph(String nombre, int ladrillos, Posicion posicion){
    	super(nombre, posicion);
        this.ladrillos = ladrillos;
    }
	
	public int getLadrillos () {
		return this.ladrillos;
	}
	
	public void setLadrillos (int cantidad) {
		this.ladrillos = cantidad;
	}
	
	public boolean hayLadrillos () {
		if (this.getLadrillos() >= cuantosTira) {
			return true;
		}
		else
			return false;
	}
}