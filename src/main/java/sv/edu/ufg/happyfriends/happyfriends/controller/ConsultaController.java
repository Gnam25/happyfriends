package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Consulta;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.ExpedienteSearchConverter;
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
    public List<Consulta> buscarHistorialMedicoList(@PathVariable("expId") Integer expId) {
        List<Consulta> consultas = consultaService.buscarHistorialMedicoList(expId);
        return consultas;
    }

}
