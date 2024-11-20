package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Raza;
import sv.edu.ufg.happyfriends.happyfriends.service.RazaService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class RazaController {

    private final RazaService razaService;

    @GetMapping("/obtenerRazas/{timId}")
    public List<Raza> obtenerTipoMascotaList(@PathVariable("timId") Integer timId) {
        List<Raza> razas = razaService.obtenerRazaList(timId);
        return razas;
    }
    /*@PostMapping("/repuestos")
    public Expediente insertExpediente(@Valid @RequestBody Expediente nuevoRepuesto) {
        return expedienteService.insertExpediente(nuevoRepuesto);
    }*/
}
