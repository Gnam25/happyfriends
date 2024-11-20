package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.HorarioCita;
import sv.edu.ufg.happyfriends.happyfriends.mappers.HorarioRowMapper;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HorarioCitaService {

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public List<HorarioCita> getHorarioCita(Date fecha, int empId) {
        String sql = "CALL sp_get_cita_disponible(?,?)";
        return jdbcTemplate.query(sql, new Object[]{fecha, empId}, new HorarioRowMapper());
    }
}


