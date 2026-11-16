package Implement;


public class Horario {
    private String fecha;
    private String horaInicio;
    private String horaFin;

    public Horario() {
    }

    public Horario(String fecha, String horaInicio, String horaFin) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public void mostrar() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora inicio: " + horaInicio);
        System.out.println("Hora fin: " + horaFin);
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
}
