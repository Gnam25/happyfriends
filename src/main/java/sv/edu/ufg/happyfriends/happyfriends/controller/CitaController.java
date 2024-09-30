package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Cita;
import sv.edu.ufg.happyfriends.happyfriends.service.CitaService;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class CitaController {

    private final CitaService citaService;

    @PostMapping("/crearCita")
    public ResponseEntity<String> crearCita(@RequestBody Cita cita) {
        citaService.crearCita(cita);
        return ResponseEntity.ok("Cita creada con exito");
    }
}
