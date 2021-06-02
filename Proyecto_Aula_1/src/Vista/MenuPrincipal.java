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
                    new RegistrarDatos().llenarDocumento();
                    break;
                case 2:
                    new RegistrarDatos().llenarExpediente();
                    break;
                case 3:
                    ejecutarMenuPrincipal();
                    break;
                case 4:
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
            imprimirDocumento(encontrado);
            imprimirExpediente(encontrado);
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
            imprimirDocumento(encontrado);
            imprimirExpediente(encontrado);
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
            imprimirDocumento(encontrado);
            imprimirExpediente(encontrado);
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
        System.out.println("\t1. Insertar Expediente");
        System.out.println("\t2. Insertar Documento");
        System.out.println("\t3. Atras");
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

    public void imprimirDocumento(Proceso encontrado) {
        System.out.println("----------------------------  DOCUMENTO ---------------------------- ");
        for (MetaDatoDocumento metadatoDocumento : encontrado.getListaDocumentos()) {
            System.out.println("codigo:" + metadatoDocumento.getCodigo());
            System.out.println("Nombre:" + metadatoDocumento.getNombre());
            System.out.println("Fecha creada:" + metadatoDocumento.getFechaCreada());
            System.out.println("Fecha incorporada:" + metadatoDocumento.getFechaIncorporada());
            System.out.println("Orden:" + metadatoDocumento.getOrden());
            System.out.println("Numero de paginas:" + metadatoDocumento.getNumeroPaginas());
            System.out.println("Pagina de inicio:" + metadatoDocumento.getPagInicio());
            System.out.println("Pagina final:" + metadatoDocumento.getPagFinal());
            System.out.println("Formato:" + metadatoDocumento.getFormato());
            System.out.println("Tamaño:" + metadatoDocumento.getTamaño());
            System.out.println("Origen:" + metadatoDocumento.getOrigen());
            System.out.println("Observaciones:" + metadatoDocumento.getObservacion());
        }
    }

    public void imprimirExpediente(Proceso encontrado) {
        System.out.println("----------------------------  EXPEDIENTE  ---------------------------- ");
        System.out.println("Codigo:" + encontrado.getMetadatosExpediente().getCodigo());
        System.out.println("Departamento:" + encontrado.getMetadatosExpediente().getDepartamento());
        System.out.println("Ciudad: " + encontrado.getMetadatosExpediente().getCiudad());
        System.out.println("Despacho Judicial" + encontrado.getMetadatosExpediente().getDespachoJudicial());
        System.out.println("serie: " + encontrado.getMetadatosExpediente().getSerie());
        System.out.println("subSerie:" + encontrado.getMetadatosExpediente().getSubserie());
        System.out.println("Numero de radicacion:" + encontrado.getMetadatosExpediente().getNumeroRadicacion());
        System.out.println("Parte Procesal:" + encontrado.getMetadatosExpediente().getListaDemandado());
        System.out.println("Parte Procesal:" + encontrado.getMetadatosExpediente().getListaDemandantes());
        System.out.println("Cuadernos" + encontrado.getMetadatosExpediente().getListaCuaderno());
        System.out.println("Expediente Fisico:" + encontrado.getMetadatosExpediente().getExpedienteFisico());
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

