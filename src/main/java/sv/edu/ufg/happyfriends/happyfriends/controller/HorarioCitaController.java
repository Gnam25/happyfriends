package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.HorarioCita;
import sv.edu.ufg.happyfriends.happyfriends.service.HorarioCitaService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class HorarioCitaController {

    private final HorarioCitaService horarioCitaService;

    @PostMapping("/horarios")
    public List<HorarioCita> getHorarioCita(@RequestBody HorarioCita horarioCita) {
        List<HorarioCita> horarios = horarioCitaService.getHorarioCita(horarioCita.getHocFecha(), horarioCita.getEmpId());
        return horarios;
    }
}