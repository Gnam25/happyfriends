package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Consulta;
import sv.edu.ufg.happyfriends.happyfriends.entity.ExamenResultado;
import sv.edu.ufg.happyfriends.happyfriends.entity.Tratamiento;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.ConsultaSearchConverter;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.TratamientoSearchConverter;

import java.util.ArrayList;
import java.util.Date;
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
            query.registerStoredProcedureParameter("p_CON_PESO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_TEMPERATURA", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_FRECARDIACA", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_EMP_ID", consulta.getEmpId());
            query.setParameter("p_EXP_ID", consulta.getExpId());
            query.setParameter("p_CON_SINTOMAS", consulta.getConSintomas());
            query.setParameter("p_CON_DIAGNOSTICO", consulta.getConDiagnostico());
            query.setParameter("p_CON_EXAMENES", consulta.getConExamenes());
            query.setParameter("p_CON_OBSERVACIONES", consulta.getConObservaciones());
            query.setParameter("p_CON_PESO", consulta.getConPeso());
            query.setParameter("p_CON_TEMPERATURA", consulta.getConTemperatura());
            query.setParameter("p_CON_FRECARDIACA", consulta.getConFrecardiaca());
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
    public List<ConsultaSearchConverter> buscarHistorialMedicoList(int expId) {
        // Llamada al NamedStoredProcedureQuery
        List<ConsultaSearchConverter> resultado=new ArrayList<ConsultaSearchConverter>();
        List<TratamientoSearchConverter> tratamientos=new ArrayList<TratamientoSearchConverter>();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_get_historialMedico");
        query.registerStoredProcedureParameter("p_EXP_ID", Integer.class, ParameterMode.IN);

        query.setParameter("p_EXP_ID", expId);
        query.execute();

        List<Object[]> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            for (Object[] row : resultList) {
                TratamientoSearchConverter tratamiento = new TratamientoSearchConverter((Integer) row[10], (String) row[11], (String) row[12], (String) row[13], (String) row[14], (Date) row[15]);
                tratamientos.add(tratamiento);
            }
            for (Object[] row : resultList) {
                    // Crear la instancia de ExpedienteSearchConverter
                    ConsultaSearchConverter temp = new ConsultaSearchConverter((Integer) row[0], (String) row[1], (String) row[2], (String) row[3],
                            (String) row[4], (String) row[5], (String) row[6], (String) row[7], (String) row[8], (String) row[9]);
                    temp.setTratamientos(tratamientos);
                // Validar si ya existe en la lista
                if (!resultado.contains(temp)) {
                    // Agregar el resultado convertido a la lista
                    resultado.add(temp);
                }
            }
        }
        return resultado;
    }

    @Transactional
    public PostResponseConverter actualizarConsulta(Consulta consulta) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_update_consulta");

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_CON_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_SINTOMAS", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_DIAGNOSTICO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_EXAMENES", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_OBSERVACIONES", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_PESO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_TEMPERATURA", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_CON_FRECARDIACA", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_CON_ID", consulta.getConId());
            query.setParameter("p_CON_SINTOMAS", consulta.getConSintomas());
            query.setParameter("p_CON_DIAGNOSTICO", consulta.getConDiagnostico());
            query.setParameter("p_CON_EXAMENES", consulta.getConExamenes());
            query.setParameter("p_CON_OBSERVACIONES", consulta.getConObservaciones());
            query.setParameter("p_CON_PESO", consulta.getConPeso());
            query.setParameter("p_CON_TEMPERATURA", consulta.getConTemperatura());
            query.setParameter("p_CON_FRECARDIACA", consulta.getConFrecardiaca());
            query.setParameter("p_USU_CODIGO", consulta.getUsuCodigo());

            // Ejecutar el procedimiento
            query.execute();

            String repuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");
            return new PostResponseConverter("", repuesta);


        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al actualizar consulta medica en la base de datos, causa: ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al actualizar consulta medica, causa: ", ex);
        }
    }

    @Transactional
    public PostResponseConverter insertTratamiento(Tratamiento tratamiento) {
        try {
            Integer consulaID=tratamiento.getConId(), okCount=0, koCount=0;
            String usuCodigo=tratamiento.getUsuCodigo();
            String finalResponse="";
            for (Tratamiento.TratamientoDetalle tratamientoDetalle : tratamiento.getTratamientoDetalle()) {
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_tratamiento");

                // Registrar parámetros
                query.registerStoredProcedureParameter("p_CON_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
                query.registerStoredProcedureParameter("p_TRT_MEDICAMENTO", String.class, jakarta.persistence.ParameterMode.IN);
                query.registerStoredProcedureParameter("p_TRT_DOSIS", String.class, jakarta.persistence.ParameterMode.IN);
                query.registerStoredProcedureParameter("p_TRT_FRECUENCIA", String.class, jakarta.persistence.ParameterMode.IN);
                query.registerStoredProcedureParameter("p_TRT_DURACION", String.class, jakarta.persistence.ParameterMode.IN);
                query.registerStoredProcedureParameter("p_TRT_FECINICIO", Date.class, jakarta.persistence.ParameterMode.IN);
                query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
                query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

                query.setParameter("p_CON_ID", consulaID);
                // Establecer valores
                query.setParameter("p_TRT_MEDICAMENTO", tratamientoDetalle.getTrtMedicamento());
                query.setParameter("p_TRT_DOSIS", tratamientoDetalle.getTrtDosis());
                query.setParameter("p_TRT_FRECUENCIA", tratamientoDetalle.getTrtFrecuencia());
                query.setParameter("p_TRT_DURACION", tratamientoDetalle.getTrtDuracion());
                query.setParameter("p_TRT_FECINICIO", tratamientoDetalle.getTrtFecInicio());
                query.setParameter("p_USU_CODIGO", usuCodigo);

                // Ejecutar el procedimiento
                query.execute();

                String respuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");

                if (respuesta.contains("Tratamiento medico guardado exitosamente")){
                    okCount+=1;
                }else {
                    koCount+=1;
                }
            }
            if (okCount==tratamiento.getTratamientoDetalle().size()){
                finalResponse="Tratamientos guardados exitosamente";
            }else{
                finalResponse="Hubieron algunos errores al guardar algunos tratamientos";
            }
            return new PostResponseConverter("", finalResponse);
        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar el tratamiento medico en la base de datos, causa: ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al insertar tratamiento medico, causa: ", ex);
        }
    }

    @Transactional
    public PostResponseConverter insertResultadoExamen(ExamenResultado examen) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_examen_resultado");

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_CON_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_EXR_RESULTADO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_INSERT_RESPONSE", String.class, ParameterMode.OUT);

            // Establecer valores
            query.setParameter("p_CON_ID", examen.getConId());
            query.setParameter("p_EXR_RESULTADO", examen.getExrResultado());
            query.setParameter("p_USU_CODIGO", examen.getUsuCodigo());

            // Ejecutar el procedimiento
            query.execute();

            String repuesta = (String) query.getOutputParameterValue("p_INSERT_RESPONSE");
            return new PostResponseConverter("", repuesta);


        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar el resultado de examen en la base de datos, causa: ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al insertar resultado de examen, causa: ", ex);
        }
    }
}
