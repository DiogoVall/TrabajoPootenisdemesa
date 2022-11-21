package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Raqueta {

    private int x, y;
    static final int ANCHO = 10, ALTO = 40;

    public Raqueta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D obtenerRaqueta() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void moverRaqueta1(Rectangle limites) {
        if (EventoTeclado.w && y > limites.getMinY()) {
            y--;
        }
        if (EventoTeclado.s && y < limites.getMaxY()-ALTO) {
            y++;
        }
    }

    public void moverRaqueta2(Rectangle limites) {
        if (EventoTeclado.up && y > limites.getMinY()) {
            y--;
        }
        if (EventoTeclado.down && y < limites.getMaxY()-ALTO) {
            y++;
        }
    }
}
