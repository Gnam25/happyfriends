package sv.edu.ufg.happyfriends.happyfriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expediente, Integer> {
}
