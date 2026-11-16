package Implement;


public class NodoEvent {
    private Evento Ev;
    private NodoEvent ant;
    private NodoEvent sig;

    public NodoEvent() {
        ant = null;
        sig = null;
    }

    public NodoEvent(Evento Ev) {
        this.Ev = Ev;
        ant = null;
        sig = null;
    }

    public Evento getEv() {
        return Ev;
    }

    public void setEv(Evento Ev) {
        this.Ev = Ev;
    }

    public NodoEvent getAnt() {
        return ant;
    }

    public void setAnt(NodoEvent ant) {
        this.ant = ant;
    }

    public NodoEvent getSig() {
        return sig;
    }

    public void setSig(NodoEvent sig) {
        this.sig = sig;
    }
}

