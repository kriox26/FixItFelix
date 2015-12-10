package excepciones;

public class LadrilloInexistenteException extends Exception {

	public LadrilloInexistenteException(){
		super();
	}

	public LadrilloInexistenteException(String message){
		super(message);
	}
}
