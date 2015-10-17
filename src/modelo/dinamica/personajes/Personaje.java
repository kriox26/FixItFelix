package modelo.dinamica.personajes;

import modelo.dinamica.*;

public class Personaje {
	
	private String nombre;
	private Posicion posicion;
	
	public Personaje(String nombre, Posicion posicion){
		this.nombre = nombre;
        this.posicion = posicion;
	}

	public String getNombre (){
		return this.nombre;
	}
	
	public Posicion getPosicion (){
		return this.posicion;
	}
	
	public void setNombre (String name){
		this.nombre = name;
	}
	
	public void setPosicion (Posicion posicion){
		this.posicion = posicion;
	}
	
	
}