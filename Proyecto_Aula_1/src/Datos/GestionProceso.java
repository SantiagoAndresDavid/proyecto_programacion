
package Datos;

import Clases.MetaDatoDocumento;
import Clases.ParteProcesal;
import Clases.Proceso;
import Excepciones.ExcepcionAccesoDatos;
import Negocio.CrudProceso;
import Vista.RegistrarDatos;
import Vista.VistaCrud;


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
        VistaCrud vistaCrud = new VistaCrud();
        RegistrarDatos registrarDatos = new RegistrarDatos();
        proceso.setMetadatosExpediente(registrarDatos.llenarExpediente());
        int numeroProcesos = vistaCrud.numeroDocumentos();
        for (int i = 0; i < numeroProcesos ; i++) {
            proceso.getListaDocumentos().add(registrarDatos.llenarDocumento());
        }

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
                    return;
                }
            }
        }
    }

    @Override
    public void eliminarProceso(int radicado) {
        for (Proceso proceso : listaProcesos) {
          if(proceso.getMetadatosExpediente().getNumeroRadicacion() == radicado){
                listaProcesos.remove(proceso);
                return;
            }
        }
    }


}
