package modelo.dinamica;

import modelo.direcciones.*;

public class Posicion {
	private int fila;
	private int columna;
    private int seccion;
	
    public Posicion(int fila, int columna, int seccion){
        this.fila = fila;
        this.columna = columna;
        this.seccion = seccion;
    }
    
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
    
    public void setSeccion(int seccion){
        this.seccion = seccion;
    }
    
    public int getSeccion(){
        return this.seccion;
    }
	
	public Posicion modificar (Direccion direction) {
		this.setColumna(this.getColumna() + direction.getVertical());
		this.setFila(this.getFila() + direction.getHorizontal());
		return this;
	}
}
