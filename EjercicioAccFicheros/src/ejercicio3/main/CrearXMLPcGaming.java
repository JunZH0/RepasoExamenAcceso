package ejercicio3.main;

import com.thoughtworks.xstream.XStream;
import javabeans.NodoRaiz;
import javabeans.PCGaming;

import java.io.*;

public class CrearXMLPcGaming {
    static NodoRaiz raiz;

    public static void main(String[] args) {
        obtenerDatosFichBinSec();

        generarFichXMLXStream();
    }

    private static void generarFichXMLXStream() {
        try {
            XStream xstream = new XStream();

            xstream.alias("pcs_gaming", NodoRaiz.class);
            xstream.alias("pc", PCGaming.class);
            xstream.aliasField("idPC", PCGaming.class, "idPc");

            xstream.addImplicitCollection(NodoRaiz.class, "listaPcs");

            Writer writer = new StringWriter();
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            xstream.toXML(raiz, new FileOutputStream("ficheros/PcGaming.xml"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void obtenerDatosFichBinSec() {
        raiz = new NodoRaiz();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Ficheros/PcGamingObj.dat"));) {
            try {
                while (true) {
                    raiz.addPCGaming((PCGaming) ois.readObject());
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (EOFException e) {
                System.out.println("#### Fin de fichero");
            } finally {
                ois.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
