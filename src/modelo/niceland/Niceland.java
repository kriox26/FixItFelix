package modelo.niceland;

public class Niceland {
	private Seccion[] secciones;
	
	public Niceland(int niveles){
		for (int i = 0; i < niveles; i = i + 3) {
            // Parametros: tipo = "Inferior", piso = true, techo = false
		    secciones[i] = new Seccion("Inferior", true, false);
            secciones[i + 1] = new Seccion("Media", false, false);
            secciones[i + 2] = new Seccion("Superior", false, true);
		}
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
