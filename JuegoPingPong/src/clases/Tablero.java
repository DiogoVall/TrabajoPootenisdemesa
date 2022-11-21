package clases;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import obtenerRecursos.Sonido;

public class Tablero extends JPanel {

    Raqueta raqueta1 = new Raqueta(10, 200);
    Raqueta raqueta2 = new Raqueta(794 - 10 - Raqueta.ANCHO, 200);
    Pelota bola = new Pelota();
    
    Sonido audio = new Sonido();
    AudioClip end=audio.getAudio("/recursos/lose.wav");

    public Tablero() {
        this.setBackground(Color.GREEN);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.BLACK);
        dibujarPuntaje(g2);
        dibujar(g2);

    }

    private void dibujar(Graphics2D g) {
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());
        g.setColor(Color.white);
        g.draw(linea);
        g.setColor(Color.red);
        g.fill(raqueta1.obtenerRaqueta());
        update();

        g.fill(raqueta2.obtenerRaqueta());
        update();
        g.setColor(Color.white);
        g.fill(bola.getShape());
        update();
    }

//actualiza el estado (posicion) de las raquetas y pelota
    private void update() {

        bola.moverBola(getBounds(), colision(raqueta1.obtenerRaqueta()), colision(raqueta2.obtenerRaqueta()));

        raqueta1.moverRaqueta1(getBounds());
        raqueta2.moverRaqueta2(getBounds());
    }

    //detecta si existe una colision entre la raqueta y la pelota
    private boolean colision(Rectangle2D r) {
        return bola.getShape().intersects(r);
    }

    private void dibujarPuntaje(Graphics2D g) {
        Graphics2D g1 = g, g2 = g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);

        g1.drawString(Integer.toString(bola.obtenerPuntaje1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(bola.obtenerPuntaje2()), (float) getBounds().getCenterX() + 25, 30);
        if (bola.obtenerPuntaje1() == 5) {
            g.drawString("VICTORIA DEL JUGADOR A", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
            end.play();
            
        }
        if (bola.obtenerPuntaje2() == 5) {
            g.drawString("VICTORIA DEL JUGADOR B", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 100);
            Pelota.finJuego = true;
            end.play();
        }
    }
    

}
