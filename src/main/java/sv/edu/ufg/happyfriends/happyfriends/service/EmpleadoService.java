package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Empleado;
import sv.edu.ufg.happyfriends.happyfriends.repository.EmpleadoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Empleado> obtenerEmpleadoList(Integer pueId) {
        // Llamada al NamedStoredProcedureQuery
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_get_veterinario");
        query.setParameter("p_PUE_ID", pueId);
        return query.getResultList();
    }
}
