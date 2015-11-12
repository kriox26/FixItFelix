package modelo.dinamica;

import modelo.direcciones.*;

public class Posicion {
	private int fila;
	private int columna;
    private int seccion;
	
    public Posicion(){
        
    }
    
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
	
	public Posicion modificar (Direccion direccion) {
        int actualizarColumna = this.getColumna() + direccion.getHorizontal();
        int actualizarFila = this.getFila() + direccion.getVertical();
        if (actualizarColumna < 5 && actualizarColumna >= 0 && actualizarFila < 3 && actualizarFila >= 0) {
            this.setColumna(actualizarColumna);
            this.setFila(actualizarFila);
        }
        /* Devuelve this por la manera en la que se utiliza el metodo en la clase
         * Dinamico, se llama a this.setPositicion(modificar), entonces se necesita
         * devolver this. */
		 return this;
	}
    
    public boolean equal_to(Posicion posicion){
        return (this.getFila() == posicion.getFila() && this.getColumna() == posicion.getColumna() && this.getSeccion() == posicion.getSeccion());
    }

    public String to_string(){
    	return ("Seccion: " + this.getSeccion() + ", Fila: " + this.getFila() + ", Columna: " + this.getColumna());
    }
}
