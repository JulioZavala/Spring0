package app.jdbcspring.dao.jdbc;

import app.jdbctemplate.model.Servicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class ServicioRowMapper implements RowMapper<Servicio> {

    @Override
    public Servicio mapRow(ResultSet rs, int i) throws SQLException {
        Servicio servicio = new Servicio();
        servicio.setId(rs.getLong(1));
        servicio.setDescripcion(rs.getString(2));
        servicio.setCostoHora(rs.getDouble(3));

        return servicio;
    }
}
