package grafica.menu;

import grafica.dinamica.personajes.FelixView;
import grafica.niceland.VentanaView;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import modelo.main.Main;

public class Play extends Grafica {
    private static final int horEdificio= 250;
    private static final int verEdificio= 120;
    
    /*
    * Se crean todas las imagenes de Niceland, ventanas con obstaculos
    * todo.
    */
    public Play(Main main, VentanaView[][] building, Map<String, BufferedImage> imagenes, FelixView felix){
        setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
        add(goBack);
        setSize(800, 600);
        setVisible(true);
        this.getGraphics().drawImage(imagenes.get("grass_background.jpg"), 0,0,null);
        cargarNiceland(building, imagenes, felix);
        try{
            Thread.sleep(2000000);
        } catch(InterruptedException e){
            
        }
    }
    
    public void addKeyboardEvents(KeyAdapter keyadapter){
        this.addKeyListener(keyadapter);
    }

    public void cargarNiceland(VentanaView[][] building, Map<String, BufferedImage> imagenes, FelixView felix){
        // Dibujar secciones primero
        File imagen = new File("src/grafica/imagenes/edificio/piso1.png");
        BufferedImage img = null;
        try{
            img = ImageIO.read(imagen);
        }catch(IOException e){
            e.printStackTrace();
        }
        this.getGraphics().drawImage(img, horEdificio, verEdificio, null);

        // Despues dibujamos ventanas sobre las secciones
        int alturaActual = 0;
        int actualX = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
            	VentanaView act = building[i][j];
            	int venX = 10 + horEdificio + actualX + act.getXinicial();
            	int venY = verEdificio + (230 - (alturaActual + act.getYinicial()));
                this.getGraphics().drawImage(act.getImagenActual(), venX, venY, null);
                if(act.tieneObstaculo()){
                	this.getGraphics().drawImage(act.getObstaculoView().getImagenActual(), venX + act.getObstaculoView().getOffsetX(), venY + act.getObstaculoView().getOffsetY(), null);
                }
            	if(felix.getOffsetX() == j && felix.getOffsetY() == i){
            		this.getGraphics().drawImage(felix.getImagenActual(), venX + act.getAjusteX(), venY + act.getAjusteY(), null);
            	}
                actualX += 54;
            }
            // if (i == 2 || i == 5 || i == 8) {
            //     alturaActual += 90;
            // }else{
                alturaActual += 70;
            // }
            actualX = 0;
        }
    }
    
    public void paintComponents(Graphics g){
        super.paintComponents(g);
    }
}
