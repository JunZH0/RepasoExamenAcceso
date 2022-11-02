package ejercicio2.main;

import javabeans.PCGaming;
import javabeans.Procesador;

import java.io.*;
import java.util.ArrayList;

public class InsertPCGamingObj {
    static ArrayList<PCGaming> listaPc;

    public static void main(String[] args) {

        inicializarDatos();

        insertarDatosFichBinSec();

        leerDatosFichBinSec();


    }

    private static void leerDatosFichBinSec()  {


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/PcGamingObj.dat"));) {
            try {
                while (true) {
                    PCGaming pc = (PCGaming) ois.readObject();
                    System.out.println(pc);
                }
            } catch (EOFException e) {
                System.out.println("Fin de fichero");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                ois.close();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private static void insertarDatosFichBinSec() {
        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream("Ficheros/PcGamingObj.dat"));) {
            // insertamos los datos en el fichero
            for (PCGaming pc : listaPc) {
                oos.writeObject(pc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inicializarDatos() {

        // agregar objetos al fichero
        listaPc = new ArrayList<PCGaming>();
        listaPc.add(new PCGaming(1, "Aorus", "Gigabyte", new Procesador("Intel i7 9700k", 3.5), 16, 2000));
        listaPc.add(new PCGaming(2, "Predator x1", "Acer", new Procesador(" Ryzen 9 5950x", 3.0), 32, 2499));
        listaPc.add(new PCGaming(3, "Predator xz", "Acer", new Procesador("Intel i9 10900k", 3.7), 32, 2999));
        listaPc.add(new PCGaming(4, " X51", "Alienware", new Procesador("Intel i9 12900k", 5.00), 64, 4500));
        listaPc.add(new PCGaming(5, "ROG G20", "Asus", new Procesador("Intel i7 6700", 3.7), 8, 1399));
    }
}
