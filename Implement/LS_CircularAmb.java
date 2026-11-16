package Implement;


public class LS_CircularAmb extends ListaSimpleAmb {

    public LS_CircularAmb() {
        super();
    }

    public boolean esVacia() {
        return A == null;
    }

    public int nroNodos() {
        if (esVacia()) {
            return 0;
        }

        int c = 0;
        NodoAmb aux = A;

        do {
            c++;
            aux = aux.getSig();
        } while (aux != A);

        return c;
    }

    public void adiPrincipio(Ambiente x) {
        NodoAmb nuevo = new NodoAmb(x);

        if (esVacia()) {
            A = nuevo;
            nuevo.setSig(A);
        } else {
            NodoAmb ultimo = A;

            while (ultimo.getSig() != A) {
                ultimo = ultimo.getSig();
            }

            nuevo.setSig(A);
            ultimo.setSig(nuevo);
            A = nuevo;
        }
    }

    public void adiFinal(Ambiente x) {
        NodoAmb nuevo = new NodoAmb(x);

        if (esVacia()) {
            A = nuevo;
            nuevo.setSig(A);
        } else {
            NodoAmb ultimo = A;

            while (ultimo.getSig() != A) {
                ultimo = ultimo.getSig();
            }

            ultimo.setSig(nuevo);
            nuevo.setSig(A);
        }
    }

    public Ambiente eliPrincipio() {
        if (esVacia()) {
            return null;
        }

        Ambiente x = A.getAm();

        if (A.getSig() == A) {
            A = null;
        } else {
            NodoAmb ultimo = A;

            while (ultimo.getSig() != A) {
                ultimo = ultimo.getSig();
            }

            A = A.getSig();
            ultimo.setSig(A);
        }

        return x;
    }

    public Ambiente eliFinal() {
        if (esVacia()) {
            return null;
        }

        Ambiente x;

        if (A.getSig() == A) {
            x = A.getAm();
            A = null;
        } else {
            NodoAmb aux = A;

            while (aux.getSig().getSig() != A) {
                aux = aux.getSig();
            }

            x = aux.getSig().getAm();
            aux.setSig(A);
        }

        return x;
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Lista vacia");
            return;
        }

        NodoAmb aux = A;

        do {
            aux.getAm().mostrar();
            System.out.println("----------------");
            aux = aux.getSig();
        } while (aux != A);
    }
}
