package examen.justo.diego.dao;
import examen.justo.diego.beans.Satelite;
import examen.justo.diego.motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SateliteDAOImpl extends AbstractDAO<Satelite> {
    public SateliteDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    @Override
    public void add(Satelite object) {

    }

    @Override
    public void update(int id, Satelite object) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Satelite find(int id) {
        return null;
    }

    @Override
    public ArrayList<Satelite> findAll() {
        return null;
    }
}