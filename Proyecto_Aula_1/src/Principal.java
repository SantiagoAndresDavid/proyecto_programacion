
import Clases.*;
import Datos.GestionProceso;
import Negocio.CrudProceso;
import Vista.InicioSesion;
import Vista.MenuPrincipal;
import Vista.RegistrarDatos;
import Vista.VistaCrud;


import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
       //new InicioSesion().ejecutarInicio();
        CrudProceso crudProceso = CrudProceso.getInstance();
        GestionProceso gestionProceso = new GestionProceso();
        VistaCrud vistaCrud = new VistaCrud();
        gestionProceso.insertarProcesos();
        System.out.println("buscar Por radicado");
        System.out.println("=========================================================================================");
        vistaCrud.imprmirProceso(gestionProceso.buscarPorRadicado(1234));

    }

}
