package Implement;


public class LD_NormalEvent extends ListaDobleEvent {

    public LD_NormalEvent() {
        super();
    }

    public boolean esVacia() {
        return E == null;
    }

    public int nroNodos() {
        int c = 0;
        NodoEvent aux = E;

        while (aux != null) {
            c++;
            aux = aux.getSig();
        }

        return c;
    }

    public void adiPrincipio(Evento x) {
        NodoEvent nuevo = new NodoEvent(x);

        if (esVacia()) {
            E = nuevo;
        } else {
            nuevo.setSig(E);
            E.setAnt(nuevo);
            E = nuevo;
        }
    }

    public void adiFinal(Evento x) {
        NodoEvent nuevo = new NodoEvent(x);

        if (esVacia()) {
            E = nuevo;
        } else {
            NodoEvent aux = E;

            while (aux.getSig() != null) {
                aux = aux.getSig();
            }

            aux.setSig(nuevo);
            nuevo.setAnt(aux);
        }
    }

    public Evento eliPrincipio() {
        if (esVacia()) {
            return null;
        }

        Evento x = E.getEv();

        if (E.getSig() == null) {
            E = null;
        } else {
            E = E.getSig();
            E.setAnt(null);
        }

        return x;
    }

    public Evento eliFinal() {
        if (esVacia()) {
            return null;
        }

        Evento x;

        if (E.getSig() == null) {
            x = E.getEv();
            E = null;
        } else {
            NodoEvent aux = E;

            while (aux.getSig() != null) {
                aux = aux.getSig();
            }

            x = aux.getEv();
            aux.getAnt().setSig(null);
        }

        return x;
    }

    public void mostrar() {
        NodoEvent aux = E;

        if (esVacia()) {
            System.out.println("No existen eventos");
            return;
        }

        while (aux != null) {
            aux.getEv().mostrar();
            System.out.println("----------------");
            aux = aux.getSig();
        }
    }
}
