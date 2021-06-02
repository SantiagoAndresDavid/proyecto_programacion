
package Clases;

import java.util.List;

public class Departamento {
    private int codigo;
    private String nombre;
    private String ciudad;


    public Departamento() {

    }

    public Departamento(String codigo, String nombre) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public Departamento(int codigo, String nombre, String ciudad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "DEPARTAMENTO%n" +
                "------------------------------------------------" +
                "%ncodigo:" + codigo +
                "%nnombre:" + nombre +
                "%nciudad:" + ciudad +
                "%n------------------------------------------------";
    }
}
