package Implement;


public class LS_NormalAct extends ListaSimpleAct {

    public LS_NormalAct() {
        super();
    }

    public boolean esVacia() {
        return A == null;
    }

    public int nroNodos() {
        int c = 0;
        NodoAct aux = A;

        while (aux != null) {
            c++;
            aux = aux.getSig();
        }

        return c;
    }

    public void adiPrincipio(Actividad x) {
        NodoAct nuevo = new NodoAct(x);
        nuevo.setSig(A);
        A = nuevo;
    }

    public void adiFinal(Actividad x) {
        NodoAct nuevo = new NodoAct(x);

        if (esVacia()) {
            A = nuevo;
        } else {
            NodoAct aux = A;

            while (aux.getSig() != null) {
                aux = aux.getSig();
            }

            aux.setSig(nuevo);
        }
    }

    public Actividad eliPrincipio() {
        if (esVacia()) {
            return null;
        }

        Actividad x = A.getAc();
        A = A.getSig();

        return x;
    }

    public Actividad eliFinal() {
        if (esVacia()) {
            return null;
        }

        Actividad x;

        if (A.getSig() == null) {
            x = A.getAc();
            A = null;
        } else {
            NodoAct aux = A;

            while (aux.getSig().getSig() != null) {
                aux = aux.getSig();
            }

            x = aux.getSig().getAc();
            aux.setSig(null);
        }

        return x;
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("No existen actividades");
            return;
        }

        NodoAct aux = A;

        while (aux != null) {
            aux.getAc().mostrar();
            System.out.println("----------------");
            aux = aux.getSig();
        }
    }
}
