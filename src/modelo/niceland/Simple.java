package modelo.niceland;
import modelo.direcciones.*;
import modelo.obstaculos.*;
import modelo.util.RandomAcotado;

/**
 * Representa un tipo de ventana denominada Simple. Las carecteristicas
 * de esta ventana son:
 *              - 2 paneles que se pueden romper y reparar
 *              - Posibilidad de tener una tarta
 *              - Tener un obstaculo a la vez, pueden ser: Maceta, Moldura.
 *
 * @author  Matias Pan
 * @see modelo.niceland.Ventana
 * @see modelo.niceland.obstaculos
 * @see modelo.niceland.Panel
 */
public class Simple extends Ventana {
	private boolean tarta = false;
    private Obstaculo obstaculo;
    private String tipoObstaculo;

    /*
     * Constructor de la ventana simple
     * @param tarta : Tarta puesta por un nicelander
     */
    public Simple(boolean tarta){
        this.tarta = tarta;
        this.setearObstaculo();
        this.paneles = new Panel[2];
        this.setearPaneles(2);
    }

	private boolean getTarta(){
		return this.tarta;
	}

	private void setTarta(boolean tarta){
		this.tarta = tarta;
	}

    /*
     * @Override
     */
    protected boolean pasarHabilitado(Direccion direccion){
        return this.obstaculo.puedoPasar(direccion);
    }

    /*
     * Las ventanas simples tiene 2 paneles, entonces tenemos
     * que seguir arreglando hasta llegar a 2*2 = 4 martillazos
     */
    public void arreglarPanel(){
        if (this.getMartillazosRecibidos() < 4) {
        	super.arreglarPanel();
        }
    }

    /*
     * Devuelve true solo si el panel de abajo esta Roto y si
     * no hay una tarta actualmente
     * @return boolean True si el nicelander puede poner una tarta
     */
	public boolean sePuedePonerTarta(){
		return paneles[0].estaRoto() && !tarta;
	}

    /*
     * Vetanas simples puede tener un solo obstaculo a la vez, este metodo setea
     * a que sea Maceta, Moldura u Obstaculo. Si es Obstaculo entonces pasarHabilitado()
     * va a devolver siempre true sin importar la direccion.
     */
    private void setearObstaculo(){
        RandomAcotado random = new RandomAcotado(0,3);
        switch (random.getValor()) {
            case 0: this.obstaculo = new Maceta();
            		this.tipoObstaculo = "maceta";
                    break;
            case 1: this.obstaculo = new Moldura();
            		this.tipoObstaculo = "moldura";
                    break;
            default:this.obstaculo = new Obstaculo();
            		this.tipoObstaculo = "vacio";
                    break;
        }
    }

	public void ponerTarta () {
		if (this.getTarta()==false){ // Evita superposici�n de tartas
			this.setTarta(true);
		}
	}
    
    public String getTipoObstaculo(){
    	return this.tipoObstaculo;
    }
    
    /*
     * Devuelve un int indicando el estado total de la ventana. Los casos son:
     *          int = 0     -> La ventana esta completamente sana
     *          int = 1     -> La ventana esta media rota abajo
     *          int = 2     -> La ventana esta media rota en ambos paneles
     *          int = 3     -> La ventana media rota arriba
     *          int = 4     -> La ventana esta rota arriba nada mas
     *          int = 5     -> La ventana esta rota abajo nada mas
     *          int = 6     -> La ventana esta completamente rota
     */
    public int estadoTotal(){
        if(this.estaSana())
            return 0;
        if(this.getPaneles()[0].estaMedioRoto() && this.getPaneles()[1].estaSano())
            return 1;
        if(this.getPaneles()[0].estaMedioRoto() && this.getPaneles()[1].estaMedioRoto())
            return 2;
        if(this.getPaneles()[0].estaSano() && this.getPaneles()[1].estaMedioRoto())
            return 3;
        if(this.getPaneles()[0].estaSano() && this.getPaneles()[1].estaRoto())
            return 4;
        if(this.getPaneles()[0].estaRoto() && this.getPaneles()[1].estaSano())
            return 5;
        if(this.estaSana())
            return 6;
        return 7;
    }
}
