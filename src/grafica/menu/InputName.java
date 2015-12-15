package grafica.menu;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InputName extends Grafica {
	private String imgPath = "src/grafica/imagenes/";
	private JTextField input;
	private String backgroundImage =imgPath + "high_scores.jpg";
	private ImageIcon goBackIcon = new ImageIcon(imgPath+"Menu.png"); 
	private ScoresFile scores;

	public InputName(){
		setLayout(null);
		JLabel label = new JLabel();
		label.setBackground(Color.BLACK);
		label.setText("Ingrese su nombre: ");
		this.add(label);
		//File Image = new File(backgroundImage);
		setContentPane(new JLabel());
		input = new JTextField();
		input.setBounds(0, 0, 200, 75);
		input.setBackground(Color.WHITE);
		input.setSize(200, 75);
		input.setVisible(true);
		input.setHorizontalAlignment(JTextField.LEFT);
		goBack.setIcon(goBackIcon);
		goBack.setBounds(0, 100, 216, 51);
		add(goBack);
		add(input);
		setSize(919, 720);
		setResizable(false);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//scores = new ScoresFile();
		//scores.agregarTexto(input.getText());
	}
	public void addKeyboardEvents(KeyAdapter keyadapter){
        this.addKeyListener(keyadapter);
    }
}
