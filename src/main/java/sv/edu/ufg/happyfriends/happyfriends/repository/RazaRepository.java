package sv.edu.ufg.happyfriends.happyfriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.edu.ufg.happyfriends.happyfriends.entity.Raza;

@Repository
public interface RazaRepository extends JpaRepository<Raza, Integer> {
}
