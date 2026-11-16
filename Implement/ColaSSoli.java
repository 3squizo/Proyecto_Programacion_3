package Implement;


public class ColaSSoli extends ColaSoli {

    public ColaSSoli() {
        super();
    }

    public ColaSSoli(int MAX) {
        super(MAX);
    }

    public boolean esVacia() {
        return fi == fr;
    }

    public boolean esLlena() {
        return nroElem() == MAX;
    }

    public int nroElem() {
        return (fr - fi + MAX) % MAX;
    }

    public void adi(Solicitud x) {
        if (!esLlena()) {
            V[fr] = x;
            fr = (fr + 1) % MAX;
        } else {
            System.out.println("Cola llena");
        }
    }

    public Solicitud eli() {
        if (esVacia()) {
            return null;
        }

        Solicitud x = V[fi];
        V[fi] = null;
        fi = (fi + 1) % MAX;

        return x;
    }

    public void llenar(int n) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        for (int i = 0; i < n && !esLlena(); i++) {
            System.out.println("Solicitud " + (i + 1));

            Solicitud s = new Solicitud();

            System.out.print("ID: ");
            s.setId(sc.nextInt());
            sc.nextLine();

            System.out.print("Fecha: ");
            s.setFechaSolicitud(sc.nextLine());

            System.out.print("Solicitante: ");
            s.setSolicitante(sc.nextLine());

            System.out.print("Estado: ");
            s.setEstado(sc.nextLine());

            adi(s);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Cola vacia");
            return;
        }

        int i = fi;

        while (i != fr) {
            V[i].mostrar();
            i = (i + 1) % MAX;
        }
    }

    public void vaciar() {
        while (!esVacia()) {
            eli();
        }
    }
}
