package sv.edu.ufg.happyfriends.happyfriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.ufg.happyfriends.happyfriends.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {
}
