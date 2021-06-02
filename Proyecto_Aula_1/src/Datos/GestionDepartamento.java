
package Datos;

import Clases.Departamento;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;


public class GestionDepartamento implements IGestionDatos<Departamento, String> {
    private List<Departamento> listDepartamento;

    public List<Departamento> getListDepartamento() {
        return listDepartamento;
    }

    public void setListDepartamento(List<Departamento> listDepartamento) {
        this.listDepartamento = listDepartamento;
    }

    public GestionDepartamento() {
        this.listDepartamento = new ArrayList<>();
    }

    @Override
    public void insertar(Departamento dato) throws ExcepcionAccesoDatos {
        if (dato == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNombre() == null) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene NOMBRE");
        }
        listDepartamento.add(dato);
    }

    @Override
    public void eliminar(String nombre) throws ExcepcionAccesoDatos {
        Departamento encontrado = buscar(nombre);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listDepartamento.remove(encontrado);
    }

    public List<Departamento> leer() throws ExcepcionAccesoDatos {
        return listDepartamento;
    }

    @Override
    public Departamento buscar(String nombre) throws ExcepcionAccesoDatos {
        if (nombre == null)
            throw new ExcepcionAccesoDatos("El NOMBRE a buscar es de tipo NULL");

        Departamento encontrado = null;
        for (Departamento dep : listDepartamento) {
            if (dep.getNombre().equals(nombre)) {
                encontrado = dep;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(String nombre, Departamento nuevo) throws ExcepcionAccesoDatos {
        Departamento encontrado = buscar(nombre);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNombre(nuevo.getNombre());
    }

}
