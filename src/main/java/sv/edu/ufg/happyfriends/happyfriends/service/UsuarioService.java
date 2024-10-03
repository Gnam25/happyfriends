package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Permiso;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.UsuarioConverter;
import sv.edu.ufg.happyfriends.happyfriends.mappers.PermisoRowMapper;
import sv.edu.ufg.happyfriends.happyfriends.mappers.RolRowMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    //private final JdbcTemplate jdbcTemplate;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Rol validarUsuario(String email, String pass) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_validar_usuario");
        query.registerStoredProcedureParameter("p_USU_EMAIL", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_USU_PASSWORD", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_ROL_ID", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_ROL_NOMBRE", String.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_USU_CORRELATIVO", String.class, ParameterMode.OUT);

        query.setParameter("p_USU_EMAIL", email);
        query.setParameter("p_USU_PASSWORD", pass);

        query.execute();

        Integer rolId= (Integer) query.getOutputParameterValue("p_ROL_ID");
        String rolNombre = (String) query.getOutputParameterValue("p_ROL_NOMBRE");
        String usuCorrelativo = (String) query.getOutputParameterValue("p_USU_CORRELATIVO");
        return new Rol(rolId, rolNombre, usuCorrelativo);
    }

    /*public List<Rol> validarUsuario(String email, String pass) {
        String sql = "CALL sp_validar_usuario(?,?)";
        return jdbcTemplate.query(sql, new Object[]{email, pass}, new RolRowMapper());
    }*/
}
