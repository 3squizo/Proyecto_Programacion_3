package Implement;


public class Solicitud {
    private int id;
    private String fechaSolicitud;
    private String solicitante;
    private Evento E;
    private String estado;

    public Solicitud() {
        E = new Evento();
    }

    public Solicitud(int id, String fechaSolicitud,
                     String solicitante, Evento E, String estado) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.solicitante = solicitante;
        this.E = E;
        this.estado = estado;
    }

    public void mostrar() {
        System.out.println("\n--- SOLICITUD ---");
        System.out.println("ID: " + id);
        System.out.println("Fecha: " + fechaSolicitud);
        System.out.println("Solicitante: " + solicitante);
        System.out.println("Estado: " + estado);
        E.mostrar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public Evento getE() {
        return E;
    }

    public void setE(Evento E) {
        this.E = E;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
