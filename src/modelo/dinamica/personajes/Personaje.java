package modelo.dinamica.personajes;

import modelo.dinamica.*;

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
	
}