package modelo.niceland;

public class Niceland {
	private Seccion[] secciones;
	
	public Niceland(int niveles){
        // TODO: Refactorizar el metodo!
        secciones[0] = new Seccion("Inferior", true, false);
        int totalMedios = (3 * niveles) - 2;
        if (totalMedios == 1) {
            secciones[1] = new Seccion("Medio", false, false);
        }else{
            for (int i = 1; i < totalMedios ; i++) {
                secciones[i] = new Seccion("Medio", false, false);
            }
        }
        secciones[(niveles * 3) - 1] = new Seccion("Superior", false, true);
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
