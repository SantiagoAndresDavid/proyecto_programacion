package Vista;

import Clases.MetaDatoDocumento;
import Clases.Proceso;
import Negocio.CrudProceso;

import java.util.Scanner;

public class VistaCrud {
    Scanner scanner = new Scanner(System.in);

        /*public void consultaRadicado() {
        CrudProceso consultar = new CrudProceso();
        System.out.println("ingrese el radicado que desea consultar");
        int codigo = scanner.nextInt();
        Proceso encontrado =
        if (encontrado == null) {
            System.out.println("el documeto no se encuentra");
        } else {

        }
    }


   /* public void consultaDemandante() {
        CrudProceso consultar = new CrudProceso();
        System.out.println("ingrese el nombre del demandante que desea consultar");
        String nombreDemandante = scanner.nextLine();
        Proceso encontrado = consultar.buscarPorDemandante(nombreDemandante);
        if (encontrado == null) {
            System.out.println("el documeto no se encuentra");
        } else {

        }
    }*/

    /*public void consultaDemandado() {
        CrudProceso consultar = new CrudProceso();
        System.out.println("ingrese el nombre del demandado que desea consultar");
        String nombreDemandado = scanner.nextLine();
        Proceso encontrado = consultar.buscarPorDemandante(nombreDemandado);
        if (encontrado == null) {
            System.out.println("el documeto no se encuentra");
        } else {

        }
    }*/




   /* public void eliminarDocumento() {
        CrudProceso eliminar = new CrudProceso();
        System.out.println("ingrese el codigo del documento que desea borrar");
        int codigo = scanner.nextInt();

    }*/

    /*public Proceso llenarProceso(){
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
    } */

    public int pedirDocumentos(){
        System.out.println("cuantos procesos desea ingresar");
        int cantidadDocumentos = scanner.nextInt();
        return cantidadDocumentos;
    }

    public void imprmirProceso(Proceso proceso){
        System.out.println(proceso.getMetadatosExpediente());
        for (MetaDatoDocumento metadatoDocumento: proceso.getListaDocumentos()) {
            System.out.println(metadatoDocumento);
        }
    }


}
