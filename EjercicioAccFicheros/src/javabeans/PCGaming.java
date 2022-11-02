package javabeans;


import java.io.Serializable;

public class PCGaming implements Serializable {


        private int id;
        private String modelo;
        private String marca;
        private Procesador procesador;
        private int ram;
        private int precio;


    public PCGaming(int id, String modelo, String marca, Procesador procesador, int ram, int precio) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.procesador = procesador;
        this.ram = ram;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "PCGaming :" +
                "Id = " + id +
                " Modelo = '" + modelo + '\'' +
                " Marca = '" + marca + '\'' +
                " Procesador = " + procesador +
                " Ram = " + ram +
                " Precio = " + precio;
    }
}
