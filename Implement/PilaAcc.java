package Implement;


public class PilaAcc extends VectorAcc {
    private int tope;

    public PilaAcc() {
        super();
        tope = -1;
    }

    public PilaAcc(int MAX) {
        super(MAX);
        tope = -1;
    }

    public boolean esVacia() {
        return tope == -1;
    }

    public boolean esLlena() {
        return tope == MAX - 1;
    }

    public void adi(Accion x) {
        if (!esLlena()) {
            tope++;
            V[tope] = x;
        } else {
            System.out.println("Pila llena");
        }
    }

    public Accion eli() {
        if (esVacia()) {
            return null;
        }

        Accion x = V[tope];
        V[tope] = null;
        tope--;

        return x;
    }

    public int nroElem() {
        return tope + 1;
    }

    public void llenar(int n) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        for (int i = 0; i < n && !esLlena(); i++) {
            System.out.print("Tipo de accion: ");
            String tipo = sc.nextLine();

            adi(new Accion(tipo, new Evento()));
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Pila vacia");
            return;
        }

        for (int i = tope; i >= 0; i--) {
            V[i].mostrar();
        }
    }

    public void vaciar() {
        while (!esVacia()) {
            eli();
        }
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }
}

