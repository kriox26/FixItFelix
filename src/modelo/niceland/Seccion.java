package modelo.niceland;

public class Seccion {
	private String tipo;
	private boolean techo;
	private boolean piso;
	private Ventana[] ventanas = new Ventana[5];
	
    public Seccion(String tipo, boolean piso, boolean techo){
        this.tipo = tipo;
        this.piso = piso;
        this.techo = techo;
        // llamamos a iniciar para setear el tipo de cada ventana
    }
    
	private void iniciar(int num){ //Debe recibir un entero... PORQUE?????
        for (int i = 0; i < 5; i++) {
            /* Esto no tiene que ser siempre una ventana, tiene que variar entre
             * Irrompible y Simple. Y en el caso de ser el primero de todo, tiene
             * que tener una puerta, si es el segundo una semicircular.
             */
            ventanas[i] = new Ventana();
        }
	}
	
	public boolean todoArreglado(){ //Para saber si se puede pasar de secci�n.
		return false;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
