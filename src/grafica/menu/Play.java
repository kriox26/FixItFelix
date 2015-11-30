package grafica.menu;

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
    private static final int horVentanas = horEdificio + 10;
    private static final int offsetYVentanas = 68;
    private static final int offsetXVentanas = 30;
    
    /*
    * Se crean todas las imagenes de Niceland, ventanas con obstaculos
    * todo.
    */
    public Play(Main main, VentanaView[][] building, Map<String, BufferedImage> imagenes){
        setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
        add(goBack);
        setSize(800, 600);
        setVisible(true);
        this.getGraphics().drawImage(imagenes.get("fondo.png"), 0,0,null);
        cargarNiceland(building, imagenes);
        try{
            Thread.sleep(2000000);
        } catch(InterruptedException e){
            
        }
    }
    
    public void addKeyboardEvents(KeyAdapter keyadapter){
        this.addKeyListener(keyadapter);
    }
    
    public void cargarNiceland(VentanaView[][] building, Map<String, BufferedImage> imagenes){
        // Dibujar secciones primero
        File imagen = new File("src/grafica/imagenes/edificio/piso2.png");
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
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                this.getGraphics().drawImage(building[i][j].getImagenActual(), 10 + horEdificio + actualX + building[i][j].getXinicial(), verEdificio + (230 - (alturaActual + building[i][j].getYinicial())), null);
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
