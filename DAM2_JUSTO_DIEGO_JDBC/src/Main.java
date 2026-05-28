import examen.justo.diego.beans.Agencia;
import examen.justo.diego.dao.AbstractDAO;
import examen.justo.diego.dao.AgenciaDAOImpl;
import examen.justo.diego.motores.MotorFactory;

public class Main {
    public static void main(String[] args) {
        AgenciaDAOImpl agenciaDAO = new AgenciaDAOImpl(MotorFactory.create(MotorFactory.POSTGRE));
        Agencia agencia = new Agencia();
        agencia.setId(1);
        agencia.setNombre("Cielo");
        agencia.setPais("Frncia");

        agenciaDAO.add(agencia);
    }
}