package modelo.niceland;

public class Seccion {
	private String nombre;
	private boolean techo;
	private boolean piso;
	private Ventana[] ventanas = new Ventana[5];
	
	public void iniciar(int num){ //Debe recibir un entero...
	}
	
	public boolean todoArreglado(){ //Para saber si se puede pasar de sección.
		return false;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isTecho() {
		return techo;
	}
	public void setTecho(boolean techo) {
		this.techo = techo;
	}
	public boolean isPiso() {
		return piso;
	}
	public void setPiso(boolean piso) {
		this.piso = piso;
	}
	
	
}
