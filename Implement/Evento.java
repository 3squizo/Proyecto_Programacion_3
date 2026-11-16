package Implement;


public class Evento {
    private int id;
    private String nombre;
    private String tipo;
    private String descripcion;
    private String estado;
    private LS_NormalAct LA;

    public Evento() {
        LA = new LS_NormalAct();
    }

    public Evento(int id, String nombre, String tipo,
                  String descripcion, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = estado;
        LA = new LS_NormalAct();
    }

    public void mostrar() {
        System.out.println("\n========== EVENTO ==========");
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Tipo: " + tipo);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Estado: " + estado);

        System.out.println("\nACTIVIDADES:");
        LA.mostrar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LS_NormalAct getLA() {
        return LA;
    }

    public void setLA(LS_NormalAct LA) {
        this.LA = LA;
    }
}
