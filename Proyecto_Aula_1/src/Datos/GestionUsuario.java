
package Datos;

import Clases.Usuario;
import Excepciones.ExcepcionAccesoDatos;

import java.util.ArrayList;
import java.util.List;


public class GestionUsuario implements IGestionUsuario {

    private List<Usuario> listUsuario;

    public GestionUsuario() {
        this.listUsuario = new ArrayList<>();
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }



    public void insertar(Usuario dato)  {
        listUsuario.add(dato);
    }



}
