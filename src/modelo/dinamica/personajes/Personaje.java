package modelo.dinamica.personajes;

import modelo.dinamica.*;

public class Personaje {
	
	private String nombre;
	private Posicion Posicion;
	
	public String getNombre (){
		return this.nombre;
	}
	
	public Posicion getPosicion (){
		return this.Posicion;
	}
	
	public void setNombre (String name){
		this.nombre = name;
	}
	
	public void setPosicion (Posicion position){
		this.Posicion = position;
	}
	
	
}