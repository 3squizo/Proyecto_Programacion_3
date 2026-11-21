package Implement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	private static final DateTimeFormatter FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter HORA = DateTimeFormatter.ofPattern("HH:mm");

	public static void main(String[] args) {
		// CREAR GESTOR
		GestorEventos G = new GestorEventos();

		// RESPONSABLES (registro general del gestor)
		Responsable r1 = new Responsable("1234567", "Carlos Perez", "70011111", "Coordinador");
		Responsable r2 = new Responsable("7654321", "Maria Lopez", "70022222", "Organizadora");
		Responsable r3 = new Responsable("4567890", "Juan Flores", "70033333", "Tecnico");
		G.getResponsables().adiFinal(r1);
		G.getResponsables().adiFinal(r2);
		G.getResponsables().adiFinal(r3);

		// AMBIENTES (registro general del gestor)
		Ambiente a1 = new Ambiente(1, "Salon Principal", 500, "Proyector, escenario y sonido");
		Ambiente a2 = new Ambiente(2, "Auditorio", 300, "Pantalla y sistema de audio");
		Ambiente a3 = new Ambiente(3, "Sala de Conferencias", 100, "Mesas y sillas");
		G.getAmbientes().adiFinal(a1);
		G.getAmbientes().adiFinal(a2);
		G.getAmbientes().adiFinal(a3);

		// ACTIVIDADES (cada una pertenece a un solo evento)
		Actividad ac1 = new Actividad("Inauguracion", "Acto de apertura del evento", "05/12/2026", "08:00", "10:00", a1, r1);
		Actividad ac2 = new Actividad("Conferencia", "Exposicion principal", "05/12/2026", "10:30", "12:00", a2, r2);
		Actividad ac3 = new Actividad("Taller", "Taller de tecnologia", "06/12/2026", "14:00", "16:00", a3, r3);
		Actividad ac4 = new Actividad("Show de danza", "Presentacion folklorica", "12/12/2026", "18:00", "20:00", a1, r2);
		Actividad ac5 = new Actividad("Feria de artesanias", "Exposicion cultural", "13/12/2026", "10:00", "13:00", a3, r3);
		Actividad ac6 = new Actividad("Campeonato de futsal", "Partidos de la jornada", "05/12/2026", "09:00", "11:00", a1, r3);
		Actividad ac7 = new Actividad("Seminario de ciberseguridad", "Charlas y casos reales", "10/11/2026", "09:00", "11:00", a2, r1);

		// EVENTOS
		Evento e1 = new Evento(1, "Congreso de Informatica", "Academico", "Congreso universitario de tecnologia", "Programado");
		Evento e2 = new Evento(2, "Feria Empresarial", "Comercial", "Exposicion de empresas", "Programado");
		Evento e3 = new Evento(3, "Festival Cultural", "Cultural", "Presentaciones culturales", "Pendiente");
		Evento e4 = new Evento(4, "Jornada Deportiva", "Deportivo", "Campeonato interfacultades", "Pendiente");
		Evento e5 = new Evento(5, "Seminario de Seguridad", "Academico", "Seminario sobre seguridad de la informacion", "Programado");

		// Agregar actividades a cada evento
		e1.getLA().adiFinal(ac1);
		e1.getLA().adiFinal(ac2);
		e2.getLA().adiFinal(ac3);
		e3.getLA().adiFinal(ac4);
		e3.getLA().adiFinal(ac5);
		e4.getLA().adiFinal(ac6);
		e5.getLA().adiFinal(ac7);

		// LISTA DOBLE DE EVENTOS PROGRAMADOS (solo los aprobados)
		G.getProgramados().adiFinal(e1);
		G.getProgramados().adiFinal(e2);
		G.getProgramados().adiFinal(e5);

		// SOLICITUDES
		Solicitud s3 = new Solicitud(103, "12/11/2026", "Centro Cultural", e3, "Pendiente");
		Solicitud s4 = new Solicitud(104, "15/11/2026", "Federacion Deportiva", e4, "Pendiente");
		// Colas independientes solo de solicitudes pendientes
		G.getPendientes().llenar(2);
		G.getPendientes().adicionar(0, s3);
		G.getPendientes().adicionar(1, s4);

		// HISTORIAL DE ACCIONES
		Accion acA = new Accion("Registro de evento", e1);
		Accion acB = new Accion("Programacion de evento", e2);
		Accion acC = new Accion("Registro de evento", e3);
		Accion acD = new Accion("Programacion de evento", e5);
		G.getHistorial().adi(acA);
		G.getHistorial().adi(acB);
		G.getHistorial().adi(acC);
		G.getHistorial().adi(acD);

		// ESTRUCTURAS
		System.out.println("\tPRUEBA DEL SISTEMA");

		System.out.println("\n1. RESPONSABLES");
		System.out.println("Cantidad: " + G.getResponsables().nroNodos());
		G.getResponsables().mostrar();

		System.out.println("\n2. AMBIENTES");
		System.out.println("Cantidad: " + G.getAmbientes().nroNodos());
		G.getAmbientes().mostrar();

		System.out.println("\n3. ACTIVIDADES DEL EVENTO 1");
		System.out.println("Cantidad: " + e1.getLA().nroNodos());
		e1.getLA().mostrar();

		System.out.println("\n4. EVENTOS PROGRAMADOS");
		System.out.println("Cantidad: " + G.getProgramados().nroNodos());
		G.getProgramados().mostrar();

		System.out.println("\n5. SOLICITUDES PENDIENTES");
		G.getPendientes().mostrar();

		System.out.println("\n6. HISTORIAL DE ACCIONES");
		System.out.println("Cantidad: " + G.getHistorial().nroElem());
		G.getHistorial().mostrar();

		System.out.println("\n7. GESTOR COMPLETO");
		G.mostrar();

		// PROBLEMAS LOGICOS
		String fechaActual = LocalDate.now().format(FECHA);
		String horaActual = LocalTime.now().format(HORA);

		System.out.println("\tPROBLEMAS RESUELTOS");
		s4.setEstado("Aprobado"); // Se aprueba la solicitud de e4, pero ac6 choca con ac1 en el Salon Principal
		System.out.println("\n===== PROBLEMAS 1, 2 y 3: CONFLICTOS Y ESTADOS =====");
		determinarYActualizarEstados(G.getPendientes(), G.getProgramados(), G.getHistorial(), fechaActual, horaActual);

		System.out.println("\n===== PROBLEMA 4: CANCELAR EVENTO =====");
		cancelarEvento(G.getProgramados(), G.getHistorial(), G.getAmbientes(), 1);

		System.out.println("\nSE VUELVE A DETERMINAR LOS ESTADOS (e4 ya no tiene conflicto)");
		determinarYActualizarEstados(G.getPendientes(), G.getProgramados(), G.getHistorial(), fechaActual, horaActual);

		System.out.println("\n===== PROBLEMA 5: BUSQUEDA DE AMBIENTES =====");
		buscarAmbientes(G.getAmbientes(), 200, "proyector");
		buscarAmbientes(G.getAmbientes(), 100, "mesas", "sillas");
		buscarAmbientes(G.getAmbientes(), 400, "audio");

		System.out.println("\n===== RESULTADO FINAL =====");
		System.out.println("\nEVENTOS PROGRAMADOS");
		G.getProgramados().mostrar();
		System.out.println("\nHISTORIAL DE ACCIONES");
		G.getHistorial().mostrar();
	}

	// PROBLEMA 1: conflicto por ambiente
	// Dos actividades chocan si usan el mismo ambiente, el mismo dia y sus rangos de hora se traslapan.
	private static boolean hayTraslape(Actividad a, Actividad b) {
		if (a.getAmbiente().getId() != b.getAmbiente().getId()) {
			return false;
		}
		Horario ha = a.getHorario();
		Horario hb = b.getHorario();
		LocalDate fechaA = LocalDate.parse(ha.getFecha(), FECHA);
		LocalDate fechaB = LocalDate.parse(hb.getFecha(), FECHA);
		if (!fechaA.isEqual(fechaB)) {
			return false;
		}
		LocalTime iniA = LocalTime.parse(ha.getHoraInicio());
		LocalTime finA = LocalTime.parse(ha.getHoraFin());
		LocalTime iniB = LocalTime.parse(hb.getHoraInicio());
		LocalTime finB = LocalTime.parse(hb.getHoraFin());
		return iniA.isBefore(finB) && iniB.isBefore(finA);
	}
	
	private static boolean eventoTieneConflicto(Evento nuevo, LD_NormalEvent programados) {
		boolean conflicto = false;
		LS_NormalAct listaNueva = nuevo.getLA();
		int cantNueva = listaNueva.nroNodos();
		for (int i = 0; i < cantNueva; i++) {
			Actividad a = listaNueva.eliPrincipio();
			NodoEvent actual = programados.getE();
			while (actual != null) {
				Evento otro = actual.getEv();
				if (otro != nuevo && otro.getEstado().equals("Programado")) {
					LS_NormalAct listaOtro = otro.getLA();
					int cantOtro = listaOtro.nroNodos();
					for (int j = 0; j < cantOtro; j++) {
						Actividad b = listaOtro.eliPrincipio();
						if (hayTraslape(a, b)) {
							conflicto = true;
							System.out.println("CONFLICTO de ambiente: " + a.getAmbiente().getNombre() + " el "+ a.getHorario().getFecha());
							System.out.println("  - " + a.getNombre() + " (Evento " + nuevo.getId() + "): "+ a.getHorario().getHoraInicio() + " a " + a.getHorario().getHoraFin());
							System.out.println("  - " + b.getNombre() + " (Evento " + otro.getId() + "): "+ b.getHorario().getHoraInicio() + " a " + b.getHorario().getHoraFin());
						}
						listaOtro.adiFinal(b);
					}
				}
				actual = actual.getSig();
			}
			listaNueva.adiFinal(a);
		}
		return conflicto;
	}

	// PROBLEMAS 2 y 3: estados de los eventos
	private static LocalDateTime fechaFinEvento(Evento e) {
		LS_NormalAct lista = e.getLA();
		int cant = lista.nroNodos();
		LocalDateTime masTarde = null;
		for (int i = 0; i < cant; i++) {
			Actividad a = lista.eliPrincipio();
			Horario h = a.getHorario();
			LocalDateTime fin = LocalDateTime.of(LocalDate.parse(h.getFecha(), FECHA), LocalTime.parse(h.getHoraFin()));
			if (masTarde == null || fin.isAfter(masTarde)) {
				masTarde = fin;
			}
			lista.adiFinal(a);
		}
		return masTarde;
	}

	public static void determinarYActualizarEstados(Mc_ColaSSoli pendientes, LD_NormalEvent programados, PilaAcc historial, String fechaActual, String horaActual) {
		LocalDateTime ahora = LocalDateTime.of(LocalDate.parse(fechaActual, FECHA), LocalTime.parse(horaActual));
		// 1. Pendiente -> Programado (solicitud aprobada y sin conflicto de ambiente)
		for (int r = 0; r < pendientes.getN(); r++) {
			int cant = pendientes.nroElem(r);
			for (int i = 0; i < cant; i++) {
				Solicitud sol = pendientes.eliminar(r);
				if (sol.getEstado().equals("Aprobado")) {
					Evento e = sol.getE();
					if (eventoTieneConflicto(e, programados)) {
						System.out.println("No se puede programar el evento " + e.getId() + ": conflicto de ambiente. La solicitud sigue en espera");
						pendientes.adicionar(r, sol);
					} else {
						e.setEstado("Programado");
						programados.adiFinal(e);
						historial.adi(new Accion("Cambio a Programado", e));
					}
				} else {
					pendientes.adicionar(r, sol);
				}
			}
		}
		// 2. Programado -> Finalizado (ya paso la actividad que termina ultima)
		int totalProgramados = 0;
		int totalFinalizados = 0;
		int totalCancelados = 0;
		NodoEvent actual = programados.getE();
		while (actual != null) {
			Evento e = actual.getEv();
			if (e.getEstado().equals("Programado")) {
				LocalDateTime fin = fechaFinEvento(e);
				if (fin != null && !ahora.isBefore(fin)) {
					e.setEstado("Finalizado");
					historial.adi(new Accion("Cambio a Finalizado", e));
				}
			}
			if (e.getEstado().equals("Programado")) {
				totalProgramados++;
			} else if (e.getEstado().equals("Finalizado")) {
				totalFinalizados++;
			} else if (e.getEstado().equals("Cancelado")) {
				totalCancelados++;
			}
			actual = actual.getSig();
		}
		// 3. Eventos que siguen pendientes (solicitudes en las colas)
		int totalPendientes = 0;
		for (int r = 0; r < pendientes.getN(); r++) {
			totalPendientes += pendientes.nroElem(r);
		}
		System.out.println("\nRESUMEN DE EVENTOS");
		System.out.println("Pendientes: " + totalPendientes);
		System.out.println("Programados: " + totalProgramados);
		System.out.println("Finalizados: " + totalFinalizados);
		System.out.println("Cancelados: " + totalCancelados);
	}

	// PROBLEMA 4: cancelar evento y liberar ambientes
	public static void cancelarEvento(LD_NormalEvent agenda, PilaAcc historial, LS_CircularAmb ambientes, int idEvento) {
		int cantidadEventos = agenda.nroNodos();
		boolean encontrado = false;
		for (int i = 0; i < cantidadEventos; i++) {
			Evento e = agenda.eliPrincipio();
			if (e.getId() == idEvento && e.getEstado().equals("Programado")) {
				liberarAmbientes(e, ambientes);
				e.setEstado("Cancelado");
				historial.adi(new Accion("Cancelacion de evento", e));
				encontrado = true;
				System.out.println("Evento con ID " + idEvento + " cancelado exitosamente");
			}
			agenda.adiFinal(e);
		}
		if (!encontrado) {
			System.out.println("No se encontro un evento programado con el ID: " + idEvento);
		}
	}

	public static void liberarAmbientes(Evento e, LS_CircularAmb ambientes) {
		if (ambientes.esVacia()) {
			System.out.println("No existen ambientes registrados");
			return;
		}
		LS_NormalAct listaAct = e.getLA();
		int cantidadActividades = listaAct.nroNodos();
		for (int i = 0; i < cantidadActividades; i++) {
			Actividad a = listaAct.eliPrincipio();
			int idAmbiente = a.getAmbiente().getId();
			NodoAmb aux = ambientes.getA();
			boolean encontrado = false;
			do {
				Ambiente amb = aux.getAm();
				if (amb.getId() == idAmbiente) {
					encontrado = true;
					System.out.println("Ambiente liberado: " + amb.getNombre() + " (" + a.getHorario().getFecha() + ", "+ a.getHorario().getHoraInicio() + " a " + a.getHorario().getHoraFin() + ")");
				}
				aux = aux.getSig();
			} while (aux != ambientes.getA());
			if (!encontrado) {
				System.out.println("No se encontro el ambiente con ID: " + idAmbiente);
			}
			listaAct.adiFinal(a);
		}
	}

	// PROBLEMA 5: busqueda de ambientes por capacidad y caracteristicas
	public static void buscarAmbientes(LS_CircularAmb ambientes, int capacidadMin, String... caracteristicas) {
		System.out.println("\nBusqueda: capacidad minima " + capacidadMin + ", caracteristicas: "+ String.join(", ", caracteristicas));
		if (ambientes.esVacia()) {
			System.out.println("No existen ambientes registrados");
			return;
		}
		int encontrados = 0;
		NodoAmb aux = ambientes.getA();
		do {
			Ambiente amb = aux.getAm();
			if (amb.getCapacidad() >= capacidadMin && tieneCaracteristicas(amb, caracteristicas)) {
				amb.mostrar();
				encontrados++;
			}
			aux = aux.getSig();
		} while (aux != ambientes.getA());
		if (encontrados == 0) {
			System.out.println("Ningun ambiente cumple los requisitos :(");
		}
	}

	private static boolean tieneCaracteristicas(Ambiente amb, String[] requeridas) {
		String texto = amb.getCaracteristicas().toLowerCase();
		for (int i = 0; i < requeridas.length; i++) {
			if (!texto.contains(requeridas[i].toLowerCase())) {
				return false;
			}
		}
		return true;
	}
}
