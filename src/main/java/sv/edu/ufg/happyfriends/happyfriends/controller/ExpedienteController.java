package sv.edu.ufg.happyfriends.happyfriends.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.CitaSearchConverter;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.ExpedienteSearchConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.ExpedienteService;

import java.util.List;

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

    @PostMapping("/actualizarExpediente")
    public PostResponseConverter actualizarExpediente(@RequestBody Expediente expediente) {
        return expedienteService.actualizarExpediente(expediente);
    }

    @PostMapping("/buscarExpediente")
    public List<ExpedienteSearchConverter> buscarCitaList(@RequestBody ExpedienteSearchConverter expediente) {
        List<ExpedienteSearchConverter> expedientes = expedienteService.buscarExpedienteList(expediente);
        return expedientes;
    }
}
