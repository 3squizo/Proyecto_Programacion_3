package Implement;


public class Responsable {
    private String ci;
    private String nombre;
    private String telefono;
    private String cargo;

    public Responsable() {
    }

    public Responsable(String ci, String nombre,
                       String telefono, String cargo) {
        this.ci = ci;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public void mostrar() {
        System.out.println("CI: " + ci);
        System.out.println("Nombre: " + nombre);
        System.out.println("Telefono: " + telefono);
        System.out.println("Cargo: " + cargo);
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
