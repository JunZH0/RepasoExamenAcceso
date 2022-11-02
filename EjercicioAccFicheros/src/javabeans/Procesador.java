package javabeans;

import java.io.Serializable;

public class Procesador implements Serializable {

        private String nombre;
        private double velocidad;

    public Procesador(String nombre, double velocidad) {
        this.nombre = nombre;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Procesador{" +
                " Nombre = '" + nombre + '\'' +
                " Velocidad = " + velocidad +
                '}';
    }
}
