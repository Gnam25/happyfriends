package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;
import sv.edu.ufg.happyfriends.happyfriends.repository.ExpedienteRepository;
import sv.edu.ufg.happyfriends.happyfriends.repository.SucursalRepository;

@Service
@RequiredArgsConstructor
public class ExpedienteService {

    private final ExpedienteRepository expedienteRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insertExpediente(Expediente expediente) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_expediente");

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_MAS_NOMBRE", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_PROPIETARIO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_GENERO", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_COLOR", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_PESO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_TEMPERATURA", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_FRECARDIACA", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_DIRECCION", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_TELEFONO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_MEDREFERIDO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_RAZ_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);

            // Establecer valores
            query.setParameter("p_MAS_NOMBRE", expediente.getMasNombre());
            query.setParameter("p_MAS_PROPIETARIO", expediente.getMasPropietario());
            query.setParameter("p_MAS_GENERO", expediente.getMasGenero());
            query.setParameter("p_MAS_COLOR", expediente.getMasColor());
            query.setParameter("p_MAS_PESO", expediente.getMasPeso());
            query.setParameter("p_MAS_TEMPERATURA", expediente.getMasTemperatura());
            query.setParameter("p_MAS_FRECARDIACA", expediente.getMasFrecardiaca());
            query.setParameter("p_MAS_DIRECCION", expediente.getMasDireccion());
            query.setParameter("p_MAS_TELEFONO", expediente.getMasTelefono());
            query.setParameter("p_MAS_MEDREFERIDO", expediente.getMasMedReferido());
            query.setParameter("p_RAZ_ID", expediente.getRaza().getRazId());
            query.setParameter("p_USU_CODIGO", expediente.getUsuCodigo());

            // Ejecutar el procedimiento
            query.execute();

        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar el expeidente en la base de datos", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al expediente el pedido", ex);
        }
    }

   /* public Expediente insertExpediente(Expediente expediente) {
        Expediente nuevoExpediente = expedienteRepository.save(expediente);
        return nuevoExpediente;
    }
    public Expediente insertExpediente2(Expediente expediente) {
        Expediente nuevoExpediente = expedienteRepository.save(expediente);
        return nuevoExpediente;
    }
    */
}
