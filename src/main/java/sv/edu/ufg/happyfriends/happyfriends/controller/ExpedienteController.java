package sv.edu.ufg.happyfriends.happyfriends.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.service.ExpedienteService;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class ExpedienteController {

    private final ExpedienteService expedienteService;

    @PostMapping("/nuevoExpediente")
    public ResponseEntity<String> insertExpediente(@RequestBody Expediente expediente) {
        expedienteService.insertExpediente(expediente);
        return ResponseEntity.ok("Expediente creado con exito");
    }
    /*@PostMapping("/repuestos")
    public Expediente insertExpediente(@Valid @RequestBody Expediente nuevoRepuesto) {
        return expedienteService.insertExpediente(nuevoRepuesto);
    }*/
}
