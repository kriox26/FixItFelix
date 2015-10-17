package modelo.dinamica.personajes;

import modelo.dinamica.*;
import modelo.direcciones.*;

public class Personaje {
	
	private String nombre;
	private Posicion posicion;
	
	public String getNombre (){
		return this.nombre;
	}
	
	public Posicion getPosicion (){
		return this.posicion;
	}
	
	public void setNombre (String name){
		this.nombre = name;
	}
	
	public void setPosicion (Posicion position){
		this.posicion = position;
	}
	
	public void mover (Direccion direction){
		this.setPosicion(this.getPosicion().modificar(direction));
	}
	
	
}