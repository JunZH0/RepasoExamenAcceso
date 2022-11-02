package javabeans;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class NodoRaiz implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<PCGaming> listaPcs;

    // inicializar arraylist en el constructor
    public NodoRaiz () {
        listaPcs = new ArrayList<>();
    }
    // metodo para añadir pc al arraylist
    public void addPCGaming(PCGaming pc) {
        listaPcs.add(pc);
    }
    // metodo para obtener el arraylist
    public ArrayList<PCGaming> getListaPc() {
        return listaPcs;
    }

}
