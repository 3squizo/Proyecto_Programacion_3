package Implement;


public class Ambiente {
    private int id;
    private String nombre;
    private int capacidad;
    private String caracteristicas;

    public Ambiente() {
    }

    public Ambiente(int id, String nombre,
                    int capacidad, String caracteristicas) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.caracteristicas = caracteristicas;
    }

    public void mostrar() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad);
        System.out.println("Caracteristicas: " + caracteristicas);
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

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
}

