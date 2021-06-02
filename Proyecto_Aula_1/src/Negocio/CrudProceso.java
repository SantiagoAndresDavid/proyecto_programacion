package Negocio;

import Clases.MetaDatoDocumento;
import Clases.MetaDatoExpediente;
import Clases.ParteProcesal;
import Clases.Proceso;
import Datos.GestionMetadatoDocumento;
import Datos.GestionProceso;
import Excepciones.ExcepcionAccesoDatos;
import Vista.RegistrarDatos;

public class CrudProceso {
    private GestionMetadatoDocumento gestionMetadatoDocumento;
    private GestionProceso gestionProceso;
    private MetaDatoExpediente metaDatoExpediente;
    private MetaDatoDocumento metaDatoDocumento;
    private RegistrarDatos registrarDatos;


    public CrudProceso() {
        this.gestionMetadatoDocumento = new GestionMetadatoDocumento();
        this.metaDatoDocumento = new MetaDatoDocumento();
        this.registrarDatos = new RegistrarDatos();
        this.gestionProceso = new GestionProceso();
    }

    public void insertarDocumento(MetaDatoDocumento metaDatoDocumento) {
        Proceso proceso = new Proceso();
        if (metaDatoDocumento == null) {
            System.out.println("El objeto a insertar es de tipo NULL");
        }
        if (metaDatoDocumento.getNombre() == null) {
            System.out.println("El Objeto a insertar no tiene NOMBRE");

        }
        proceso.agregarDocumento(registrarDatos.llenarDocumento());
        gestionProceso.getListproc().add(proceso);
    }

    public void insertarExpediente(MetaDatoExpediente metaDatoExpediente) {
        Proceso proceso = new Proceso();
        if (metaDatoExpediente == null) {
            System.out.println("El objeto a insertar es de tipo NULL");
        }


        proceso.setMetadatosExpediente(registrarDatos.llenarExpediente());
        gestionProceso.getListproc().add(proceso);

    }

    public void borrarDocumento(int codigo) {
        Proceso proceso = new Proceso();
        try {
            MetaDatoDocumento documento = gestionMetadatoDocumento.buscar(codigo);
            if (documento == null) {
                System.out.println("no existe el documento que desea borrar");
            } else {
                proceso.getListaDocumentos().remove(documento);
                System.out.println("Documento borrado");
            }
        } catch (ExcepcionAccesoDatos excepcionAccesoDatos) {
            System.out.println(excepcionAccesoDatos.getMessage());
        }
    }

    public Proceso buscarPorCodigo(int codigo) {
        try {
            return gestionProceso.buscar(codigo);
        } catch (ExcepcionAccesoDatos excepcionAccesoDatos) {
            return null;
        }
    }

    public Proceso buscarPorDemandado(String nombreDemandado) {

        Proceso encontrado = null;
        for (Proceso prc : gestionProceso.getListproc()) {
            for (ParteProcesal parteProcesal : prc.getMetadatosExpediente().getListaDemandado()) {
                if (parteProcesal.getNombre().equals(nombreDemandado)) {
                    encontrado = prc;
                    break;
                }
            }
        }
        return encontrado;
    }

    public Proceso buscarPorDemandante(String nombreDemandante) {
        Proceso encontrado = null;
        for (Proceso prc : gestionProceso.getListproc()) {
            for (ParteProcesal parteProcesal : prc.getMetadatosExpediente().getListaDemandantes()) {
                if (parteProcesal.getNombre().equals(nombreDemandante)) {
                    encontrado = prc;
                    break;
                }
            }
        }
        return encontrado;
    }

    public void actualizar() {

    }


}

