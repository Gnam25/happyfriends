package sv.edu.ufg.happyfriends.happyfriends.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Consulta;
import sv.edu.ufg.happyfriends.happyfriends.entity.ExamenResultado;
import sv.edu.ufg.happyfriends.happyfriends.entity.Tratamiento;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.ConsultaSearchConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class ConsultaController {
    private final ConsultaService consultaService;

    @PostMapping("/nuevaConsulta")
    public PostResponseConverter insertConsulta(@RequestBody Consulta consulta) {
        return consultaService.insertConsulta(consulta);
    }

    @GetMapping("/buscarHistorialMedico/{expId}")
    public List<ConsultaSearchConverter> buscarHistorialMedicoList(@PathVariable("expId") Integer expId) {
        List<ConsultaSearchConverter> consultas = consultaService.buscarHistorialMedicoList(expId);
        return consultas;
    }

    @PostMapping("/actualizarConsulta")
    public PostResponseConverter actualizarConsulta(@RequestBody Consulta consulta) {
        return consultaService.actualizarConsulta(consulta);
    }
    @PostMapping("/agregarTratamiento")
    public PostResponseConverter insertTratamiento(@RequestBody Tratamiento tratamiento) {
        return consultaService.insertTratamiento(tratamiento);
    }

    @PostMapping("/agregarResultadoExamen")
    public PostResponseConverter insertResultadoExamen(@RequestBody ExamenResultado examen) {
        return consultaService.insertResultadoExamen(examen);
    }
}
