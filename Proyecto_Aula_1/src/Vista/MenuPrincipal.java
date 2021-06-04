package Vista;


import Clases.MetaDatoDocumento;
import Clases.Proceso;
import Clases.Usuario;
import Datos.GestionProceso;
import Negocio.CrudProceso;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner scanner = new Scanner(System.in);

    private final Usuario usuario;


    public MenuPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    public void ejecutarMenuPrincipal() {
        String rol = usuario.getRol();
        while (true) {
            switch (rol) {
                case "Administrador":
                    imprimirMenuAdministrador();
                    ejecutarMenuAdministrador();
                    break;
                case "Coordinador":
                    imprimirMenuCoordinador();
                    ejecutarMenuCoordinador();
                    break;
                case "Invitado":
                    imprimirMenuInvitado();
                    ejecutarMenuInvitado();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }
    }

    public void ejecutarMenuAdministrador() {
        int opcion;
        do {
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    ejecutarConsulta();
                    break;
                case 2:
                    ejecutarMenuInsertarProcesos();
                    break;
                case 3:
                    ejecutarPanelDeAdministrador();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }

    public void ejecutarMenuCoordinador() {
        int opcion;
        do {
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    ejecutarConsulta();
                    break;
                case 2:
                    ejecutarMenuInsertarProcesos();
                    break;
                case 3:
                    ejecutarMenuPrincipal();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }

    public void ejecutarMenuInvitado() {
        int opcion;
        do {
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    ejecutarConsulta();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }


    public void ejecutarMenuInsertarProcesos() {
        int opcion;
        do {
            imprimirMenuInsertarProcesos();
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:

                    break;
                case 2:
                    ejecutarMenuPrincipal();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }

    public void ejecutarConsulta() {
        int opcion;
        do {
            imprimirMenuPanelConsulta();
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    consultaRadicado();
                    break;
                case 2:
                    consultaDemandante();
                    break;
                case 3:
                    consultaDemandado();
                    break;
                case 4:
                    ejecutarMenuPrincipal();
                    break;
                case 0:

                    break;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }

    public void ejecutarPanelDeAdministrador() {
        int opcion;
        do {
            imprimirMenuPanelAdministracion();
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    eliminarDocumento();
                    break;
                case 2:

                    break;
                case 3:
                    ejecutarMenuPrincipal();
                    break;
                case 0:

                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }

    public void consultaRadicado() {
        CrudProceso consultar = new CrudProceso();
        System.out.println("ingrese el radicado que desea consultar");
        int codigo = scanner.nextInt();
        Proceso encontrado = consultar.buscarPorCodigo(codigo);
        if (encontrado == null) {
            System.out.println("el documeto no se encuentra");
        } else {

        }
    }


    public void consultaDemandante() {
        CrudProceso consultar = new CrudProceso();
        System.out.println("ingrese el nombre del demandante que desea consultar");
        String nombreDemandante = scanner.nextLine();
        Proceso encontrado = consultar.buscarPorDemandante(nombreDemandante);
        if (encontrado == null) {
            System.out.println("el documeto no se encuentra");
        } else {

        }
    }

    public void consultaDemandado() {
        CrudProceso consultar = new CrudProceso();
        System.out.println("ingrese el nombre del demandado que desea consultar");
        String nombreDemandado = scanner.nextLine();
        Proceso encontrado = consultar.buscarPorDemandante(nombreDemandado);
        if (encontrado == null) {
            System.out.println("el documeto no se encuentra");
        } else {

        }
    }

    public void eliminarDocumento() {
        CrudProceso eliminar = new CrudProceso();
        System.out.println("ingrese el codigo del documento que desea borrar");
        int codigo = scanner.nextInt();
        eliminar.borrarDocumento(codigo);
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
        System.out.println("\t4. atras");
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


    public int escojerOpciones() {
        boolean exepcion = true;
        do {
            try {
                System.out.println("\nSelecione una opcion: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                exepcion = false;
                return opcion;
            } catch (InputMismatchException error) {
                System.out.println("opcion no valida");
                exepcion = true;
                scanner.nextLine();
            }
        } while (exepcion);
        return 0;
    }
}

