package modelo.niceland;

public class Ventana {
    protected Panel[] paneles;
    private int martillazos_recibidos;
    
    public int getMartillazosRecibidos(){
        return this.martillazos_recibidos;
    }
    
    public void setMartillazosRecibidos(int martillazos_recibidos){
        this.martillazos_recibidos = martillazos_recibidos;
    }
    
    /*
     * Los paneles se arreglan solo cada dos golpes, por ende
     * si estoy en el golpe numero 2 tengo que arreglar el primer
     * el cual esta en la posicion 0, entonces: 2/1 - 1 = 0.
     * Caso golpes = 4: 4/2 - 1 = 1.
     * La cantidad de golpes depende de la cantidad de paneles, por ende
     * cada subclase de Ventana hace un Override donde solo arregla si
     * no supero la cantidad maxima de golpes, y luego llama a este metodo.
     */
    protected void arreglarPanel(){
        if ((this.getMartillazosRecibidos() % 2 == 0) && (this.getMartillazosRecibidos() != 0)) {
            paneles[(this.getMartillazosRecibidos()/2) - 1].arreglar();
        }
        this.setMartillazosRecibidos(this.getMartillazosRecibidos()+ 1);
    }
    
	/*
	 * Esto va a devolver true si la ventana a la
	 * que se esta llamando es simple o semicircular.
	 * En caso de que sea irrompible, se va a acceder
	 * al metodo de la clase correspondiente
	 * @return boolean
	 */
	protected boolean pasarHabilitado(){
		return true;
	}
}
