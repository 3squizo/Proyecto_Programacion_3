package Implement;

public class Actividad {
	private String nombre;
	private String descripcion;
	private Horario horario;
	private Ambiente ambiente;
	private Responsable responsable;

	public Actividad() {
		horario = new Horario();
		ambiente = new Ambiente();
		responsable = new Responsable();
	}

	public Actividad(String nombre, String descripcion, String fecha, String horaInicio, String horaFin, Ambiente ambiente, Responsable responsable) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.horario = new Horario(fecha, horaInicio, horaFin);
		this.ambiente = ambiente;
		this.responsable = responsable;
	}

	public void mostrar() {
		System.out.println("\n--- ACTIVIDAD ---");
		System.out.println("Nombre: " + nombre);
		System.out.println("Descripcion: " + descripcion);

		System.out.println("\nHorario:");
		horario.mostrar();

		System.out.println("\nAmbiente:");
		ambiente.mostrar();

		System.out.println("\nResponsable:");
		responsable.mostrar();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
}
