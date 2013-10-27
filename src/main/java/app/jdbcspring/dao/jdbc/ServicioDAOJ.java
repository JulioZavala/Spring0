package app.jdbcspring.dao.jdbc;

import app.jdbcspring.dao.ServicioDAO;
import app.jdbctemplate.model.Servicio;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ServicioDAOJ extends JdbcDaoSupport implements ServicioDAO {

    public List<Servicio> list() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Servicio get(Servicio t) {


        String sql = "select * from servicio where id = ?";

        Servicio servicio = (Servicio) this.getJdbcTemplate().queryForObject(
                sql, new Object[]{t.getId()}, new ServicioRowMapper());

        return servicio;


    }

    public void save(Servicio t) {

        String sql = "insert into servicio (descripcion, costo_hora) "
                + "values(?, ?);";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDescripcion(),
                t.getCostoHora(),});
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }


    }

    public void update(Servicio t) {

        String sql = "update servicio set descripcion=?, costo_hora=? "
                + " where id=?";

        try {
            this.getJdbcTemplate().update(sql, new Object[]{
                t.getDescripcion(),
                t.getCostoHora(),
                t.getId()
            });
        } catch (DataAccessException e) {
            System.err.println("ERROR: " + e.getMessage());
        }



    }

    public void delete(Servicio t) {
        this.getJdbcTemplate().update("delete from servicio where id = ?",
                new Object[]{t.getId()});
    }
}
