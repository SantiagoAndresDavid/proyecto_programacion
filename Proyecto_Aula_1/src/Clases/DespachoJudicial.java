
package Clases;


public class DespachoJudicial 
{
    private int codigo;
    private String nombre;
    private String departamento;
    private String ciudad;
    private String categoria;

    public DespachoJudicial()
    {
        
    }


    
    public DespachoJudicial(int codigo, String nombre, String departamento, String ciudad, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.categoria = categoria;
    }

    public int getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getDepartamento() 
    {
        return departamento;
    }

    public void setDepartamento(String departamento) 
    {
        this.departamento = departamento;
    }

    public String getCiudad() 
    {
        return ciudad;
    }

    public void setCiudad(String ciudad) 
    {
        this.ciudad = ciudad;
    }

    public String getCategoria() 
    {
        return categoria;
    }

    public void setCategoria(String categoria) 
    {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "\nDESPACHO JUDICIAL\n" +
                "------------------------------------------------" +
                "\n codigo:" + codigo +
                "\n nombre:'" + nombre +
                "\n departamento='" + departamento +
                "\n ciudad:" + ciudad +
                "\n categoria:'" + categoria +
                "\n------------------------------------------------";
    }
}
