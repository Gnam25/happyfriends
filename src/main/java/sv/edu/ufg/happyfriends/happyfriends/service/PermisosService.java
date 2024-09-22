package sv.edu.ufg.happyfriends.happyfriends.service;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Permiso;
import sv.edu.ufg.happyfriends.happyfriends.mappers.PermisoRowMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermisosService {

    private final JdbcTemplate jdbcTemplate;

    public List<Permiso> getPermisobyRol(int rolId) {
        String sql = "CALL sp_get_permisos_rol(?)";
        return jdbcTemplate.query(sql, new Object[]{rolId}, new PermisoRowMapper());
    }
}
