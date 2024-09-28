package sv.edu.ufg.happyfriends.happyfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.HorarioCita;
import sv.edu.ufg.happyfriends.happyfriends.mappers.HorarioRowMapper;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioCitaService {

    private final JdbcTemplate jdbcTemplate;

    public List<HorarioCita> getHorarioCita(Date fecha, int empId) {
        String sql = "CALL sp_get_cita_disponible(?,?)";
        return jdbcTemplate.query(sql, new Object[]{fecha, empId}, new HorarioRowMapper());
    }
}


