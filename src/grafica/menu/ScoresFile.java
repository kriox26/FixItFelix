package grafica.menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ScoresFile {
	private FileOutputStream f;


	public ScoresFile (){
		try{
			f = new FileOutputStream("src/grafica/menu/Scores.txt");
			agregarTexto("Jorge");
		}catch (IOException e){
			System.out.println("Error: "+e.getMessage());
		};
	}
	
	//public String getInputText(){
	//	String texto = input.getText();
	//	return texto;
	//}
	public void agregarTexto(String texto){
		try {
			Writer salida = new BufferedWriter(new OutputStreamWriter(f));	
			salida.write(texto);
			//bw.close();
		}catch (Exception e){
			System.out.println("Error"+e.getMessage());
		}
	}
	//private void concatenar(String nombre, String texto){
	//	String temp = 
	//}
	//private void leer(File nombre){
	//}
}