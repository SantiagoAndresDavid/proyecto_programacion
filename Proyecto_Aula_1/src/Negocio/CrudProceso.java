package Negocio;

import Clases.Proceso;
import Datos.GestionProceso;
import Datos.IGestionProceso;
import Vista.RegistrarDatos;

import java.util.List;
import java.util.Scanner;

public class CrudProceso {
    Scanner scanner = new Scanner(System.in);
    private GestionProceso gestionProceso;
    private IGestionProceso datos;
    private final static CrudProceso instance = new CrudProceso();

    public static CrudProceso getInstance() {
        return instance;
    }

    private CrudProceso() {
        this.gestionProceso = new GestionProceso();
        this.datos = new GestionProceso();
    }

   /* public Proceso registarProceso(){
        Proceso proceso = new Proceso();
        RegistrarDatos registrarDatos = new RegistrarDatos();
        proceso.setMetadatosExpediente(registrarDatos.llenarExpediente());
        proceso.getListaDocumentos().add(registrarDatos.llenarDocumento());
        return proceso;
    }*/

    public Proceso BuscarPorRadicado(int radicado){
        return datos.buscarPorRadicado(radicado);
    }



}

