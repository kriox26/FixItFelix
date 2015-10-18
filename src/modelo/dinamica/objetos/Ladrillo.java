package modelo.dinamica.objetos;

import modelo.direcciones.Direccion;
import modelo.dinamica.Posicion;

public class Ladrillo extends Objeto {
	
	private static final double kv = 9.58; // Constante de variación de velocidad
	
	public void caerDesde (Posicion position) {
		this.aparecer(position); // Crearlo
		this.unidireccionar(Direccion.ABAJO); // Unidireccionarlo hacia abajo (en niveles Pro podr�a alterarse la gravedad)
	}
}
