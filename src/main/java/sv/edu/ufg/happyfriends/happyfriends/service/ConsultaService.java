package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Consulta;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.ExpedienteSearchConverter;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public PostResponseConverter insertConsulta(Consulta consulta) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_consulta");

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_EMP_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_EXP_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_SINTOMAS", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_DIAGNOSTICO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_EXAMENES", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_OBSERVACIONES", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_EMP_ID", consulta.getEmpId());
            query.setParameter("p_EXP_ID", consulta.getExpId());
            query.setParameter("p_CON_SINTOMAS", consulta.getConSintomas());
            query.setParameter("p_CON_DIAGNOSTICO", consulta.getConDiagnostico());
            query.setParameter("p_CON_EXAMENES", consulta.getConExamenes());
            query.setParameter("p_CON_OBSERVACIONES", consulta.getConObservaciones());
            query.setParameter("p_USU_CODIGO", consulta.getUsuCodigo());

            // Ejecutar el procedimiento
            query.execute();

            String repuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");
            return new PostResponseConverter("", repuesta);


        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar la consulta medica en la base de datos, causa: ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al insertar consulta medica, causa: ", ex);
        }
    }

    @Transactional
    public List<Consulta> buscarHistorialMedicoList(int expId) {
        // Llamada al NamedStoredProcedureQuery
        List<Consulta> resultado=new ArrayList<Consulta>();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_historialMedico");
        query.registerStoredProcedureParameter("p_EXP_ID", Integer.class, ParameterMode.IN);

        query.setParameter("p_EXP_ID", expId);
        query.execute();

        List<Object[]> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            for (Object[] row : resultList) {
                // Crear la instancia de ExpedienteSearchConverter
                Consulta temp = new Consulta((String) row[0], (String) row[1], (String) row[2], (String) row[3], (String) row[4], (String) row[5]);
                // Agregar el resultado convertido a la lista
                resultado.add(temp);
            }
        }
        return resultado;
    }
}
