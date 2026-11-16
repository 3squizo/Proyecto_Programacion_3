package Implement;


public class VectorAcc {
    protected int MAX;
    protected Accion V[];

    public VectorAcc() {
        MAX = 100;
        V = new Accion[MAX];
    }

    public VectorAcc(int MAX) {
        this.MAX = MAX;
        V = new Accion[MAX];
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
        V = new Accion[MAX];
    }

    public Accion[] getV() {
        return V;
    }

    public void setV(Accion[] V) {
        this.V = V;
    }
}
