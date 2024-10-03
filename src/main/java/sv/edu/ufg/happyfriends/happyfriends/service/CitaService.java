package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Cita;
import sv.edu.ufg.happyfriends.happyfriends.exceptionClass.CustomException;
import sv.edu.ufg.happyfriends.happyfriends.repository.CitaRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

}