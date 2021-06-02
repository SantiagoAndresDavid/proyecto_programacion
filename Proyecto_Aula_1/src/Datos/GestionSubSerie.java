package Datos;


import Clases.Subserie;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;


public class GestionSubSerie implements IGestionDatos<Subserie, String> {
    private List<Subserie> listSubs;

    public List<Subserie> getListSubs() {
        return listSubs;
    }

    public void setListSubs(List<Subserie> listSubs) {
        this.listSubs = listSubs;
    }

    public GestionSubSerie() {
        this.listSubs = new ArrayList<>();
    }

    @Override
    public void insertar(Subserie dato) throws ExcepcionAccesoDatos {
        if (dato == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getDescripcion() == null) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene DESCRIPCION");
        }
        listSubs.add(dato);
    }

    @Override
    public void eliminar(String descripcion) throws ExcepcionAccesoDatos {
        Subserie encontrado = buscar(descripcion);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listSubs.remove(encontrado);
    }

    public List<Subserie> leer() throws ExcepcionAccesoDatos {
        return listSubs;
    }

    @Override
    public Subserie buscar(String descripcion) throws ExcepcionAccesoDatos {
        if (descripcion == null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");

        Subserie encontrado = null;
        for (Subserie sub : listSubs) {
            if (sub.getDescripcion().equals(descripcion)) {
                encontrado = sub;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(String descripcion, Subserie nuevo) throws ExcepcionAccesoDatos {
        Subserie encontrado = buscar(descripcion);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setDescripcion(nuevo.getDescripcion());
        encontrado.setListaTipoDocumental(nuevo.getListaTipoDocumental());
    }

}