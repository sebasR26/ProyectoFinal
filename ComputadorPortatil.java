public class ComputadorPortatil {
    private String Serial;
    private String Marca;
    private float Tamañopulgadas;
    private float Precio;
    private int SistemaOperativo;
    private int Procesador;
    
    
    public int getSistemaOperativo() {
        return SistemaOperativo;
    }
    public void setSistemaOperativo(int sistemaOperativo) {
        SistemaOperativo = sistemaOperativo;
    }
    public int getProcesador() {
        return Procesador;
    }
    public void setProcesador(int procesador) {
        Procesador = procesador;
    }
    public ComputadorPortatil() {
    }
    public String getSerial() {
        return Serial;
    }
    public void setSerial(String serial) {
        Serial = serial;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public float getTamañopulgadas() {
        return Tamañopulgadas;
    }
    public void setTamañopulgadas(float tamañopulgadas) {
        Tamañopulgadas = tamañopulgadas;
    }
    public float getPrecio() {
        return Precio;
    }
    public void setPrecio(float precio) {
        Precio = precio;
    }
    

}
