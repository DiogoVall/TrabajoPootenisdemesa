package clases;

import java.applet.AudioClip;
import java.awt.geom.Rectangle2D;
import obtenerRecursos.Sonido;

public class Pelota {

    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private double ejeX = 0;
    private static double ejeY = 0;
    private double dx = 1;
    private double dy = 1;
   
    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;
    
     Sonido audio = new Sonido();
     AudioClip rebote_1=audio.getAudio("/recursos/rebote_pelota1.wav");
     AudioClip rebote_2=audio.getAudio("/recursos/rebote_pelota2.wav");
     AudioClip falta=audio.getAudio("/recursos/falta.wav");

    
    //retorna la pelota (Rectangle2D implementa la interface Shape)
    public Rectangle2D getShape() {
        return new Rectangle2D.Double(ejeX, ejeY, TAMX, TAMY);
    }

    public void moverBola(Rectangle2D limites, boolean colisionR1, boolean colisionR2) {
        ejeX += dx;
        ejeY += dy;

        

        if (colisionR1) {
            dx = -dx;
            ejeX = 20;
            rebote_1.play();
        }
        if (colisionR2) {
            dx = -dx;
            ejeX = 755;
            rebote_1.play();
        }

        if (ejeX < limites.getMinX()) {
            score2++; //el puntaje del jugador2 aumenta en uno
           
            ejeX = limites.getCenterX();
            ejeY = limites.getCenterY();
            dx = -dx;
            falta.play();
        }

        if (ejeX + TAMX >= limites.getMaxX()) {
            score1++; //el puntaje del jugador1 aumenta en uno
            
            ejeX = limites.getCenterX();
            ejeY = limites.getCenterY();
            dx = -dx;
            audio.getAudio("/recursos/falta.wav").play();
        }

        if (ejeY < limites.getMinY()) {

            ejeY = limites.getMinY();

            dy = -dy;
            rebote_2.play();
        }

        if (ejeY + TAMY >= limites.getMaxY()) {

            ejeY = limites.getMaxY() - TAMY;

            dy = -dy;
            rebote_2.play();
        }

    }

    public int obtenerPuntaje1() {
        return score1;
    }

    public int obtenerPuntaje2() {
        return score2;
    }

    
    
}
