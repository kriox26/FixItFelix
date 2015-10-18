package modelo.dinamica.objetos;

import modelo.direcciones.Direccion;
import modelo.dinamica.Posicion;

/**
 * La clase Ladrillo, más allá de la diferenciación gráfica, solo
 * se distinge de las demás de tipo Objeto porque su único
 * movimiento posible es en sentido vertical hacia abajo.
 *
 * @author  Santiago Marrone
 * @version 1.0
 * @see modelo.dinamica.Posicion
 *
 */


public class Ladrillo extends Objeto {

	private static final double kv = 9.58; // Constante de variación de velocidad

	/**
	 * El método caerDesde identifica la caída de un ladrillo: movimiento
	 * desde una posición dada en sentido vertical, siempre hacia abajo
	 *
	 * @param     position	desde dónde es lanzado el ladrillo (provisto por Ralph)
	 */

	public void caerDesde (Posicion position) {
		this.aparecer(position); // Crearlo
		this.unidireccionar(Direccion.ABAJO); // Unidireccionarlo hacia abajo (en niveles Pro podr�a alterarse la gravedad)
	}
}
