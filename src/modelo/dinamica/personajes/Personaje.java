package modelo.dinamica.personajes;

import modelo.dinamica.*;
import modelo.direcciones.Direccion;

public class Personaje extends Dinamico {
	
	private String nombre;
	
	public Personaje(String nombre, Posicion posicion){
		this.setNombre(nombre);
        super.setPosicion(posicion);
	}

	public String getNombre (){
		return this.nombre;
	}
	
	
	public void setNombre (String name){
		this.nombre = name;
	}
	
	public boolean alBordeIzquierdo () {
		if (this.getPosicion().getColumna() == 0) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean alBordeDerecho () {
		if (this.getPosicion().getColumna() == 4) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean alBordeInferior () {
		if (this.getPosicion().getFila() == 0) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean alBordeSuperior () {
		if (this.getPosicion().getFila() == 3) {
			return true;
		}
		else 
			return false;
	}
	
	public boolean alBorde () {
		if (this.alBordeDerecho() || this.alBordeIzquierdo() || this.alBordeInferior() || this. alBordeSuperior()) {
			return true;
		}
		else 
			return false;
	}
	
	private boolean puedeMoverse (Direccion direction) {
		boolean ok = true;
		switch (direction) {
			case ARRIBA : 
				if (this.alBordeSuperior()) {
					ok=false;
				}
				break;
			case ABAJO : 
				if (this.alBordeInferior()) {
					ok=false;
				}
				break;
			case IZQUIERDA : 
				if (this.alBordeIzquierdo()) {
					ok=false;
				}
				break;
			case DERECHA : 
				if (this.alBordeDerecho()) {
					ok=false;
				}
				break;
			case NULA :
				ok=true;
		}
		return ok;
	}
	
	@Override
	public void mover (Direccion direction){
		if (this.puedeMoverse(direction)) {
			this.setPosicion(this.getPosicion().modificar(direction));
		}
	}
}