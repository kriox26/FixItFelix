package modelo.dinamica.objetos;

import modelo.direcciones.Direccion;
import modelo.dinamica.Posicion;

public class Ladrillo extends Objeto {
	
	private static final double kv = 9.58; // Constante de variación de velocidad
    
    public Ladrillo(){
        Posicion posicion = new Posicion();
        super.setPosicion(posicion);
    }
    
    public Ladrillo(Posicion posicion){
        posicion.setSeccion(posicion.getSeccion() - 1);
        posicion.setFila(2);
        super.setPosicion(posicion);
    }
	
	public void caerDesde (Posicion position) {
		this.aparecer(position); // Crearlo
		this.unidireccionar(Direccion.ABAJO); // Unidireccionarlo hacia abajo (en niveles Pro podr�a alterarse la gravedad)
	}
    
    public void mover(Direccion direccion){
        if (this.getPosicion().getSeccion() == 0) {
            if (this.getPosicion().getFila() > 0) {
                super.mover(direccion);
            }
        }
    }
    
    public void caer(){
        super.mover(Direccion.ABAJO);
        System.out.println("El ladrillo cae, su posicion es: (Seccion: " + this.getPosicion().getSeccion() + ", Fila: " + this.getPosicion().getFila() + ", Columna: " + this.getPosicion().getColumna() + ")");
    }
}
