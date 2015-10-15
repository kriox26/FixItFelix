package modelo.niceland;

public class Seccion {
	private String tipo;
	private boolean techo;
	private boolean piso;
	private Ventana[][] ventanas = new Ventana[3][5];
	
    public Seccion(String tipo, boolean piso, boolean techo){
        this.tipo = tipo;
        this.piso = piso;
        this.techo = techo;
        this.iniciar(tipo);
    }
    
    /*
     * Crea las 3 filas de ventanas. En caso de ser la seccion inferior
     * agrega la puerta y la ventana semicircular en las posiciones correspondientes
     */
	private void iniciar(String tipo){
        setearVentanas();
        switch (tipo) {
            case "Inferior": this.ventanasPiso();
                             break;
        }
	}
	
    /*
     * Chequea que todas las ventanas estan completamente sanas
     * @return boolean
     */
	public boolean todoArreglado(){
        for (int j = 0; j < 3; j++){ 
        	for (int i = 0; i < 5; i++) {
        		if(!ventanas[j][i].estaSana()){
        			return false;
        		}
        	}
        }
        return true;
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
    
    /*
     * Setea los tipos de las ventanas de  cada fila, random si es par es Simple
     * si es impar es irrompible
     */
    private void setearVentanas(){
        for (int j = 0; j <3; j++){
        	for (int i = 0; i < 5; i++) {
        		int random = (int )(Math.random() * 50 + 1);
        		if (random % 2 == 0) {
        			// TODO: random para maceta y moldura
        			this.ventanas[j][i] = new Simple(false, false, false);
        		}else{
        			// TODO: Random para abierta o cerrada
        			this.ventanas[j][i] = new Irrompible(false);
        		}
        	}
        }
    }
    
    private void ventanasPiso(){
        this.ventanas[0][2] = new Puerta();
        this.ventanas[1][2] = new Semicircular();
    }
}
