package Implement;


public class NodoAmb {
    private Ambiente Am;
    private NodoAmb sig;

    public NodoAmb() {
        sig = null;
    }

    public NodoAmb(Ambiente Am) {
        this.Am = Am;
        sig = null;
    }

    public Ambiente getAm() {
        return Am;
    }

    public void setAm(Ambiente Am) {
        this.Am = Am;
    }

    public NodoAmb getSig() {
        return sig;
    }

    public void setSig(NodoAmb sig) {
        this.sig = sig;
    }
}
