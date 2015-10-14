package modelo.niceland;
import modelo.direcciones.*;

public class Simple extends Ventana {
	private boolean tarta = false;
    private boolean maceta;
    private boolean moldura;

    public Simple(boolean tarta, boolean maceta, boolean moldura){
        this.tarta = tarta;
        this.maceta = maceta;
        this.moldura = moldura;
        this.paneles = new Panel[2];
        this.setearPaneles(2);
    }

    public boolean getMaceta(){
        return this.maceta;
    }
    
    public void setMaceta(boolean maceta){
        this.maceta = maceta;
    }
    
    public boolean getMoldura(){
        return this.moldura;
    }
    
    public void setMoldura(boolean moldura){
        this.moldura = moldura;
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
        if (direccion instanceof Arriba) {
            if (this.getMoldura()) {
                return false;
            }else{
                return true;
            }
        }else{
            if(direccion instanceof Abajo){
                if (this.getMaceta()) {
                    return false;
                }else{
                    return true;
                }
            }else{
            	return true;
            }
        }
    }
    
    /*
     * Las ventanas simples tiene 2 paneles, entonces tenemos
     * que seguir arreglando hasta llegar a 2*2 = 4 martillazos
     */
    protected void arreglarPanel(){
        if (this.getMartillazosRecibidos() <= 4) {
        	super.arreglarPanel();
        }
    }

    /*
     * Devuelve true solo si el panel de abajo esta Roto y si
     * no hay una tarta actualmente
     * @return boolean
     */
	protected boolean sePuedePonerTarta(){
		return paneles[0].estaRoto() && !tarta;
	}
    
    /*
     * Genera los paneles de la ventana simple, su estado es aleatorio
     */
}
