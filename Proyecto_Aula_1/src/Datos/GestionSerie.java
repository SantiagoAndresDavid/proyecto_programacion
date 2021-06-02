package Datos;


import Clases.Serie;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;


public class GestionSerie implements IGestionDatos<Serie, String> {
    private List<Serie> listserie;

    public List<Serie> getListserie() {
        return listserie;
    }

    public void setListserie(List<Serie> listserie) {
        this.listserie = listserie;
    }

    public GestionSerie() {
        this.listserie = new ArrayList<>();
    }

    @Override
    public void insertar(Serie dato) throws ExcepcionAccesoDatos {
        if (dato == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getDescripcion() == null) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene DESCRIPCION");
        }
        listserie.add(dato);
    }

    @Override
    public void eliminar(String descripcion) throws ExcepcionAccesoDatos {
        Serie encontrado = buscar(descripcion);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listserie.remove(encontrado);
    }

    public List<Serie> leer() throws ExcepcionAccesoDatos {
        return listserie;
    }

    @Override
    public Serie buscar(String descripcion) throws ExcepcionAccesoDatos {
        if (descripcion == null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");

        Serie encontrado = null;
        for (Serie seri : listserie) {
            if (seri.getDescripcion().equals(descripcion)) {
                encontrado = seri;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(String descripcion, Serie nuevo) throws ExcepcionAccesoDatos {
        Serie encontrado = buscar(descripcion);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setDescripcion(nuevo.getDescripcion());
        encontrado.setListaSubserie(nuevo.getListaSubserie());
    }

}