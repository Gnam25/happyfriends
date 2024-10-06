package sv.edu.ufg.happyfriends.happyfriends.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.ExpedienteService;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class ExpedienteController {

    private final ExpedienteService expedienteService;

    @PostMapping("/nuevoExpediente")
    public PostResponseConverter insertExpediente(@RequestBody Expediente expediente) {
        return expedienteService.insertExpediente(expediente);
        //return ResponseEntity.ok("Expediente creado con exito");
    }
}
