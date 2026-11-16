package Implement;


public class NodoResp {
    private Responsable re;
    private NodoResp sig;

    public NodoResp() {
        sig = null;
    }

    public NodoResp(Responsable re) {
        this.re = re;
        sig = null;
    }

    public Responsable getRe() {
        return re;
    }

    public void setRe(Responsable re) {
        this.re = re;
    }

    public NodoResp getSig() {
        return sig;
    }

    public void setSig(NodoResp sig) {
        this.sig = sig;
    }
}
