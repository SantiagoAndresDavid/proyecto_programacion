
package Datos;

import Clases.DespachoJudicial;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;


public class GestionDespachoJudicial implements IGestionDatos<DespachoJudicial, String> {
    private List<DespachoJudicial> listDespaJ;

    public List<DespachoJudicial> getListDespaJ() {
        return listDespaJ;
    }

    public void setListDespaJ(List<DespachoJudicial> listDespaJ) {
        this.listDespaJ = listDespaJ;
    }

    public GestionDespachoJudicial() {
        this.listDespaJ = new ArrayList<>();
    }

    @Override
    public void insertar(DespachoJudicial dato) throws ExcepcionAccesoDatos {
        if (dato == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listDespaJ.add(dato);
    }

    @Override
    public void eliminar(String nombre) throws ExcepcionAccesoDatos {
        DespachoJudicial encontrado = buscar(nombre);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listDespaJ.remove(encontrado);
    }

    public List<DespachoJudicial> leer() throws ExcepcionAccesoDatos {
        return listDespaJ;
    }

    @Override
    public DespachoJudicial buscar(String nombre) throws ExcepcionAccesoDatos {
        if (nombre == null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");

        DespachoJudicial encontrado = null;
        for (DespachoJudicial des : listDespaJ) {
            if (des.getNombre().equals(nombre)) {
                encontrado = des;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(String nombre, DespachoJudicial nuevo) throws ExcepcionAccesoDatos {
        DespachoJudicial encontrado = buscar(nombre);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
        encontrado.setDepartamento(nuevo.getDepartamento());
        encontrado.setCiudad(nuevo.getCiudad());
        encontrado.setCategoria(nuevo.getCategoria());
    }

}
