package modelo.niceland;
import modelo.direcciones.*;
import modelo.obstaculos.*;
import modelo.util.RandomAcotado;

public class Simple extends Ventana {
	private boolean tarta = false;
    private Obstaculo obstaculo;
    
    /*
     * Constructor de la ventana simple
     * @param tarta : Tarta puesta por un nicelander
     * @param obstaculo : Puede ser maceta, moldura o nada
     */
    public Simple(boolean tarta){
        this.tarta = tarta;
        this.setearObstaculo();
        this.paneles = new Panel[2];
        this.setearPaneles(2);
    }

	public boolean getTarta(){
		return this.tarta;
	}

	public void setTarta(boolean tarta){
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
        }else{
            System.out.println("Esta ventana ya se arreglo");
        }
    }

    /*
     * Devuelve true solo si el panel de abajo esta Roto y si
     * no hay una tarta actualmente
     * @return boolean True si el nicelander puede poner una tarta
     */
	protected boolean sePuedePonerTarta(){
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
                    break;
            case 1: this.obstaculo = new Moldura();
                    break;
            default:this.obstaculo = new Obstaculo();
                    break;
        }
    }
}
