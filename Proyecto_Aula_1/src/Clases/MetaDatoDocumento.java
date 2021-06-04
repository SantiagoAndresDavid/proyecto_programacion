
package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MetaDatoDocumento 
{
    private int codigo;
    private String nombre;
    private Date fechaCreada;
    private Date fechaIncorporada;
    private int orden;
    private int numeroPaginas;
    private int pagInicio;
    private int pagFinal;
    private String formato;
    private int tamaño;
    private String origen;
    private String observacion;


    public MetaDatoDocumento() 
    {
        
    }

    public MetaDatoDocumento(int codigo){
        this.codigo = codigo;
    }

    public MetaDatoDocumento(int codigo, String nombre, Date fechaCreada, 
                                Date fechaIncorporada, int orden, int numeroPaginas, 
                                int pagInicio, int pagFinal, String formato, int tamaño, 
                                String origen, String observacion) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fechaCreada = fechaCreada;
        this.fechaIncorporada = fechaIncorporada;
        this.orden = orden;
        this.numeroPaginas = numeroPaginas;
        this.pagInicio = pagInicio;
        this.pagFinal = pagFinal;
        this.formato = formato;
        this.tamaño = tamaño;
        this.origen = origen;
        this.observacion = observacion;
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

    public Date getFechaCreada() 
    {
        return fechaCreada;
    }

    public void setFechaCreada(Date fechaCreada)
    {
        this.fechaCreada = fechaCreada;
    }

    public Date getFechaIncorporada()
    {
        return fechaIncorporada;
    }

    public void setFechaIncorporada(Date fechaIncorporada) 
    {
        this.fechaIncorporada = fechaIncorporada;
    }

    public int getOrden() 
    {
        return orden;
    }

    public void setOrden(int orden) 
    {
        this.orden = orden;
    }

    public int getNumeroPaginas() 
    {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) 
    {
        this.numeroPaginas = numeroPaginas;
    }

    public int getPagInicio() 
    {
        return pagInicio;
    }

    public void setPagInicio(int pagInicio) 
    {
        this.pagInicio = pagInicio;
    }

    public int getPagFinal() 
    {
        return pagFinal;
    }

    public void setPagFinal(int pagFinal) 
    {
        this.pagFinal = pagFinal;
    }

    public String getFormato() 
    {
        return formato;
    }

    public void setFormato(String formato) 
    {
        this.formato = formato;
    }

    public int getTamaño() 
    {
        return tamaño;
    }

    public void setTamaño(int tamaño) 
    {
        this.tamaño = tamaño;
    }

    public String getOrigen() 
    {
        return origen;
    }

    public void setOrigen(String origen)
    {
        this.origen = origen;
    }

    public String getObservacion()
    {
        return observacion;
    }

    public void setObservacion(String observacion) 
    {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "\nDocumento\n" +
                "------------------------------------------------------------------------------------------------------"+
                "\n codigo:" + codigo +
                "\n nombre:" + nombre +
                "\n fechaCreada:" + fechaCreada +
                "\n fechaIncorporada:" + fechaIncorporada +
                "\n orden:" + orden +
                "\n numeroPaginas:" + numeroPaginas +
                "\n pagInicio:" + pagInicio +
                "\n pagFinal:" + pagFinal +
                "\n formato:" + formato +
                "\n tamaño:" + tamaño +
                "\n origen:" + origen +
                "\n observacion:" + observacion +
                "\n-----------------------------------------------------------------------------------------------------\n";
    }
}
