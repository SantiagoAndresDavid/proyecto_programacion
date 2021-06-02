package Vista;

import Clases.*;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class RegistrarDatos {
    private static Scanner scanner = new Scanner(System.in);
    private final MetaDatoExpediente metaDatoExpediente;
    private final MetaDatoDocumento metaDatoDocumento;
    private final Subserie subserie;
    private final Serie serie;

    public RegistrarDatos() {
        this.metaDatoExpediente = new MetaDatoExpediente();
        this.metaDatoDocumento = new MetaDatoDocumento();
        this.subserie = new Subserie();
        this.serie = new Serie();

    }


    public MetaDatoDocumento llenarDocumento() {
        MetaDatoDocumento dato = new MetaDatoDocumento();
        System.out.println("-------------------- LLENAR DOCUMENTO -------------------- ");
        System.out.println("ingrese el codigo");
        metaDatoDocumento.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese el nombre");
        metaDatoDocumento.setNombre(scanner.nextLine());
        boolean error;
        do {
            try {
                System.out.println("Fecha de creacion (dia/mes/año) ");
                String creada = scanner.nextLine();
                metaDatoDocumento.setFechaCreada(new SimpleDateFormat("dd/mm/yyyy").parse(creada));
                error = false;
            } catch (ParseException ParseException) {
                System.out.println("Fecha invalida");
                error = true;
            }
        } while (error);

        metaDatoDocumento.setFechaIncorporada(new Date());
        System.out.println("ingrese el numero de paginas ");
        metaDatoDocumento.setNumeroPaginas(scanner.nextInt());
        System.out.println("ingrese la pagina de inicio");
        metaDatoDocumento.setPagInicio(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese la pagina final");
        metaDatoDocumento.setPagFinal(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese el formato");
        metaDatoDocumento.setFormato(scanner.nextLine());
        System.out.println("ingrese el tamaño");
        metaDatoDocumento.setTamaño(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese el origen");
        metaDatoDocumento.setOrigen(scanner.nextLine());
        System.out.println("ingrese la observacion");
        metaDatoDocumento.setObservacion(scanner.nextLine());

        return metaDatoDocumento;

    }


    public MetaDatoExpediente llenarExpediente() {
        System.out.println("-------------------- LLENAR EXPEDIENTE -------------------- ");
        llenarParteProcesal();
        llenarCuaderno();
        llenarDepartamento();
        llenarDespachoJudical();
        llenarTipoDocumental();
        llenarSubserie();
        llenarSerie();

        return metaDatoExpediente;

    }


    public void llenarParteProcesal() {

        ParteProcesal parteProcesal = new ParteProcesal();
        System.out.println("codigo del Parte ");
        parteProcesal.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese tipo de la parte");
        parteProcesal.setTipoParte(scanner.nextLine());
        System.out.println("ingrese el nombre de la parte");
        parteProcesal.setNombre(scanner.nextLine());
        System.out.println("ingrese el de documento ");
        parteProcesal.setDocumento(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese el tipo de documento ");
        parteProcesal.setTipoDocumento(scanner.nextLine());
        System.out.println("ingrese si es demandante o demandado");
        String tipoD = scanner.nextLine();


        switch (tipoD) {
            case "Demandante":
                metaDatoExpediente.getListaDemandantes().add(parteProcesal);
                break;
            case "Demandado":
                metaDatoExpediente.getListaDemandado().add(parteProcesal);
                break;
            default:
                System.out.println(" no ingreso el tipo adecuado");
        }

    }

    public void llenarCuaderno() {
        System.out.println("codigo de cuaderno");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("numero del cuaderno");
        int numCuaderno = scanner.nextInt();
        scanner.nextLine();
        System.out.println("descripcion");
        String descripcion = scanner.nextLine();
        metaDatoExpediente.agregarCuaderno(codigo, numCuaderno, descripcion);

    }

    public void llenarDepartamento() {
        System.out.println("codigo del departamento ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("ingrese el nombre del departamento");
        String nombre = scanner.nextLine();
        System.out.println("ingrese el nombre de la ciudad");
        String ciudad = scanner.nextLine();

        Departamento departamento = new Departamento(codigo, nombre, ciudad);
        metaDatoExpediente.setDepartamento(departamento);
    }

    public void llenarDespachoJudical() {
        System.out.println("ingrese el codigo del despacho ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("ingresar el nombre del despacho");
        String nombre = scanner.nextLine();
        System.out.println("ingresar departamento");
        String departamento = scanner.nextLine();
        System.out.println("ingresar ciudad");
        String ciudad = scanner.nextLine();
        System.out.println("ingrese la categoria");
        String categoria = scanner.nextLine();

        DespachoJudicial despachoJudicial = new DespachoJudicial(codigo, nombre, departamento, ciudad, categoria);
        metaDatoExpediente.setDespachoJudicial(despachoJudicial);

    }

    public void llenarTipoDocumental() {
        System.out.println("ingrese el codigo del tipo documental");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("ingrese la descripcion");
        String descripcion = scanner.nextLine();

        TipoDocumental tipoDocumental = new TipoDocumental(codigo, descripcion);
        subserie.agregarTipoDocumental(tipoDocumental);

    }

    public void llenarSubserie() {
        System.out.println("ingrese el codigo de la sub Serie");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("ingrese la descripcion");
        String descripcion = scanner.nextLine();

        Subserie subserie = new Subserie(codigo, descripcion);

    }

    public void llenarSerie() {
        System.out.println("ingrese el codigo de la serie");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("ingrese la descripcion");
        String descripcion = scanner.nextLine();

        Serie serie = new Serie(codigo, descripcion);
    }


}
