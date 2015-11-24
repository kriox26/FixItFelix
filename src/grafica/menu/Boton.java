package grafica.menu;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Boton {
	private	JFrame marco = new JFrame("Boton personalizado");
	private JButton play = new JButton();
	private JPanel panel = new JPanel();
	ImageIcon playBoton = new ImageIcon("src/Boton.png");
	
	public Boton(){
		marco.setSize(700,400);
		marco.setVisible(true);
		marco.setResizable(false);
		marco.setLocationRelativeTo(null);		
		inicializarComponentes();
	}
	public void inicializarComponentes(){
		panel.setLayout(null); 	
		play.setBounds(0,0,150,40);
		configurarBoton(play, playBoton);
		panel.add(play);
		marco.setContentPane(panel);
	}
	public void configurarBoton(JButton play, ImageIcon playBoton){
		play.setIcon(playBoton);
		play.setBorderPainted(false);
		play.setContentAreaFilled(false);
		play.setFocusable(false);
		play.setRolloverEnabled(true);
	}
	public static void main(String[] args){
		new Boton();
	}
	}
