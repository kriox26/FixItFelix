package modelo.dinamica;

import modelo.direcciones.*;

/*
 * Representa la posicion de los Objetos y Personajes, relativa al edificio Niceland.
 * La posicion tiene una fila, columna y seccion que corresponden a las partes
 * del edificio en la que estoy ubicado.
 */
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

    /*
     * Encargado de modificar la posicion actual acorde a la direccion enviada.
     * @params Direccion direccion: Direccion a utilizar para actualizar posicion
     * @return Posicion: devuelve la instancia actual modificada, NO CAMBIAR ESTO.
     */
	public Posicion modificar (Direccion direccion) {
        int actualizarColumna = this.getColumna() + direccion.getHorizontal();
        int actualizarFila = this.getFila() + direccion.getVertical();
        if (actualizarColumna < 5 && actualizarColumna >= 0 && actualizarFila < 3 && actualizarFila >= 0) {
            this.setColumna(actualizarColumna);
            this.setFila(actualizarFila);
        }
		 return this;
	}
    
    public Posicion posicionHacia(Direccion direccion){
        int actualizarColumna = this.getColumna() + direccion.getHorizontal();
        int actualizarFila = this.getFila() + direccion.getVertical();
        if (actualizarColumna < 5 && actualizarColumna >= 0 && actualizarFila < 3 && actualizarFila >= 0) {
            return new Posicion(actualizarFila, actualizarColumna, 0);
        }else{
            return null;
        }
    }

    /*
     * Utilizado para comparar la posicion actual con la enviada.
     * @params Posicion posicion: Posicion con la que se la quiere comparar
     * @return boolean: Devuelve true si son iguales, false caso contrario
     */
    public boolean equal_to(Posicion posicion){
        return (this.getFila() == posicion.getFila() && this.getColumna() == posicion.getColumna() && this.getSeccion() == posicion.getSeccion());
    }

    public String to_string(){
    	return ("Seccion: " + this.getSeccion() + ", Fila: " + this.getFila() + ", Columna: " + this.getColumna());
    }
}
