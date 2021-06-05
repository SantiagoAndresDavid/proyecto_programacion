package Vista;

public class ImprimirMenus {
    public ImprimirMenus() {
    }

    public void imprimirMenu() {
        System.out.println("---------------------------- INICIO DE SESION ----------------------------");
        System.out.println("\t1. Iniciar Sesion");
        System.out.println("\t2. Registrar Usuario");
        System.out.println("\t3. ingresar como invitado");

    }


    public void imprimirMenuAdministrador() {
        System.out.println("---------------------------- MENU PRINCIPAL ----------------------------");
        System.out.println("\t1. Panel de consulta");
        System.out.println("\t2. Incertar procesos");
        System.out.println("\t3. panel de administracion");
        System.out.println("\n0. Salir");
    }

    public void imprimirMenuCoordinador() {
        System.out.println("---------------------------- MENU PRINCIPAL ----------------------------");
        System.out.println("\t1. Panel de consulta");
        System.out.println("\t2. Incertar procesos");
        System.out.println("\n0. Salir");
    }

    public void imprimirMenuInvitado() {
        System.out.println("---------------------------- MENU PRINCIPAL ----------------------------");
        System.out.println("\t1. Panel de consulta");
        System.out.println("\n0. Salir");
    }


    public void imprimirMenuPanelConsulta() {
        System.out.println("---------------------------- MENU DE CONSULTA ----------------------------");
        System.out.println("\t1. consultar por radicado");
        System.out.println("\t2. consultar por demandante");
        System.out.println("\t3. consultar por demandado");
        System.out.println("\t4. imprimir esa caga ");
        System.out.println("\t5. atras");
        System.out.println("\n0. Salir");
    }


    public void imprimirMenuInsertarProcesos() {
        System.out.println("---------------------------- MENU INSERTAR PROCESOS ----------------------------");
        System.out.println("\t1. Agregar un proceso");
        System.out.println("\t2. Atras");
        System.out.println("\n0. Salir");
    }

    public void impirimirMenuPanelControl() {
        System.out.println("---------------------------- MENU PANEL DE CONTROL ----------------------------");
        System.out.println("\t1. Insertar Expediente");
        System.out.println("\t2. consultar por demandante");
        System.out.println("\t3. consultar por demandado");
        System.out.println("\n0. Salir");
    }

    public void imprimirMenuPanelAdministracion() {
        System.out.println("---------------------------- MENU PANEL DE CONTROL ----------------------------");
        System.out.println("\t1. eliminar documento");
        System.out.println("\t2. modificar documento");
        System.out.println("\t3. atras");
        System.out.println("\t0. salir");
    }

}
