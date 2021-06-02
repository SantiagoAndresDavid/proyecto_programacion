
package
        Clases;

public class Cuaderno {
    private int codigo;
    private int numeroCuadernos;
    private String descripcion;

    public Cuaderno() {

    }

    public Cuaderno(int codigo, int numCuaderno, String descripcion) {
        this.codigo = codigo;
        this.numeroCuadernos = numCuaderno;
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumeroCuadernos() {
        return numeroCuadernos;
    }

    public void setNumeroCuadernos(int numeroCuadernos) {
        this.numeroCuadernos = numeroCuadernos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CUADERNO%n" +
                "------------------------------------------------" +
                "%ncodigo:" + codigo +
                "%nnumeroCuadernos:" + numeroCuadernos +
                "%ndescripcion:" + descripcion +
                "%n------------------------------------------------";
    }
}
