package control;

import clases.Tablero;
import clases.Pelota;

public class MotorGrafico extends Thread {

    private final Tablero tab;

    public MotorGrafico(Tablero tab) {
        this.tab = tab;
    }

    @Override
    public void run() {
        while (!Pelota.finJuego) {
            tab.repaint();
            try {
                //Velocidad de pintado
                Thread.sleep(6);
            } catch (Exception ex) {
                System.out.println("error en motor grafico: " + ex.getMessage());
            }
        }
    }
}
