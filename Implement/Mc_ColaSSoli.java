package Implement;


public class Mc_ColaSSoli {
    private int n;
    private ColaSSoli c[];

    public Mc_ColaSSoli() {
        n = 0;
        c = new ColaSSoli[100];
    }

    public Mc_ColaSSoli(int n) {
        this.n = n;
        c = new ColaSSoli[100];

        for (int i = 0; i < n; i++) {
            c[i] = new ColaSSoli();
        }
    }

    public int nroElem(int i) {
        if (i < 0 || i >= n || c[i] == null) {
            return 0;
        }

        return c[i].nroElem();
    }

    public boolean esVacia(int i) {
        return c[i] == null || c[i].esVacia();
    }

    public boolean esLlena(int i) {
        return c[i] != null && c[i].esLlena();
    }

    public void adicionar(int i, Solicitud x) {
        if (i >= 0 && i < n && c[i] != null) {
            c[i].adi(x);
        }
    }

    public Solicitud eliminar(int i) {
        if (i >= 0 && i < n && c[i] != null) {
            return c[i].eli();
        }

        return null;
    }

    public void llenar(int n) {
        if (n < 0 || n > 100) {
            System.out.println("Cantidad de colas invalida");
            return;
        }

        this.n = n;

        for (int i = 0; i < n; i++) {
            c[i] = new ColaSSoli();
        }
    }

    public void llenar(int i, int cantidad) {
        if (i >= 0 && i < n && c[i] != null) {
            c[i].llenar(cantidad);
        }
    }

    public void mostrar() {
        for (int i = 0; i < n; i++) {
            System.out.println("\nCOLA " + i);
            c[i].mostrar();
        }
    }

    public void mostrar(int i) {
        if (i >= 0 && i < n && c[i] != null) {
            System.out.println("\nCOLA " + i);
            c[i].mostrar();
        }
    }

    public void vaciar(int i, int cantidad) {
        if (i < 0 || i >= n || c[i] == null) {
            return;
        }

        for (int j = 0; j < cantidad && !c[i].esVacia(); j++) {
            c[i].eli();
        }
    }

    public void vaciar(int i, ColaSSoli destino) {
        if (i < 0 || i >= n || c[i] == null || destino == null) {
            return;
        }

        while (!c[i].esVacia() && !destino.esLlena()) {
            destino.adi(c[i].eli());
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n >= 0 && n <= 100) {
            this.n = n;

            for (int i = 0; i < n; i++) {
                if (c[i] == null) {
                    c[i] = new ColaSSoli();
                }
            }
        }
    }

    public ColaSSoli[] getC() {
        return c;
    }

    public void setC(ColaSSoli[] c) {
        this.c = c;
    }
}
