package Implement;


public class LS_NormalResp extends ListaSimpleResp {

    public LS_NormalResp() {
        super();
    }

    public boolean esVacia() {
        return R == null;
    }

    public int nroNodos() {
        int c = 0;
        NodoResp aux = R;

        while (aux != null) {
            c++;
            aux = aux.getSig();
        }

        return c;
    }

    public void adiPrincipio(Responsable x) {
        NodoResp nuevo = new NodoResp(x);
        nuevo.setSig(R);
        R = nuevo;
    }

    public void adiFinal(Responsable x) {
        NodoResp nuevo = new NodoResp(x);

        if (esVacia()) {
            R = nuevo;
        } else {
            NodoResp aux = R;

            while (aux.getSig() != null) {
                aux = aux.getSig();
            }

            aux.setSig(nuevo);
        }
    }

    public Responsable eliPrincipio() {
        if (esVacia()) {
            return null;
        }

        Responsable x = R.getRe();
        R = R.getSig();

        return x;
    }

    public Responsable eliFinal() {
        if (esVacia()) {
            return null;
        }

        Responsable x;

        if (R.getSig() == null) {
            x = R.getRe();
            R = null;
        } else {
            NodoResp aux = R;

            while (aux.getSig().getSig() != null) {
                aux = aux.getSig();
            }

            x = aux.getSig().getRe();
            aux.setSig(null);
        }

        return x;
    }

    public void mostrar() {
        NodoResp aux = R;

        while (aux != null) {
            aux.getRe().mostrar();
            System.out.println("----------------");
            aux = aux.getSig();
        }
    }
}

