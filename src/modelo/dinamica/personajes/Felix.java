package modelo.dinamica.personajes;
import modelo.dinamica.Posicion;

public class Felix extends Personaje{
	private int vida;
	private boolean inmunidad;
	
    public Felix(String nombre, int vida, boolean inmunidad, Posicion posicion){
    	super(nombre, posicion);
        this.vida = vida;
        this.inmunidad = inmunidad;
    }
    
	public int getVida(){
		return this.vida;
	}
	
	public void setVida (int variable){
		this.vida = variable;
	}
	
	public boolean getInmunidad() {
		return this.inmunidad;
	}
	
	public void setInmunidad (boolean variable){
		this.inmunidad = variable;
	}
	
	public boolean estaInmune () {
        return this.getInmunidad() ? true : false;
	}
	
	public void activarInmunidad () {
		this.inmunidad = true;
	}
	
	public void desactivarInmunidad () {
		this.inmunidad = false;
	}
	
	public void golpeadoPorLadrillo () {
		if (this.estaInmune()) {
			this.desactivarInmunidad();
		}
		this.setVida (this.getVida()-1);
		this.recomenzar();
	}
	
	public void golpeadoPorPaloma (){
		this.recomenzar();
	}
	
	public void recomenzar () {
		// Vuelve a empezar de la misma pantalla... WTF?
	}
	
	public void comerTarta () {  // Debe ejecutarse si en Felix.posicion hay un sabroso pastel
		this.activarInmunidad();
		// Hacer desaparecer la tarta de donde est�
	}
}
