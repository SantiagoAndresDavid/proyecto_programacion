
package Clases;

public class TipoDocumental {
    private int codigo;
    private String descripcion;

    public TipoDocumental() {
        this.codigo = 25;
        this.descripcion = "notificacion";
    }

    public TipoDocumental(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TIPO DOCUMENTAL%n" +
                "------------------------------------------------" +
                "%ncodigo:" + codigo +
                "%ndescripcion:" + descripcion +
                "%n------------------------------------------------" ;
    }
}
