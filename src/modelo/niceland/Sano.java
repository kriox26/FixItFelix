package modelo.niceland;

public class Sano extends Estado {


	protected Sano arreglar(){
		return new Sano();
	}
    public String to_string(){
        return "sano";
    }
}
