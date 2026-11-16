package Implement;


public class Main {

    public static void main(String[] args) {

        // =====================================
        // CREAR GESTOR
        // =====================================

        GestorEventos G = new GestorEventos();

        // =====================================
        // RESPONSABLES
        // =====================================

        Responsable r1 = new Responsable(
            "1234567", "Carlos Perez",
            "70011111", "Coordinador"
        );

        Responsable r2 = new Responsable(
            "7654321", "Maria Lopez",
            "70022222", "Organizadora"
        );

        Responsable r3 = new Responsable(
            "4567890", "Juan Flores",
            "70033333", "Tecnico"
        );

        G.getResponsables().adiFinal(r1);
        G.getResponsables().adiFinal(r2);
        G.getResponsables().adiFinal(r3);

        // =====================================
        // AMBIENTES
        // =====================================

        Ambiente a1 = new Ambiente(
            1, "Salon Principal", 500,
            "Proyector, escenario y sonido"
        );

        Ambiente a2 = new Ambiente(
            2, "Auditorio", 300,
            "Pantalla y sistema de audio"
        );

        Ambiente a3 = new Ambiente(
            3, "Sala de Conferencias", 100,
            "Mesas y sillas"
        );

        G.getAmbientes().adiFinal(a1);
        G.getAmbientes().adiFinal(a2);
        G.getAmbientes().adiFinal(a3);

        // =====================================
        // HORARIOS
        // =====================================

        Horario h1 = new Horario(
            "20/11/2026", "08:00", "10:00"
        );

        Horario h2 = new Horario(
            "20/11/2026", "10:30", "12:00"
        );

        Horario h3 = new Horario(
            "21/11/2026", "14:00", "16:00"
        );

        // =====================================
        // ACTIVIDADES
        // =====================================

        Actividad ac1 = new Actividad(
            "Inauguracion",
            "Acto de apertura del evento",
            h1, a1, r1
        );

        Actividad ac2 = new Actividad(
            "Conferencia",
            "Exposicion principal",
            h2, a2, r2
        );

        Actividad ac3 = new Actividad(
            "Taller",
            "Taller de tecnologia",
            h3, a3, r3
        );

        // =====================================
        // EVENTOS
        // =====================================

        Evento e1 = new Evento(
            1, "Congreso de Informatica",
            "Academico",
            "Congreso universitario de tecnologia",
            "Programado"
        );

        Evento e2 = new Evento(
            2, "Feria Empresarial",
            "Comercial",
            "Exposicion de empresas",
            "Programado"
        );

        Evento e3 = new Evento(
            3, "Festival Cultural",
            "Cultural",
            "Presentaciones culturales",
            "Programado"
        );

        // Agregar actividades a cada evento

        e1.getLA().adiFinal(ac1);
        e1.getLA().adiFinal(ac2);

        e2.getLA().adiFinal(ac3);

        e3.getLA().adiFinal(ac1);
        e3.getLA().adiFinal(ac3);

        // =====================================
        // LISTA DOBLE DE EVENTOS PROGRAMADOS
        // =====================================

        G.getProgramados().adiFinal(e1);
        G.getProgramados().adiFinal(e2);
        G.getProgramados().adiFinal(e3);

        // =====================================
        // SOLICITUDES
        // =====================================

        Solicitud s1 = new Solicitud(
            101, "10/11/2026",
            "Universidad",
            e1, "Pendiente"
        );

        Solicitud s2 = new Solicitud(
            102, "11/11/2026",
            "Empresa ABC",
            e2, "Pendiente"
        );

        Solicitud s3 = new Solicitud(
            103, "12/11/2026",
            "Centro Cultural",
            e3, "Pendiente"
        );

        // Inicializar dos colas independientes

        G.getPendientes().llenar(2);

        G.getPendientes().adicionar(0, s1);
        G.getPendientes().adicionar(0, s2);
        G.getPendientes().adicionar(1, s3);

        // =====================================
        // HISTORIAL DE ACCIONES
        // =====================================

        Accion acA = new Accion(
            "Registro de evento", e1
        );

        Accion acB = new Accion(
            "Programacion de evento", e2
        );

        Accion acC = new Accion(
            "Modificacion de evento", e3
        );

        G.getHistorial().adi(acA);
        G.getHistorial().adi(acB);
        G.getHistorial().adi(acC);

        // =====================================
        // MOSTRAR ESTRUCTURAS
        // =====================================

        System.out.println("\n================================");
        System.out.println("       PRUEBA DEL SISTEMA");
        System.out.println("================================");

        System.out.println("\n1. RESPONSABLES");
        System.out.println("Cantidad: "
            + G.getResponsables().nroNodos());
        G.getResponsables().mostrar();

        System.out.println("\n2. AMBIENTES");
        System.out.println("Cantidad: "
            + G.getAmbientes().nroNodos());
        G.getAmbientes().mostrar();

        System.out.println("\n3. ACTIVIDADES DEL EVENTO 1");
        System.out.println("Cantidad: "
            + e1.getLA().nroNodos());
        e1.getLA().mostrar();

        System.out.println("\n4. EVENTOS PROGRAMADOS");
        System.out.println("Cantidad: "
            + G.getProgramados().nroNodos());
        G.getProgramados().mostrar();

        System.out.println("\n5. SOLICITUDES PENDIENTES");
        G.getPendientes().mostrar();

        System.out.println("\n6. HISTORIAL DE ACCIONES");
        System.out.println("Cantidad: "
            + G.getHistorial().nroElem());
        G.getHistorial().mostrar();

        System.out.println("\n7. GESTOR COMPLETO");
        G.mostrar();
    }
}

