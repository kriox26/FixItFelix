package modelo.dinamica.objetos;

public class Ladrillo extends Objeto {
	private static final double k = 9.58; // Constante de variaciÃ³n de velocidad
	private double velocidad;
	
	public double getVelocidad () {
		return this.velocidad;
	}

	public void setVelocidad (double variable) {
		this.velocidad = variable;
	}

	public void actualizarVelocidad (int nivel) {
		this.setVelocidad(nivel * k);
	}

	/* public void caerDesde (Posicion position) {
		this.aparecer(position); // Crearlo
		this.unidireccionar(ABAJO); // Unidireccionarlo hacia abajo (en niveles Pro podría alterarse la gravedad)
	}
*/
}
