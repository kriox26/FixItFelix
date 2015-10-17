package modelo.dinamica;

import modelo.direcciones.*;

public class Posicion {
	private int fila;
	private int columna;
	
	public int getFila (){
		return this.fila;
	}
	
	public int getColumna (){
		return this.columna;
	}
	
	public void setFila (int row){
		this.fila = row;
	}
	
	public void setColumna (int column){
		this.columna = column;
	}
	
	public Posicion modificar (Direccion direction) {
		this.setColumna(this.getColumna() + direction.getVertical());
		this.setFila(this.getFila() + direction.getHorizontal());
		return this;
	}
}
