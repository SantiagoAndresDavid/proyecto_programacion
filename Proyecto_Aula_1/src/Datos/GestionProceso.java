
package Datos;

import Clases.MetaDatoDocumento;
import Clases.MetaDatoExpediente;
import Clases.Proceso;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;

public class GestionProceso implements IGestionDatos<Proceso, Integer> {
    private List<Proceso> listaProcesos;

    public List<Proceso> getListproc() {
        return listaProcesos;
    }

    public void setListproc(List<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public GestionProceso() {
        this.listaProcesos = new ArrayList<>();
    }

    @Override
    public void insertar(Proceso proceso) throws ExcepcionAccesoDatos {
        if (proceso == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (proceso.getMetadatosExpediente().getCodigo() == 0) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene CODIGO");
        }
        listaProcesos.add(proceso);
    }

    @Override
    public void eliminar(Integer codigo) throws ExcepcionAccesoDatos {
        Proceso encontrado = buscar(codigo);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listaProcesos.remove(encontrado);
    }

    public List<Proceso> leer() throws ExcepcionAccesoDatos {
        return listaProcesos;
    }

    @Override
    public Proceso buscar(Integer codigo) throws ExcepcionAccesoDatos {
        if (codigo == null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");

        for (Proceso prc : listaProcesos) {
            for (MetaDatoDocumento documento : prc.getListaDocumentos()) {
                if (documento.getCodigo() == codigo) {
                    return prc;
                }
            }
        }
        return null;
    }

    @Override
    public void actualizar(Integer codigo, Proceso nuevo) throws ExcepcionAccesoDatos {
        Proceso encontrado = buscar(codigo);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setMetadatosExpediente(nuevo.getMetadatosExpediente());
        encontrado.setListaDocumentos(nuevo.getListaDocumentos());
    }
}
