
package Datos;

import Clases.MetaDatoDocumento;
import Excepciones.ExcepcionAccesoDatos;

import java.util.List;


public interface IGestionDatos<T, K> {
    void insertar(T documento) throws ExcepcionAccesoDatos;

    void eliminar(K dato) throws ExcepcionAccesoDatos;

    T buscar(K dato) throws ExcepcionAccesoDatos;

    void actualizar(K dato, T documento) throws ExcepcionAccesoDatos;
}
