package Vista;

import Clases.Usuario;
import Datos.GestionUsuario;
import Excepciones.ExcepcionAccesoDatos;
import Negocio.ValidarUsuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InicioSesion {
    private static Scanner scanner = new Scanner(System.in);
    private Usuario usuario;
    private GestionUsuario gestionUsuario;


    public InicioSesion() {
        this.usuario = new Usuario();
        this.gestionUsuario = new GestionUsuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void ejecutarInicio() {
        int opcion;
        imprimirMenu();
        opcion = escojerOpciones();
        switch (opcion) {
            case 1:
                iniciarSesion();
                MenuPrincipal iniciarSession = new MenuPrincipal(usuario);
                iniciarSession.ejecutarMenuPrincipal();
                break;
            case 2:
                crearUsuario();
                MenuPrincipal registrar = new MenuPrincipal(usuario);
                registrar.ejecutarMenuPrincipal();
                break;
            case 3:
                ingresarInvitado();
                MenuPrincipal inivitado = new MenuPrincipal(usuario);
                inivitado.ejecutarMenuPrincipal();
                break;
            default:
                System.out.println("opcion invalida");
        }
    }

    public void imprimirMenu() {
        System.out.println("---------------------------- INICIO DE SESION ----------------------------");
        System.out.println("\t1. Iniciar Sesion");
        System.out.println("\t2. Registrar Usuario");
        System.out.println("\t3. ingresar como invitado");

    }

    public void iniciarSesion() {
        String user;
        String pass;
        System.out.println("---------------------------- BIENVENIDO USUARIO ---------------------------- ");
        do {
            System.out.println("ingrese su usuario:");
            user = scanner.nextLine();
            System.out.println("ingrese una contraseña:");
            pass = scanner.nextLine();
            this.usuario = ValidarUsuario.validar(user,pass);
        } while (this.usuario == null);

    }

    public void crearUsuario() {
        System.out.println("----------------------- BIENVENIDO REGISTRE UN USUARIO -----------------------");
        System.out.println("ingrese un usuario");
        usuario.setNombre(scanner.nextLine());
        System.out.println("ingrese una contraseña");
        usuario.setContraseña(scanner.nextLine());
        System.out.println("ingrese el tipo de usuario");
        System.out.println("1.Administrador");
        System.out.println("2.Coordinador");
        System.out.println("3.Invitado");
        int tipo = scanner.nextInt();

        switch (tipo) {
            case 1:
                usuario.setRol("Administrador");
                break;
            case 2:
                usuario.setRol("Coordinador");
                break;
            case 3:
                usuario.setRol("Invitado");
            default:
                System.out.println("el tipo de usuario no concuerda");
        }

        try {
            gestionUsuario.insertar(usuario);
        } catch (ExcepcionAccesoDatos excepcionAccesoDatos) {
            excepcionAccesoDatos.getMessage();
        }
    }

    public void ingresarInvitado() {
        usuario.setRol("Invitado");


    }

    public int escojerOpciones() {
        boolean exepcion = true;
        do {
            try {
                System.out.println("\nSelecione una opcion: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                exepcion = false;
                return opcion;
            } catch (InputMismatchException error) {
                System.out.println("opcion no valida");
                exepcion = true;
                scanner.nextLine();
            }
        } while (exepcion);
        return 0;

    }


}


