package sv.edu.ufg.happyfriends.happyfriends.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sv.edu.ufg.happyfriends.happyfriends.entity.Sucursal;
import sv.edu.ufg.happyfriends.happyfriends.repository.SucursalRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SucursalService {
    private final SucursalRepository sucursalRepository;

    public String hellotest() {
        return "Hola es una prueba!";
    }



    public Optional<Sucursal> buscarSucursal(Integer id) {
        return sucursalRepository.findById(id);
    }

    /*
    // Agregar un nuevo repuesto a la BD
    public Repuesto agregarRepuesto(Repuesto repuesto) {
        Repuesto nuevoRepuesto = repuestoRepository.save(repuesto);
        return nuevoRepuesto;
    }

    // obtener repuestos
    public Page<Repuesto> obtenerRepuestos(Pageable pageable) {
        return repuestoRepository.findAll(pageable);
    }

    // Buscar repuesto
    public Optional<Repuesto> buscarRepuesto(Integer id) {
        return repuestoRepository.findById(id);
    }

    // Borrar un repuesto
    public void borrarRepuesto(Integer id) {
        Repuesto repuesto = repuestoRepository.findById(id).orElseThrow();
        repuestoRepository.delete(repuesto);
    }

    // Modificar repuesto
    public Repuesto editarRepuesto(Integer id, Repuesto repuesto) {
        Repuesto anterior = repuestoRepository.findById(id).orElseThrow();
        anterior.setNombre(repuesto.getNombre());
        anterior.setDescripcion(repuesto.getDescripcion());
        anterior.setPrecio(repuesto.getPrecio());
        Repuesto nuevo = repuestoRepository.save(anterior);
        return nuevo;
    }*/
}
