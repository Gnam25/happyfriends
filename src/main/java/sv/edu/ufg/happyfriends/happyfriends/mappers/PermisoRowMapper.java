package sv.edu.ufg.happyfriends.happyfriends.mappers;

import org.springframework.jdbc.core.RowMapper;
import sv.edu.ufg.happyfriends.happyfriends.entity.Permiso;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PermisoRowMapper implements RowMapper<Permiso> {
    @Override
    public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
        Permiso permiso = new Permiso();
        permiso.setModNombre(rs.getString("MOD_NOMBRE"));
        permiso.setOpcNombre(rs.getString("OPC_NOMBRE"));
        return permiso;
    }
}
