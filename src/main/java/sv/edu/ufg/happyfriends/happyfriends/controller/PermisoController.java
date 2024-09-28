package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entity.Permiso;
import sv.edu.ufg.happyfriends.happyfriends.service.ExpedienteService;
import sv.edu.ufg.happyfriends.happyfriends.service.PermisosService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class PermisoController {

    private final PermisosService permisosService;

    @GetMapping("/permisos/{idRol}")
    public List<Permiso> getPermisobyRol(@PathVariable("idRol") Integer idRol) {
        List<Permiso> permisos = permisosService.getPermisobyRol(idRol);
        return permisos;
    }
    /*@PostMapping("/repuestos")
    public Expediente insertExpediente(@Valid @RequestBody Expediente nuevoRepuesto) {
        return expedienteService.insertExpediente(nuevoRepuesto);
    }*/
}
