package sv.edu.ufg.happyfriends.happyfriends.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Raza;
import sv.edu.ufg.happyfriends.happyfriends.entity.TipoMascota;
import sv.edu.ufg.happyfriends.happyfriends.repository.RazaRepository;
import sv.edu.ufg.happyfriends.happyfriends.repository.TipoMascotaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RazaService {

    private final RazaRepository razaRepository;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Raza> obtenerRazaList(Integer timId) {
        // Llamada al NamedStoredProcedureQuery
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("sp_get_razas");
        query.setParameter("p_idmascota", timId);
        return query.getResultList();
    }
}
