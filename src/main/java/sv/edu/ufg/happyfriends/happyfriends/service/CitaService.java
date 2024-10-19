package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Cita;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;
import sv.edu.ufg.happyfriends.happyfriends.repository.CitaRepository;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.CitaSearchConverter;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void crearCita(Cita cita) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_add_cita");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar       = Calendar.getInstance();
            java.util.Date now      = calendar.getTime();

            // Registrar parámetros
            query.registerStoredProcedureParameter("CTA_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("CTA_FECHORA", Date.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("CTA_ESTADO", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("CTA_PROPIETARIO", String.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("EMP_ID", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("FEC_ACTUAL", Date.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("USU_CODIGO", String.class, jakarta.persistence.ParameterMode.IN);

            // Establecer valores
            query.setParameter("CTA_CODIGO", cita.getCtaCodigo());
            query.setParameter("CTA_FECHORA", formatter.parse(cita.getCtaFecHora()));
            query.setParameter("CTA_ESTADO", cita.getCtaEstado());
            query.setParameter("CTA_PROPIETARIO", cita.getCtaPropietario());
            query.setParameter("EMP_ID", cita.getEmpId());
            query.setParameter("FEC_ACTUAL", now);
            query.setParameter("USU_CODIGO", cita.getUsuCodigo());

            // Ejecutar el procedimiento
            query.execute();

        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al insertar la cita en la base de datos. ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al insertar la cita. ", ex);
        }
    }

    @Transactional
    public void actualizarCita(Cita cita) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_update_cita");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
            Calendar calendar       = Calendar.getInstance();
            java.util.Date now      = calendar.getTime();

            // Registrar parámetros
            query.registerStoredProcedureParameter("p_id", Integer.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_fechahora", Date.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_hora", Time.class, jakarta.persistence.ParameterMode.IN);
            query.registerStoredProcedureParameter("p_propietario", String.class, jakarta.persistence.ParameterMode.IN);

            // Establecer valores
            query.setParameter("p_id", cita.getCtaCodigo());
            query.setParameter("p_fechahora", formatter.parse(cita.getCtaFecHora()));
            query.setParameter("p_hora", formatterTime.parse(cita.getCtaHora()));
            query.setParameter("p_propietario", cita.getCtaPropietario());

            // Ejecutar el procedimiento
            query.execute();

        } catch (PersistenceException ex) {
            // Manejar errores de la base de datos, como problemas de conexión o constraints
            throw new CustomException("Error al actualizar la cita en la base de datos. ", ex);
        } catch (Exception ex) {
            // Manejar cualquier otra excepción
            throw new CustomException("Error inesperado al actualizar la cita. ", ex);
        }
    }

    @Transactional
    public List<CitaSearchConverter> buscarCitaList(CitaSearchConverter cita) {
        // Llamada al NamedStoredProcedureQuery
        List<CitaSearchConverter> resultado=new ArrayList<CitaSearchConverter>();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_busqueda_cita");
        query.registerStoredProcedureParameter("p_fecha", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_hora", Time.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_propietario", String.class, ParameterMode.IN);

        query.setParameter("p_fecha", cita.getFecha());
        query.setParameter("p_hora", cita.getHora());
        query.setParameter("p_propietario", cita.getPropietario());
        query.execute();

        List<Object[]> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            for (Object[] row : resultList) {
                // Crear la instancia de CitaSearchConverter
                CitaSearchConverter temp = new CitaSearchConverter((Integer) row[0], (Date) row[1], (Time) row[2], (String) row[3], (String) row[4]);
                // Agregar el resultado convertido a la lista
                resultado.add(temp);
            }
        }
        return resultado;
    }

}