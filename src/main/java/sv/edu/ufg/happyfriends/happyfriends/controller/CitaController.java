package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Cita;
import sv.edu.ufg.happyfriends.happyfriends.entity.Empleado;
import sv.edu.ufg.happyfriends.happyfriends.searchConverters.CitaSearchConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.CitaService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class CitaController {

    private final CitaService citaService;

    @PostMapping("/crearCita")
    public ResponseEntity<String> crearCita(@RequestBody Cita cita) {
        citaService.crearCita(cita);
        return ResponseEntity.ok("Cita creada con exito");
    }

    @PostMapping("/actualizarCita")
    public ResponseEntity<String> actualizarCita(@RequestBody Cita cita) {
        citaService.actualizarCita(cita);
        return ResponseEntity.ok("Cita actualizada con exito");
    }

    @PostMapping("/buscarCita")
    public List<CitaSearchConverter> buscarCitaList(@RequestBody CitaSearchConverter cita) {
        List<CitaSearchConverter> citas = citaService.buscarCitaList(cita);
        return citas;
    }

    @PostMapping("/cancelarCita")
    public String cancelarCita(@RequestBody Cita cita) {
        String response = citaService.cancelarCita(cita);
        return response;
    }
}
