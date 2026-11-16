package Implement;


public class Accion {
    private String tipo;
    private Evento evento;

    public Accion() {
        evento = new Evento();
    }

    public Accion(String tipo, Evento evento) {
        this.tipo = tipo;
        this.evento = evento;
    }

    public void mostrar() {
        System.out.println("\n--- ACCION ---");
        System.out.println("Tipo: " + tipo);
        evento.mostrar();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}

