package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;
import sv.edu.ufg.happyfriends.happyfriends.entity.Usuario;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;

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
        query.registerStoredProcedureParameter("p_EMP_ID", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("p_EMP_NOMBRE", String.class, ParameterMode.OUT);

        query.setParameter("p_USU_EMAIL", email);
        query.setParameter("p_USU_PASSWORD", pass);

        query.execute();

        Integer rolId= (Integer) query.getOutputParameterValue("p_ROL_ID");
        String rolNombre = (String) query.getOutputParameterValue("p_ROL_NOMBRE");
        String usuCorrelativo = (String) query.getOutputParameterValue("p_USU_CORRELATIVO");
        Integer empId = (Integer) query.getOutputParameterValue("p_EMP_ID");
        String empNombre = (String) query.getOutputParameterValue("p_EMP_NOMBRE");
        return new Rol(rolId, rolNombre, usuCorrelativo, empId, empNombre);
    }

    @Transactional
    public PostResponseConverter insertUsuario(Usuario usuario) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_usuario");

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_USU_EMAIL", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_PASSWORD", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_ESTADO", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_EMP_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_ARC_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_ROL_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_USU_EMAIL", usuario.getUsuEmail());
            query.setParameter("p_USU_PASSWORD", usuario.getUsuPassword());
            query.setParameter("p_USU_ESTADO", usuario.getUsuEstado());
            query.setParameter("p_EMP_ID", usuario.getEmpId());
            query.setParameter("p_ARC_ID", usuario.getArcId());
            query.setParameter("p_ROL_ID", usuario.getRolId());
            query.setParameter("p_USU_CODIGO", usuario.getUsuCodigo());

            // Ejecutar el procedimiento
            query.execute();

            String repuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");
            return new PostResponseConverter("", repuesta);


        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar la usuario en la base de datos, causa: ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al insertar usuario, causa: ", ex);
        }
    }
}
