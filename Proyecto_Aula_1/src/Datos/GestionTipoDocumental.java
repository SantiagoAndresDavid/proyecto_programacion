
package Datos;

import Clases.TipoDocumental;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;


public class GestionTipoDocumental implements IGestionDatos<TipoDocumental, String> {
    private List<TipoDocumental> listTipoD;

    public GestionTipoDocumental() {
        this.listTipoD = new ArrayList<>();
    }

    public List<TipoDocumental> getListTipoD() {
        return listTipoD;
    }

    public void setListTipoD(List<TipoDocumental> listTipoD) {
        this.listTipoD = listTipoD;
    }

    @Override
    public void insertar(TipoDocumental dato) throws ExcepcionAccesoDatos {
        if (dato == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getDescripcion() == null) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene DESCRIPCION");
        }
        listTipoD.add(dato);
    }

    @Override
    public void eliminar(String descripcion) throws ExcepcionAccesoDatos {
        TipoDocumental encontrado = buscar(descripcion);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listTipoD.remove(encontrado);
    }

    public List<TipoDocumental> leer() throws ExcepcionAccesoDatos {
        return listTipoD;
    }

    @Override
    public TipoDocumental buscar(String descripcion) throws ExcepcionAccesoDatos {
        if (descripcion == null)
            throw new ExcepcionAccesoDatos("La DESCRIPCION a buscar es de tipo NULL");

        TipoDocumental encontrado = null;
        for (TipoDocumental tipoD : listTipoD) {
            if (tipoD.getDescripcion().equals(descripcion)) {
                encontrado = tipoD;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(String descripcion, TipoDocumental nuevo) throws ExcepcionAccesoDatos {
        TipoDocumental encontrado = buscar(descripcion);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setDescripcion(nuevo.getDescripcion());
    }

}
