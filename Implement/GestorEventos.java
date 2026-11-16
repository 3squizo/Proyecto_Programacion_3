package Implement;


public class GestorEventos {
    private Mc_ColaSSoli pendientes;
    private LD_NormalEvent programados;
    private PilaAcc historial;
    private LS_CircularAmb ambientes;
    private LS_NormalResp responsables;

    public GestorEventos() {
        pendientes = new Mc_ColaSSoli();
        programados = new LD_NormalEvent();
        historial = new PilaAcc();
        ambientes = new LS_CircularAmb();
        responsables = new LS_NormalResp();
    }

    public void mostrar() {
        System.out.println("\n================================");
        System.out.println("       GESTOR DE EVENTOS");
        System.out.println("================================");

        System.out.println("\n--- SOLICITUDES PENDIENTES ---");
        pendientes.mostrar();

        System.out.println("\n--- EVENTOS PROGRAMADOS ---");
        programados.mostrar();

        System.out.println("\n--- HISTORIAL ---");
        historial.mostrar();

        System.out.println("\n--- AMBIENTES ---");
        ambientes.mostrar();

        System.out.println("\n--- RESPONSABLES ---");
        responsables.mostrar();
    }

    public Mc_ColaSSoli getPendientes() {
        return pendientes;
    }

    public void setPendientes(Mc_ColaSSoli pendientes) {
        this.pendientes = pendientes;
    }

    public LD_NormalEvent getProgramados() {
        return programados;
    }

    public void setProgramados(LD_NormalEvent programados) {
        this.programados = programados;
    }

    public PilaAcc getHistorial() {
        return historial;
    }

    public void setHistorial(PilaAcc historial) {
        this.historial = historial;
    }

    public LS_CircularAmb getAmbientes() {
        return ambientes;
    }

    public void setAmbientes(LS_CircularAmb ambientes) {
        this.ambientes = ambientes;
    }

    public LS_NormalResp getResponsables() {
        return responsables;
    }

    public void setResponsables(LS_NormalResp responsables) {
        this.responsables = responsables;
    }
}
