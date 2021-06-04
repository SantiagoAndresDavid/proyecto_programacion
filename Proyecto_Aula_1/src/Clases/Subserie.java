
package Clases;

import java.util.ArrayList;
import java.util.List;

public class Subserie
{
    private int codigo;
    private String descripcion;
    private List<TipoDocumental> listaTipoDocumental = new ArrayList<>();


    public Subserie() {
    }

    public Subserie(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.listaTipoDocumental = listaTipoDocumental;
    }

    public void agregarTipoDocumental(TipoDocumental tipoDocumental){
        listaTipoDocumental.add(tipoDocumental);
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

    public List<TipoDocumental> getListaTipoDocumental() {
        return listaTipoDocumental;
    }

    public void setListaTipoDocumental(List<TipoDocumental> listaTipoDocumental) {
        this.listaTipoDocumental = listaTipoDocumental;
    }

    @Override
    public String toString() {
        return "\nSUBSERIE\n" +
                "------------------------------------------------\n"+
                "\n codigo:" + codigo +
                "\n descripcion:" + descripcion +
                "\n listaTipoDocumental" + listaTipoDocumental ;
    }
}
