package examen.justo.diego.dao;
import examen.justo.diego.beans.Agencia;
import examen.justo.diego.motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class AgenciaDAOImpl extends AbstractDAO<Agencia> {
    private static final String SQL_FIND_ALL = "SELECT * FROM AGENCIA ORDER BY id";
    private static final String SQL_FIND = "SELECT * FROM AGENCIA WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO AGENCIA (nombre, pais) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE AGENCIA SET nombre = ?, pais = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM AGENCIA WHERE id = ?";
    private static final String SQL_FIND_BY_NOMBRE = "SELECT * FROM AGENCIA WHERE nombre = ?";
    private static final String SQL_FIND_BY_PAIS = "SELECT * FROM AGENCIA WHERE pais = ?";

    public AgenciaDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    public void check() {
        try {
            motorSQL.connect();
            if (motorSQL.conn != null && !motorSQL.conn.isClosed()) {
                System.out.println("CONEXION OK");
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void add(Agencia agencia) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_INSERT);
            motorSQL.getPs().setString(1, agencia.getNombre());
            motorSQL.getPs().setString(2, agencia.getPais());

            int rows = motorSQL.executeUpdate();
            System.out.println("INSERTADOS: " + rows);
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void update(int id, Agencia agencia) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE);
            motorSQL.getPs().setString(1, agencia.getNombre());
            motorSQL.getPs().setString(2, agencia.getPais());
            motorSQL.getPs().setInt(3, id);
            int rows = motorSQL.executeUpdate();
            System.out.println("ACTUALIZADOS: " + rows);
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public void delete(int id) {
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_DELETE);
            motorSQL.getPs().setInt(1, id);
            int rows = motorSQL.executeUpdate();
            System.out.println("BORRADOS: " + rows);
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    @Override
    public Agencia find(int id) {
        Agencia agencia = null;
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND);
            motorSQL.getPs().setInt(1, id);
            ResultSet rs = motorSQL.executeQuery();
            if (rs.next()) {
                agencia = mapAgencia(rs);
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
        return agencia;
    }

    @Override
    public ArrayList<Agencia> findAll() {
        ArrayList<Agencia> agencias = new ArrayList<>();
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL);
            ResultSet rs = motorSQL.executeQuery();
            while (rs.next()) {
                agencias.add(mapAgencia(rs));
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
        return agencias;
    }

    /*
     * =========================
     * CONSULTAS AVANZADAS
     * =========================
     */


    public ArrayList<Agencia> findByNombre(String nombre) {
        ArrayList<Agencia> agencias = new ArrayList<>();
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_BY_NOMBRE);
            motorSQL.getPs().setString(1, nombre);
            ResultSet rs = motorSQL.executeQuery();
            while (rs.next()) {
                agencias.add(mapAgencia(rs));
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
        return agencias;
    }

    public ArrayList<Agencia> findBypais(String pais) {
        ArrayList<Agencia> agencias = new ArrayList<>();
        try {
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_BY_PAIS);
            motorSQL.getPs().setString(1, pais);
            ResultSet rs = motorSQL.executeQuery();
            while (rs.next()) {
                agencias.add(mapAgencia(rs));
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
        return agencias;
    }

    private Agencia mapAgencia(ResultSet rs) throws Exception {
        Agencia agencia = new Agencia();
        agencia.setId(rs.getInt("id"));
        agencia.setNombre(rs.getString("nombre"));
        agencia.setPais(rs.getString("pais"));
        return agencia;
    }
}
