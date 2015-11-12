package modelo.niceland;

/**
 * Representa el estado sano de un panel, el cual no se debe arreglar.
 *
 * @author  Matias Pan
 * @see modelo.niceland.Panel
 * @see modelo.niceland.Estado
 */
public class Sano extends Estado {

    /*
     * Devuelve el estado Sano, ya que no se debe arreglar.(ya esta sana)
     * @Override
     * @return Sano: Instancia de sano, ya esta arreglado
     */
	protected Sano arreglar(){
		return new Sano();
	}
    public String to_string(){
        return "sano";
    }
}
