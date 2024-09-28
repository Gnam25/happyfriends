package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entity.TipoMascota;
import sv.edu.ufg.happyfriends.happyfriends.service.ExpedienteService;
import sv.edu.ufg.happyfriends.happyfriends.service.TipoMascotaService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class TipoMascotaController {

    private final TipoMascotaService tipoMascotaService;

    @GetMapping("/obtenerTipoMascotas")
    public List<TipoMascota> obtenerTipoMascotaList() {
        List<TipoMascota> tipoMascotas = tipoMascotaService.obtenerTipoMascotaList();
        return tipoMascotas;
    }
    /*@PostMapping("/repuestos")
    public Expediente insertExpediente(@Valid @RequestBody Expediente nuevoRepuesto) {
        return expedienteService.insertExpediente(nuevoRepuesto);
    }*/
}
