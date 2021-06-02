
package Clases;


import java.util.ArrayList;
import java.util.List;

public class MetaDatoExpediente {
    private int codigo;
    private Departamento departamento;
    private String ciudad;
    private DespachoJudicial despachoJudicial;
    private Serie serie;
    private Subserie subserie;
    private int numeroRadicacion;
    private List<ParteProcesal> listaDemandado = new ArrayList<>();
    private List<ParteProcesal> listaDemandantes = new ArrayList<>();
    private List<Cuaderno> listaCuaderno = new ArrayList<>();
    private String expedienteFisico;

    public MetaDatoExpediente() {
    }

    public MetaDatoExpediente(int codigo, Departamento departamento, String ciudad, DespachoJudicial despachoJudicial, Serie serie, Subserie subserie, int numeroRadicacion, String expedienteFisico) {
        this.codigo = codigo;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.despachoJudicial = despachoJudicial;
        this.serie = serie;
        this.subserie = subserie;
        this.numeroRadicacion = numeroRadicacion;
        this.expedienteFisico = expedienteFisico;

    }


    public void agregarCuaderno(int codigo, int numCuaderno, String descripcion) {
        Cuaderno cuaderno = new Cuaderno(codigo, numCuaderno, descripcion);
        listaCuaderno.add(cuaderno);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public DespachoJudicial getDespachoJudicial() {
        return despachoJudicial;
    }

    public void setDespachoJudicial(DespachoJudicial despachoJudicial) {
        this.despachoJudicial = despachoJudicial;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Subserie getSubserie() {
        return subserie;
    }

    public void setSubserie(Subserie subserie) {
        this.subserie = subserie;
    }

    public int getNumeroRadicacion() {
        return numeroRadicacion;
    }

    public void setNumeroRadicacion(int numeroRadicacion) {
        this.numeroRadicacion = numeroRadicacion;
    }


    public List<Cuaderno> getListaCuaderno() {
        return listaCuaderno;
    }

    public void setListaCuaderno(List<Cuaderno> listaCuaderno) {
        this.listaCuaderno = listaCuaderno;
    }

    public String getExpedienteFisico() {
        return expedienteFisico;
    }

    public void setExpedienteFisico(String expedienteFisico) {
        this.expedienteFisico = expedienteFisico;
    }

    public List<ParteProcesal> getListaDemandado() {
        return listaDemandado;
    }

    public void setListaDemandado(List<ParteProcesal> listaDemandado) {
        this.listaDemandado = listaDemandado;
    }

    public List<ParteProcesal> getListaDemandantes() {
        return listaDemandantes;
    }

    public void setListaDemandantes(List<ParteProcesal> listaDemandantes) {
        this.listaDemandantes = listaDemandantes;
    }

}
