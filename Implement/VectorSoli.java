package Implement;


public class VectorSoli {
    protected int MAX;
    protected Solicitud V[];

    public VectorSoli() {
        MAX = 100;
        V = new Solicitud[MAX];
    }

    public VectorSoli(int MAX) {
        this.MAX = MAX;
        V = new Solicitud[MAX];
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
        V = new Solicitud[MAX];
    }

    public Solicitud[] getV() {
        return V;
    }

    public void setV(Solicitud[] V) {
        this.V = V;
    }
}
