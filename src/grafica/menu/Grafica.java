package grafica.menu;

import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Grafica extends JFrame {
	protected JButton goBack = new JButton();

	public void addMouseEvents(MouseAdapter e){
		
	}

	public void addKeyboardEvents(KeyAdapter e){
		
	}

	public void addBackMenu(MouseAdapter goback){
		goBack.addMouseListener(goback);
	}

	public void turnOff(){
		setVisible(false);
	}

}
