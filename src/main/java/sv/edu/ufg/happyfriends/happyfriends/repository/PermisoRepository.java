package sv.edu.ufg.happyfriends.happyfriends.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entity.Permiso;
import sv.edu.ufg.happyfriends.happyfriends.mappers.PermisoRowMapper;

import java.util.List;

@Repository
//public interface PermisoRepository extends JpaRepository<PermisoBasic, String> { }
public interface PermisoRepository  { }
