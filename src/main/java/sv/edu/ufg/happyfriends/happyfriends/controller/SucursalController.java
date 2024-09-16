package sv.edu.ufg.happyfriends.happyfriends.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sv.edu.ufg.happyfriends.happyfriends.entity.Sucursal;
import sv.edu.ufg.happyfriends.happyfriends.service.SucursalService;


import java.util.Optional;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class SucursalController {
    private final SucursalService sucursalService;

    @GetMapping("/hello")
    public String hellotest() {
        return sucursalService.hellotest();
    }

    @GetMapping("/sucursal/{id}")
    public Sucursal buscarRepuesto(@PathVariable("id") Integer id) {
        Optional<Sucursal> sucursal = sucursalService.buscarSucursal(id);
        if (sucursal.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la sucursal");

        return sucursal.get();
    }


    /*@GetMapping("/repuestos")
    public Page<Repuesto> obtenerRepuestos(Pageable pageable) {
        return repuestoService.obtenerRepuestos(pageable);
    }

    @GetMapping("/repuestos/{id}")
    public Repuesto buscarRepuesto(@PathVariable("id") Integer id) {
        Optional<Repuesto> repuesto = repuestoService.buscarRepuesto(id);
        if (repuesto.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el repuesto");

        return repuesto.get();
    }

    @PostMapping("/repuestos")
    public Repuesto agregarRepuesto(@Valid @RequestBody Repuesto nuevoRepuesto) {
        return repuestoService.agregarRepuesto(nuevoRepuesto);
    }

    @DeleteMapping("/repuestos/{id}")
    public void borrarRepuesto(@PathVariable Integer id) {
        try {
            repuestoService.borrarRepuesto(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el repuesto");
        }
    }

    @PutMapping("/repuestos/{id}")
    public Repuesto editarRepuesto(@PathVariable Integer id, @Valid @RequestBody Repuesto modificado) {
        try {
            Repuesto repuesto = repuestoService.editarRepuesto(id, modificado);
            return repuesto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El repuesto no existe");
        }
    }*/
}
