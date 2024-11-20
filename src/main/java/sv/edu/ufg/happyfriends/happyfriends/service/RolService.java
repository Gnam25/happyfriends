package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public PostResponseConverter insertRol(Rol rol) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_rol");

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_ROL_NOMBRE", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_ROL_DESCRIPCION", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_ROL_NOMBRE", rol.getRolNombre());
            query.setParameter("p_ROL_DESCRIPCION", rol.getRolDescripcion());
            query.setParameter("p_USU_CODIGO", rol.getUsuCodigo());

            // Ejecutar el procedimiento
            query.execute();

            String repuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");
            return new PostResponseConverter("", repuesta);


        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar rol en la base de datos, causa: ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al insertar rol, causa: ", ex);
        }
    }

    @Transactional
    public List<Rol> obtenerRolesList() {
        // Llamada al NamedStoredProcedureQuery
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_get_roles");
        return query.getResultList();
    }
}
