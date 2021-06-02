
package Clases;




import java.util.ArrayList;
import java.util.List;

public class Proceso {

    private MetaDatoExpediente metadatosExpediente;
    private List<MetaDatoDocumento> listaDocumentos;

    public Proceso() {
        this(1);
    }

    public Proceso(int codigo)
    {
        this.metadatosExpediente = new MetaDatoExpediente();
        this.listaDocumentos = new ArrayList<>();
    }

    public void agregarDocumento(MetaDatoDocumento documento){
        listaDocumentos.add(documento);
    }

    public void eliminarDocumento(MetaDatoDocumento documento) {
        listaDocumentos.remove(documento);
    }

    public void agregarExpediente() {

    }

    public MetaDatoExpediente getMetadatosExpediente() 
    {
        return metadatosExpediente;
    }

    public void setMetadatosExpediente(MetaDatoExpediente metadatosExpediente) 
    {
        this.metadatosExpediente = metadatosExpediente;
    }

    public List<MetaDatoDocumento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(List<MetaDatoDocumento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    void agregarMetadatoExpediente(MetaDatoExpediente metaE)
    {
        this.metadatosExpediente = metaE; 
    }
    
    void agregarMetadatoDocumento(MetaDatoDocumento metaD)
    {
        this.listaDocumentos.add(metaD) ;
    }
}
