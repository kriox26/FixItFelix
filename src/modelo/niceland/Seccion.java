package modelo.niceland;

import modelo.util.RandomAcotado;

/**
 * Representa las secciones del edificio, pueden ser de 3 tipos, las cuales tienen
 * distintas caracteristicas. Son:
 *                      - Inferior: La seccion inicial en la que Felix empieza a jugar,
                                    esta seccion contiene una puerta y una ventana semicircular.
 *                      - Media: Seccion en la que todas las ventanas pueden ser simples
                                 o irrompibles.
 *                      - Superior: Ultima seccion del edificio, si felix pasa esta
                                    seccion, gana el nivel.
 *
 * @author Matias Pan
 * @author Jorge Stranieri
 * @see modelo.niceland.Niceland
 */
public class Seccion {
	private String tipo;
	private boolean techo;
	private boolean piso;
	private Ventana[][] ventanas = new Ventana[3][5];
	
    /*
     * Inicializamos una seccion del tipo "tipo", y especificamos si es techo o piso
     * o nada
     * @param String tipo : Define el tipo de la seccion, "Inferior", "Media", "Superior"
     * @param boolean piso : Atributo especifico a cada seccion, true para "Inferior", false caso contrario
     * @param boolean techo : Atributo especifico a cada seccion, true para "Superior", false caso contrario
     */
    public Seccion(String tipo, boolean piso, boolean techo){
        this.tipo = tipo;
        this.piso = piso;
        this.techo = techo;
        this.iniciar(tipo);
    }
    
    /*
     * Crea las 3 filas de ventanas. En caso de ser la seccion inferior
     * agrega la puerta y la ventana semicircular en las posiciones correspondientes
     * @param String tipo : Para crear ventanas especiales a cada tipo de seccion
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
     * @return boolean : true si estan todas arregladas, false caso contrario
     */
	public boolean todoArreglado(){
        for (int j = 0; j < 3; j++){ 
        	for (int i = 0; i < 5; i++) {
        		if(!ventanas[j][i].estaSana()){
        			System.out.println("La ventana " + i + " " + j + " no esta sana");
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
    
    public Ventana[][] getVentanas(){
        return this.ventanas;
    }
    
    /*
     * Setea los tipos de las ventanas de  cada fila, hay mas posibilidades que sea
     * simple que irrompible, solo para hacer el juego un poco mas interesante.
     * si es impar es irrompible
     */
    private void setearVentanas(){
        for (int j = 0; j <3; j++){
        	for (int i = 0; i < 5; i++) {
                RandomAcotado rnd = new RandomAcotado(0,3);
                switch (rnd.getValor()) {
                    case 3: this.ventanas[j][i] = new Irrompible();
                    		break;
                    default: this.ventanas[j][i] = new Simple(false);
                    		 break;
                }
        	}
        }
    }
    
    /*
     * Para cuando inicializamos la seccion inferior, hay que agregar una Puerta
     * en la posicion dos de la planta baja, y una ventana Semicircular en la posicion
     * 2 del primer piso.
     */
    private void ventanasPiso(){
        this.ventanas[0][2] = new Puerta();
        this.ventanas[1][2] = new Semicircular();
    }
}
