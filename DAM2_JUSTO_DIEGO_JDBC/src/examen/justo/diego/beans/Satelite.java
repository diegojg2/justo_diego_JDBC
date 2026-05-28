package examen.justo.diego.beans;

public class Satelite {
    private long id;
    private String nombre;
    private String orbita;
    private long peso;
    private long coste;
    private String activo;
    private Agencia agencia;
    private DetalleSatelite detalleSatelite;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrbita() {
        return orbita;
    }

    public void setOrbita(String orbita) {
        this.orbita = orbita;
    }

    public long getPeso() {
        return peso;
    }

    public void setPeso(long peso) {
        this.peso = peso;
    }

    public long getCoste() {
        return coste;
    }

    public void setCoste(long coste) {
        this.coste = coste;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public DetalleSatelite getDetalleSatelite() {
        return detalleSatelite;
    }

    public void setDetalleSatelite(DetalleSatelite detalleSatelite) {
        this.detalleSatelite = detalleSatelite;
    }

    @Override
    public String toString() {
        return "Satelite{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", orbita='" + orbita + '\'' +
                ", peso=" + peso +
                ", coste=" + coste +
                ", activo='" + activo + '\'' +
                ", agencia=" + agencia +
                ", detalleSatelite=" + detalleSatelite +
                '}';
    }
}
