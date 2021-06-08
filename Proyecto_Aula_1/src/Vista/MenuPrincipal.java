package Vista;


import Clases.MetaDatoDocumento;
import Clases.Proceso;
import Clases.Usuario;
import Datos.GestionProceso;
import Negocio.CrudProceso;

import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;

public class MenuPrincipal {
    private static Scanner scanner = new Scanner(System.in);
    private  Usuario usuario;
    CrudProceso crudProceso = new CrudProceso();
    public MenuPrincipal() {
    }

    public MenuPrincipal(Usuario usuario) {
        this.usuario = usuario;
    }

    public void ejecutarMenuPrincipal() {
        ImprimirMenus imprimirMenus = new ImprimirMenus();
        String rol = usuario.getRol();
        while (true) {
            switch (rol) {
                case "Administrador":
                    imprimirMenus.imprimirMenuAdministrador();
                    ejecutarMenuAdministrador();
                    break;
                case "Coordinador":
                    imprimirMenus.imprimirMenuCoordinador();
                    ejecutarMenuCoordinador();
                    break;
                case "Invitado":
                    imprimirMenus.imprimirMenuInvitado();
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
        ImprimirMenus imprimirMenus = new ImprimirMenus();
        int opcion;
        do {
            imprimirMenus.imprimirMenuInsertarProcesos();
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    crudProceso.insertarProceso();
                    break;
                case 2:
                    ejecutarMenuPrincipal();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }

    public void ejecutarConsulta() {
        ImprimirMenus imprimirMenus = new ImprimirMenus();
        VistaCrud vistaCrud = new VistaCrud();
        int opcion;
        do {
            imprimirMenus.imprimirMenuPanelConsulta();
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    int pedirRadicado = vistaCrud.pediRadicado();
                    vistaCrud.imprmirProceso(crudProceso.buscarPorRadicado(pedirRadicado));
                    break;
                case 2:
                    String demandante = vistaCrud.pedirNombre();
                    vistaCrud.imprmirProceso(crudProceso.buscarPorDemandante(demandante));
                    break;
                case 3:
                    String demandado = vistaCrud.pedirNombre();
                    vistaCrud.imprmirProceso(crudProceso.buscarPorDemandado(demandado));
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
        ImprimirMenus imprimirMenus = new ImprimirMenus();
        VistaCrud vistaCrud = new VistaCrud();
        int opcion;
        do {
            imprimirMenus.imprimirMenuPanelAdministracion();
            opcion = escojerOpciones();
            switch (opcion) {
                case 1:
                    int codigo = vistaCrud.pedirCodigoCuaderno();
                    crudProceso.eliminarProceso(codigo);
                    break;
                case 2:
                    int radicado = vistaCrud.pediRadicado();
                    crudProceso.eliminarProceso(radicado);
                    break;
                case 3:

                    break;
                case 4:
                    ejecutarMenuPrincipal();
                    break;
                case 0:

                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 0);
    }



    public Proceso llenarProceso(){
        Proceso proceso = new Proceso();
        RegistrarDatos registrarDatos = new RegistrarDatos();
        proceso.setMetadatosExpediente(registrarDatos.llenarExpediente());
        System.out.println("cuantos procesos desea ingresar");
        int cantidadDocumentos = scanner.nextInt();
        for (int i = 0; i < cantidadDocumentos ; i++) {
            System.out.println("Proceso N" + (i+1));
            System.out.println("-------------------------------------------------------------------------------------");
            proceso.getListaDocumentos().add(registrarDatos.llenarDocumento());
            System.out.println("-------------------------------------------------------------------------------------");
        }

        return proceso;
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

