package examen.justo.diego.beans;

public class DetalleSatelite {
    private long id;
    private long velocidadMaxima;
    private long combustible;
    private long vidaUtil;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(long velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public long getCombustible() {
        return combustible;
    }

    public void setCombustible(long combustible) {
        this.combustible = combustible;
    }

    public long getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(long vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    @Override
    public String toString() {
        return "DetalleSatelite{" +
                "id=" + id +
                ", velocidadMaxima=" + velocidadMaxima +
                ", combustible=" + combustible +
                ", vidaUtil=" + vidaUtil +
                '}';
    }
}
