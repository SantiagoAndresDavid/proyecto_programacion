
package Datos;

import Clases.Cuaderno;
import Datos.IGestionDatos;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;

public class GestionCuaderno implements IGestionDatos<Cuaderno, Integer> {
    private List<Cuaderno> listCuad;

    public List<Cuaderno> getListCuad() {
        return listCuad;
    }

    public void setListCuad(List<Cuaderno> listCuad) {
        this.listCuad = listCuad;
    }

    public GestionCuaderno() {
        this.listCuad = new ArrayList<>();
    }

    @Override
    public void insertar(Cuaderno dato) throws ExcepcionAccesoDatos {
        if (dato == null) {
            throw new ExcepcionAccesoDatos("El objeto a insertar es de tipo NULL");
        }
        if (dato.getNumeroCuadernos() == 0) {
            throw new ExcepcionAccesoDatos("El Objeto a insertar no tiene CUADERNOS");
        }
        listCuad.add(dato);
    }

    @Override
    public void eliminar(Integer codigo) throws ExcepcionAccesoDatos {
        Cuaderno encontrado = buscar(codigo);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a eliminar es de tipo NULL");
        }
        listCuad.remove(encontrado);
    }

    public List<Cuaderno> leer() throws ExcepcionAccesoDatos {
        return listCuad;
    }

    @Override
    public Cuaderno buscar(Integer codigo) throws ExcepcionAccesoDatos {
        if (codigo == null)
            throw new ExcepcionAccesoDatos("El objeto a buscar es de tipo NULL");
        if (codigo == 0)
            throw new ExcepcionAccesoDatos("El CUADERNO a buscar es de tipo NULL");

        Cuaderno encontrado = null;
        for (Cuaderno cua : listCuad) {
            if (cua.getCodigo() == codigo) {
                encontrado = cua;
                break;
            }
        }
        return encontrado;
    }

    @Override
    public void actualizar(Integer codigo, Cuaderno nuevo) throws ExcepcionAccesoDatos {
        Cuaderno encontrado = buscar(codigo);
        if (encontrado == null) {
            throw new ExcepcionAccesoDatos("El objeto a actualizar es de tipo NULL");
        }
        encontrado.setNumeroCuadernos(nuevo.getNumeroCuadernos());
        encontrado.setDescripcion(nuevo.getDescripcion());
    }

}
