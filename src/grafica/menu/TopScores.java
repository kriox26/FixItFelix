package grafica.menu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TopScores extends JFrame{
	private JButton goBack;
	private String imgPath = "src/grafica/imagenes/";
	private String backgroundImage = imgPath + "high_scores.jpg";
	private ImageIcon goBackIcon = new ImageIcon(imgPath + "back_arrow_blue.png");


	public TopScores(){
		setLayout(new BorderLayout());

        File image = new File(backgroundImage);

		setContentPane(new JLabel(new ImageIcon(image.getAbsolutePath())));

		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));

		goBack = new JButton();
		goBack.setIcon(goBackIcon);
		goBack.setBorder(null);
		add(goBack);

		goBack.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0){
				setVisible(false);
				MainMenu mn = new MainMenu();
			}
		});

		add(goBack);
		setTitle("Top Scores");
		setSize(919, 720);
		setVisible(true);
	}
}
