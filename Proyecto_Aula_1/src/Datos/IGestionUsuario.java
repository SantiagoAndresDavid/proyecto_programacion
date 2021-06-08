package Datos;

import Clases.Usuario;

public interface IGestionUsuario {
     void insertar(Usuario dato);
     void eliminar(String dato);
     Usuario buscar(String dato);
}
