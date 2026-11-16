package Implement;


public class NodoAct {
    private Actividad Ac;
    private NodoAct sig;

    public NodoAct() {
        sig = null;
    }

    public NodoAct(Actividad Ac) {
        this.Ac = Ac;
        sig = null;
    }

    public Actividad getAc() {
        return Ac;
    }

    public void setAc(Actividad Ac) {
        this.Ac = Ac;
    }

    public NodoAct getSig() {
        return sig;
    }

    public void setSig(NodoAct sig) {
        this.sig = sig;
    }
}

