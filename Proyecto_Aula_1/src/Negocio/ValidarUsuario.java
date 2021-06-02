
package Negocio;

import Clases.Usuario;


public class ValidarUsuario {

    public static Usuario validar(String user, String pass) {
        String usuario = "santiago";
        String contraseña = "1234";

        if (usuario.equals(user) && contraseña.equals(pass)) {
            System.out.println("SESION INICIADA");
            return new Usuario(usuario,contraseña,"Administrador");
        } else {
            System.out.println("USUARIO O CONTRASEÑA ERRONEAS");
        }
        return null;
    }

}
