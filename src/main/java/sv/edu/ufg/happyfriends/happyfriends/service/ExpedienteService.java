package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Cita;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;
import sv.edu.ufg.happyfriends.happyfriends.repository.ExpedienteRepository;
import sv.edu.ufg.happyfriends.happyfriends.repository.SucursalRepository;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.CitaSearchConverter;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.ExpedienteSearchConverter;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpedienteService {

    private final ExpedienteRepository expedienteRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public PostResponseConverter insertExpediente(Expediente expediente) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_expediente");

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_MAS_NOMBRE", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_PROPIETARIO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_CORREO", String.class, jakarta.persistence.ParameterMode.IN);
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
            query.registerStoredProcedureParameter("p_MAS_ID", String.class, ParameterMode.OUT);
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_MAS_NOMBRE", expediente.getMasNombre());
            query.setParameter("p_MAS_PROPIETARIO", expediente.getMasPropietario());
            query.setParameter("p_MAS_CORREO", expediente.getMasCorreo());
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

            String masId = (String) query.getOutputParameterValue("p_MAS_ID");
            String repuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");
            return new PostResponseConverter(masId, repuesta);


        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar el expeidente en la base de datos", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al expediente el pedido", ex);
        }
    }

    @Transactional
    public PostResponseConverter actualizarExpediente(Expediente expediente) {
        try {
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_update_expediente");
            // Registrar parámetros
            query.registerStoredProcedureParameter("p_MAS_ID", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_NOMBRE", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_PROPIETARIO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_MAS_CORREO", String.class, jakarta.persistence.ParameterMode.IN);
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
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_MAS_ID", expediente.getMasId());
            query.setParameter("p_MAS_NOMBRE", expediente.getMasNombre());
            query.setParameter("p_MAS_PROPIETARIO", expediente.getMasPropietario());
            query.setParameter("p_MAS_CORREO", expediente.getMasCorreo());
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

            String repuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");
            return new PostResponseConverter("", repuesta);

        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al actualizar expediente en la base de datos. ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al actualizar expediente. ", ex);
        }
    }

    @Transactional
    public List<ExpedienteSearchConverter> buscarExpedienteList(ExpedienteSearchConverter expediente) {
        // Llamada al NamedStoredProcedureQuery
        List<ExpedienteSearchConverter> resultado=new ArrayList<ExpedienteSearchConverter>();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_busqueda_expediente");
        query.registerStoredProcedureParameter("p_MAS_ID", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_MAS_NOMBRE", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_PROPIETARIO", String.class, ParameterMode.IN);

        query.setParameter("p_MAS_ID", expediente.getMasId());
        query.setParameter("p_MAS_NOMBRE", expediente.getMasNombre());
        query.setParameter("p_PROPIETARIO", expediente.getMasPropietario());
        query.execute();

        List<Object[]> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            for (Object[] row : resultList) {
                // Crear la instancia de ExpedienteSearchConverter
                ExpedienteSearchConverter temp = new ExpedienteSearchConverter((String) row[0], (String) row[1], (String) row[2], (String) row[3], (String) row[4], (String) row[5]
                        , (Integer) row[6], (Integer) row[7], (String) row[8], (String) row[9], (String) row[10], (String) row[11], (String) row[12], (String) row[13], (String) row[14], (Integer) row[15]);
                // Agregar el resultado convertido a la lista
                resultado.add(temp);
            }
        }
        return resultado;
    }

}
