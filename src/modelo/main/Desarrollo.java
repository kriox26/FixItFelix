package modelo.main;

public class Desarrollo {
    private int nivel;
    private int puntos;
    
    public Desarrollo(int nivel, int puntos){
        this.nivel = nivel;
        this.puntos = puntos;
    }
    
    public int getNivel(){
        return this.nivel;
    }
    
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
    public void setPuntos(int puntos){
        this.puntos = puntos;
    }
}
