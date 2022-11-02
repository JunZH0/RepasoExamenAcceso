package dam.af.txt.ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaCFGS {


    public static void main(String[] args) {
        // editar la configuracion del proyecto para que el working directory sea el directorio donde se encuentran la carpeta ficheros
        try (BufferedReader br = new BufferedReader(new FileReader("Ficheros/cfgs.txt"))) {
            String linea;
            String[] datos;
            String[] texto = {"Titulacion: ", "Acronimo: ", "Familia: ", "Ley organica: ", "Duracion: "};

            while ((linea = br.readLine()) != null) {
                // separamos los datos por el caracter deseado
                // guarda los datos en un array de String
                datos = linea.split("&");

                for (int i = 0; i < datos.length; i++) {
                    // muestra primero el texto y despues el dato
                    System.out.println(texto[i] + datos[i]);
                }
                System.out.println();
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
