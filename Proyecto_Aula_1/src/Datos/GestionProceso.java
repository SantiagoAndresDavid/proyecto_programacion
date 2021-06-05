
package Datos;

import Clases.MetaDatoDocumento;
import Clases.ParteProcesal;
import Clases.Proceso;
import Excepciones.ExcepcionAccesoDatos;
import Negocio.CrudProceso;
import Vista.RegistrarDatos;


import java.util.ArrayList;
import java.util.List;


public class GestionProceso implements IGestionProceso {
    private List<Proceso> listaProcesos;

    public GestionProceso() {
        this.listaProcesos = new ArrayList<>();
    }

    public List<Proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(List<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    @Override
    public void insertarProcesos() {
        Proceso proceso = new Proceso();
        RegistrarDatos registrarDatos = new RegistrarDatos();
        proceso.setMetadatosExpediente(registrarDatos.llenarExpediente());
        proceso.getListaDocumentos().add(registrarDatos.llenarDocumento());
        listaProcesos.add(proceso);
    }

   @Override
    public Proceso buscarPorRadicado(int radicado) {
        for (Proceso proceso : listaProcesos) {
            if (proceso.getMetadatosExpediente().getNumeroRadicacion() == radicado) {
                return proceso;
            }
        }
        return null;
    }

    @Override
    public Proceso buscarPorDemandado(String nombre) {
        for (Proceso proceso : listaProcesos) {
            for (ParteProcesal parteProcesal : proceso.getMetadatosExpediente().getListaDemandado()) {
                if (parteProcesal.getNombre().equals(nombre)) {
                    return proceso;
                }
            }
        }
        return null;
    }

    @Override
    public Proceso buscarPorDemandante(String nombre) {
        for (Proceso proceso : listaProcesos) {
            for (ParteProcesal parteProcesal : proceso.getMetadatosExpediente().getListaDemandantes()) {
                if (parteProcesal.getNombre().equals(nombre)) {
                    return proceso;
                }
            }
        }
        return null;
    }

    @Override
    public void eliminarDocumento(int codigo) {
        for (Proceso proceso : listaProcesos) {
            List<MetaDatoDocumento> listaDocumentos = proceso.getListaDocumentos();
            for (MetaDatoDocumento documento : listaDocumentos) {
                if (documento.getCodigo() == codigo) {
                    listaDocumentos.remove(documento);
                    System.out.println("el documento fue borrado exitosamente");
                    return;
                }
            }
        }
    }


}
