package sv.edu.ufg.happyfriends.happyfriends.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.RolService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class RolController {
    private final RolService rolService;

    @PostMapping("/nuevoRol")
    public PostResponseConverter insertRol(@RequestBody Rol rol) {
        return rolService.insertRol(rol);
    }

    @GetMapping("/obtenerRoles")
    public List<Rol> obtenerRolesList() {
        List<Rol> roles = rolService.obtenerRolesList();
        return roles;
    }
}
