package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.HorarioCita;
import sv.edu.ufg.happyfriends.happyfriends.entity.Permiso;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.UsuarioConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.HorarioCitaService;
import sv.edu.ufg.happyfriends.happyfriends.service.PermisosService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class HorarioCitaController {

    private final HorarioCitaService horarioCitaService;

    @GetMapping("/horarios")
    public List<HorarioCita> getHorarioCita(@RequestBody HorarioCita horarioCita) {
        List<HorarioCita> horarios = horarioCitaService.getHorarioCita(horarioCita.getHocFecha(), horarioCita.getEmpId());
        return horarios;
    }
    /*@PostMapping("/repuestos")
    public Expediente insertExpediente(@Valid @RequestBody Expediente nuevoRepuesto) {
        return expedienteService.insertExpediente(nuevoRepuesto);
    }*/
}