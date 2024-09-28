package sv.edu.ufg.happyfriends.happyfriends.mappers;

import org.springframework.jdbc.core.RowMapper;
import sv.edu.ufg.happyfriends.happyfriends.entity.HorarioCita;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HorarioRowMapper implements RowMapper<HorarioCita> {
    @Override
    public HorarioCita mapRow(ResultSet rs, int rowNum) throws SQLException {
        HorarioCita horario = new HorarioCita();
        horario.setHocHorario(rs.getString("HOC_HORARIO"));
        return horario;
    }
}