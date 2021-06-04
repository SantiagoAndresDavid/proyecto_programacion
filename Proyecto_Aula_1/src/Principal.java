
import Clases.*;
import Vista.InicioSesion;
import Vista.RegistrarDatos;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrarDatos registrarDatos = new RegistrarDatos();
        Proceso proceso = new Proceso();
        proceso.setMetadatosExpediente(registrarDatos.llenarExpediente());
        System.out.println("cuantos procesos desea ingresar");
        int cantidadDocumentos = scanner.nextInt();
        for (int i = 0; i < cantidadDocumentos ; i++) {
            System.out.println("Proceso N" + (i+1));
            System.out.println("-------------------------------------------------------------------------------------");
            proceso.getListaDocumentos().add(registrarDatos.llenarDocumento());
            System.out.println("-------------------------------------------------------------------------------------");
        }

        System.out.println("========================================================================================");
        System.out.println(proceso);
        for (MetaDatoDocumento documento: proceso.getListaDocumentos()) {
            System.out.println(documento);
        }
    }

}
