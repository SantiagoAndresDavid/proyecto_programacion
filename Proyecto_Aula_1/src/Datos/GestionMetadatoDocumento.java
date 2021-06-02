package Datos;

import Clases.MetaDatoDocumento;
import Clases.Proceso;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;


public class GestionMetadatoDocumento implements IGestionDatos<MetaDatoDocumento, Integer> {
    private final Proceso proceso;

    public GestionMetadatoDocumento() {
        this.proceso = new Proceso();
    }

    @Override
    public void insertar(MetaDatoDocumento documento) throws ExcepcionAccesoDatos {
        if (documento == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (documento.getNombre() == null) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        proceso.agregarDocumento(documento);
    }

    @Override
    public void eliminar(Integer dato) throws ExcepcionAccesoDatos {
        MetaDatoDocumento encontrado = buscar(dato);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        proceso.eliminarDocumento(encontrado);
    }

    @Override
    public MetaDatoDocumento buscar(Integer codigo) throws ExcepcionAccesoDatos {
        for (MetaDatoDocumento documento : proceso.getListaDocumentos()) {
            if (documento.getCodigo() == codigo) {
                return documento;
            } else {
                System.out.println("El documento no se encuentra.");
            }
        }
        return null;
    }

    @Override
    public void actualizar(Integer codigo, MetaDatoDocumento nuevo) throws ExcepcionAccesoDatos {
        MetaDatoDocumento encontrado = buscar(codigo);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
        encontrado.setFechaCreada(nuevo.getFechaCreada());
        encontrado.setFechaIncorporada(nuevo.getFechaIncorporada());
        encontrado.setOrden(nuevo.getOrden());
        encontrado.setNumeroPaginas(nuevo.getNumeroPaginas());
        encontrado.setPagInicio(nuevo.getPagInicio());
        encontrado.setPagFinal(nuevo.getPagFinal());
        encontrado.setFormato(nuevo.getFormato());
        encontrado.setTamaño(nuevo.getTamaño());
        encontrado.setOrigen(nuevo.getOrigen());
        encontrado.setObservacion(nuevo.getObservacion());
    }
}