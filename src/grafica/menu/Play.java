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
        setLayout(new FlowLayout());
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
        File imagen = new File("src/grafica/imagenes/edificio/edificio_150_seccion1.png");
        BufferedImage img = null;
        try{
            img = ImageIO.read(imagen);
        }catch(IOException e){
            e.printStackTrace();
        }
        this.getGraphics().drawImage(img, horEdificio, verEdificio, null);

        // Despues dibujamos ventanas sobre las secciones
        int actualX = 0;
        int actualY = 97;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                this.getGraphics().drawImage(building[i][j].getImagenActual(), horVentanas + actualX + (20*(j+1)), verEdificio + (340 - actualY), null);
                System.out.println("Posicion("+ i + "," + j + ").\nTenemos los offsets: OffsetX= " + building[i][j].getOffsetX() + " y OffsetY= " + building[i][j].getOffsetY() + "\n");
                actualX += building[i][j].getOffsetX();
            }
            actualX = 0;
            actualY += 56;
        }
        this.getGraphics().drawImage(imagenes.get("a_standing_basic.png"), horVentanas + offsetXVentanas * 4 + 10, verEdificio + (340 - 2*offsetYVentanas - 18), null);
        this.getGraphics().drawImage(imagenes.get("u_leftHit.png"),horVentanas + offsetXVentanas * 4 + 10, verEdificio + (340 - 5*offsetYVentanas + 2), null);
        this.getGraphics().drawImage(imagenes.get("ladrillo_der.png"), horVentanas + offsetXVentanas * 4 + 10, verEdificio *(340 - 2*offsetYVentanas - 18), null);
    }
    
    public void paintComponents(Graphics g){
        super.paintComponents(g);
    }
}
