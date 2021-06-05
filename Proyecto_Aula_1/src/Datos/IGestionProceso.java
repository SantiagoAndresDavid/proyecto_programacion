package Datos;

import Clases.Proceso;

import java.util.List;

public interface IGestionProceso {
     void insertarProcesos();
     Proceso buscarPorRadicado(int radicado);
     Proceso buscarPorDemandante(String nombre);
     Proceso buscarPorDemandado(String nombre);
     void eliminarDocumento(int codigo);




}
