package clases;

import javax.swing.*;

import control.MotorGrafico;

public class Ventana extends JFrame {

    Tablero tablero;
    Pelota p = new Pelota();

    public Ventana() {
        setTitle("Juego Ping Pong");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        tablero = new Tablero();
        add(tablero);

        addKeyListener(new EventoTeclado());
        new MotorGrafico(tablero).start();
    }

}
