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



    public CrudProceso() {
        this.gestionProceso = new GestionProceso();
        this.datos = new GestionProceso();
    }

    public void insertarProceso(){
        datos.insertarProcesos();
    }

    public Proceso buscarPorRadicado(int radicado){
        return datos.buscarPorRadicado(radicado);
    }

    public Proceso buscarPorDemandante(String nombre){
        return datos.buscarPorDemandante(nombre);
    }

    public Proceso buscarPorDemandado(String nombre){
        return datos.buscarPorDemandado(nombre);
    }

    public void elimiarDocumento(int codigo){
        datos.eliminarDocumento(codigo);
    }

    public void eliminarProceso(int radicado){
        datos.eliminarProceso(radicado);
    }
}

