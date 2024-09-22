package sv.edu.ufg.happyfriends.happyfriends.mappers;

import org.springframework.jdbc.core.RowMapper;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolRowMapper implements RowMapper<Rol> {
    @Override
    public Rol mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rol rol = new Rol();
        rol.setRolId(rs.getInt("ROL_ID"));
        rol.setRolNombre(rs.getString("ROL_NOMBRE"));
        return rol;
    }
}
