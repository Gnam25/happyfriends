package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.TipoMascota;
import sv.edu.ufg.happyfriends.happyfriends.repository.TipoMascotaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoMascotaService {

    private final TipoMascotaRepository tipoMscotaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<TipoMascota> obtenerTipoMascotaList() {
        // Llamada al NamedStoredProcedureQuery
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_get_tipo_mascota");
        return query.getResultList();
    }
}
