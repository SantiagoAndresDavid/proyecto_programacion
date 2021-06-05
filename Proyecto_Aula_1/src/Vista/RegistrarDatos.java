package Vista;

import Clases.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Scanner;

public class RegistrarDatos {
    private static Scanner scanner = new Scanner(System.in);
    private MetaDatoExpediente metaDatoExpediente;
    private MetaDatoDocumento metaDatoDocumento;


    public MetaDatoExpediente llenarExpediente() {
        MetaDatoExpediente metaDatoExpediente = new MetaDatoExpediente();
        Departamento departamento = new Departamento();
        DespachoJudicial despachoJudicial = new DespachoJudicial();
        TipoDocumental tipoDocumental = new TipoDocumental();
        Serie serie = new Serie();
        Subserie subserie = new Subserie();
        Cuaderno cuaderno = new Cuaderno();
        System.out.println("-------------------- LLENAR EXPEDIENTE -------------------- ");
        System.out.println("ingrese un codigo");
        metaDatoExpediente.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese el radicado");
        metaDatoExpediente.setNumeroRadicacion(scanner.nextInt());
        scanner.nextLine();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("DEPARTAMENTO");
        System.out.println("ingrese el departamento");
        departamento.setNombre(scanner.nextLine());
        System.out.println("ingrese la ciudad");
        departamento.setCiudad(scanner.nextLine());
        metaDatoExpediente.setDepartamento(departamento);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("DESPACHO JUDICIAL");
        System.out.println("ingrese el nombre del despacho");
        despachoJudicial.setNombre(scanner.nextLine());
        System.out.println("ingrese la categoria del despacho");
        despachoJudicial.setCategoria(scanner.nextLine());
        System.out.println("ingrese el departamento a la que pertenece el despacho");
        despachoJudicial.setDepartamento(scanner.nextLine());
        System.out.println("ingrese la ciudada la que pertenece el depacho");
        despachoJudicial.setCiudad(scanner.nextLine());
        metaDatoExpediente.setDespachoJudicial(despachoJudicial);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("TIPO DOCUMENTAL");
        System.out.println("ingrese el codigo de tipo documental");
        tipoDocumental.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese la descripcion del tipo documental ");
        tipoDocumental.setDescripcion(scanner.nextLine());
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("SUB-SERIE");
        System.out.println("ingrese el codigo");
        subserie.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese la descripcion de la subSerie ");
        subserie.setDescripcion(scanner.nextLine());
        subserie.getListaTipoDocumental().add(tipoDocumental);
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("SERIE");
        System.out.println("ingrese el codigo");
        serie.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese la descripcion de la serie ");
        serie.setDescripcion(scanner.nextLine());
        serie.getListaSubserie().add(subserie);
        metaDatoExpediente.setSerie(serie);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("PARTE PROCESAL");
        System.out.println("ingrese cuantos son demandantes");
        int cantidadDemandante = scanner.nextInt();
        for (int i = 0; i < cantidadDemandante; i++) {
            ParteProcesal parteProcesal = new ParteProcesal();
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("DEMANDANTE N:" + (i+1));
            System.out.println("ingrese el codigo");
            parteProcesal.setCodigo(scanner.nextInt());
            scanner.nextLine();
            System.out.println("ingrese el nombre");
            parteProcesal.setNombre(scanner.nextLine());
            System.out.println("ingrese el tipo de documento");
            parteProcesal.setTipoDocumento(scanner.nextLine());
            System.out.println("ingrese el documento");
            parteProcesal.setDocumento(scanner.nextInt());
            parteProcesal.setTipoParte("Demandante");
            metaDatoExpediente.getListaDemandantes().add(parteProcesal);
            System.out.println("-------------------------------------------------------------------------------------");

        }
        System.out.println("ingrese cuantos son los demandados");
        int cantidadDemandado = scanner.nextInt();
        for (int i = 0; i < cantidadDemandado; i++) {
            ParteProcesal parteProcesal = new ParteProcesal();
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("DEMANDADOS N:" + (i+1));
            System.out.println("ingrese el codigo");
            parteProcesal.setCodigo(scanner.nextInt());
            scanner.nextLine();
            System.out.println("ingrese el nombre");
            parteProcesal.setNombre(scanner.nextLine());
            System.out.println("ingrese el tipo de documento");
            parteProcesal.setTipoDocumento(scanner.nextLine());
            System.out.println("ingrese el documento");
            parteProcesal.setDocumento(scanner.nextInt());
            parteProcesal.setTipoParte("Demandado");
            metaDatoExpediente.getListaDemandado().add(parteProcesal);
            System.out.println("-------------------------------------------------------------------------------------");
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Cuaderno");
        System.out.println("ingrese la cantidad de cuadernos que tiene el expediente");
        int cantidadCuadernos = scanner.nextInt();
        for (int i = 0; i < cantidadCuadernos; i++) {
            System.out.println("Cuaderno N" + (i + 1));
            System.out.println("ingrese el codigo del cuaderno");
            cuaderno.setCodigo(scanner.nextInt());
            scanner.nextLine();
            cuaderno.setNumeroCuadernos(i+1);
            System.out.println("ingrese la descripcion del cuaderno");
            cuaderno.setDescripcion(scanner.nextLine());
            metaDatoExpediente.getListaCuaderno().add(cuaderno);

        }
        System.out.println("¿es un expediente fisico? ");
        metaDatoExpediente.setExpedienteFisico(scanner.nextLine());
        return metaDatoExpediente;
    }

    public MetaDatoDocumento llenarDocumento(){
        MetaDatoDocumento metaDatoDocumento = new MetaDatoDocumento();
        MetaDatoDocumento dato = new MetaDatoDocumento();
        System.out.println("ingrese el codigo");
        metaDatoDocumento.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.println("ingrese el nombre");
        metaDatoDocumento.setNombre(scanner.nextLine());
        System.out.println("ingrese la orden");
        metaDatoDocumento.setOrden(scanner.nextInt());
        scanner.nextLine();
        boolean A;
        do {
            try {
                System.out.println("Fecha de Creada (dia/mes/año) ");
                String creada = scanner.nextLine();
                metaDatoDocumento.setFechaCreada(new SimpleDateFormat("dd/mm/yyyy").parse(creada));
                A = false;
            } catch (ParseException ParseException) {
                System.out.println("Fecha invalida");
                A = true;
            }
        } while (A);

        boolean B;
        do {
            try {
                System.out.println("Fecha de incorporada (dia/mes/año) ");
                String creada = scanner.nextLine();
                metaDatoDocumento.setFechaIncorporada(new SimpleDateFormat("dd/mm/yyyy").parse(creada));
                B= false;
            } catch (ParseException ParseException) {
                System.out.println("Fecha invalida");
                B = true;
            }
        } while (B);

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


}
