package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Consulta;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.ConsultaService;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class ConsultaController {
    private final ConsultaService consultaService;

    @PostMapping("/nuevaConsulta")
    public PostResponseConverter insertConsulta(@RequestBody Consulta consulta) {
        return consultaService.insertConsulta(consulta);
        //return ResponseEntity.ok("Expediente creado con exito");
    }
}
