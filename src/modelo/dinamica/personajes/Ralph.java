package modelo.dinamica.personajes;

public class Ralph extends Personaje {
	private int ladrillos;
	private static int cuantosTira = 1;
	
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