package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Empleado;
import sv.edu.ufg.happyfriends.happyfriends.service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @GetMapping("/obtenerEmpleados/{pueId}")
    public List<Empleado> obtenerEmpleadoList(@PathVariable("pueId") Integer pueId) {
        List<Empleado> empleados = empleadoService.obtenerEmpleadoList(pueId);
        return empleados;
    }

}