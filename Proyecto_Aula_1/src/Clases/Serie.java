
package Clases;


import java.util.ArrayList;
import java.util.List;

public class Serie
{
    private int codigo;
    private String descripcion;
    private List<Subserie> listaSubserie = new ArrayList<>();

    public Serie() {
    }

    public Serie(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.listaSubserie = listaSubserie;
    }

    public void agregarSubserie(Subserie subserie){
        listaSubserie.add(subserie);

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

    public List<Subserie> getListaSubserie() {
        return listaSubserie;
    }

    public void setListaSubserie(List<Subserie> listaSubserie) {
        this.listaSubserie = listaSubserie;
    }

    @Override
    public String toString() {
        return "SERIE%n" +
                "------------------------------------------------"+
                "%ncodigo:" + codigo +
                "%ndescripcion:" + descripcion +
                "%nlistaSubserie:" + listaSubserie +
                "%n------------------------------------------------";
    }
}
