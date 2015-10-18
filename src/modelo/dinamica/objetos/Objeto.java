package modelo.dinamica.objetos;

import modelo.direcciones.*;
import modelo.dinamica.Dinamico;
import modelo.dinamica.Posicion;

public class Objeto extends Dinamico {
	private boolean existe;
	
	public boolean getExiste(){
		return this.existe;
	}
	
	public void setExiste (boolean variable) {
		this.existe = variable;
	}
	
	private void unidireccionar (Direccion direccion) {
		while (this.getExiste() == true) {
			this.mover (direccion);
		}
	}
	
	public void desaparecer () {
		this.setExiste(false);
	}
	
	public void aparecer (Posicion position) {
		this.setExiste (true);
		this.setPosicion(position);
	}

}
