package modelo.niceland;

public class Niceland {
	private Seccion[] secciones;
	
	public Niceland(int niveles){
        secciones[i] = new Seccion("Inferior", true, false);
		for (int i = 1; i < niveles - 1; i++) {
            secciones[i + 1] = new Seccion("Media", false, false);
		}
        secciones[i + 1] = new Seccion("Superior", false, true);
	}
	
	private void resetear() { // Resetear edificio ? 
		
	}

	private void iniciar() { //Inicia el juego ? 
		
	}
	
	private boolean getIniciado() {
		
		return false;
	}
	
	private void setIniciado (){
		
	}
	public void activar() { //
		
	}
	
}
