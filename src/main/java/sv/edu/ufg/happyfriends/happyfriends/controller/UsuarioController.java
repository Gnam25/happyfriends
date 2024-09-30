package sv.edu.ufg.happyfriends.happyfriends.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.Expediente;
import sv.edu.ufg.happyfriends.happyfriends.entity.Permiso;
import sv.edu.ufg.happyfriends.happyfriends.entity.Rol;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.UsuarioConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.PermisosService;
import sv.edu.ufg.happyfriends.happyfriends.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/signin")
    public Rol getPermisobyRol(@Valid @RequestBody UsuarioConverter usuario) {
        return usuarioService.validarUsuario(usuario.getUsuEmail(), usuario.getUsuPassword());
        /*List<Rol> roles = usuarioService.validarUsuario(usuario.getEmail(), usuario.getPassword());
        Rol rol = new Rol();
        if (roles.size() > 0)
            {
                rol = roles.get(0);
            }
        return rol;*/
        }

}
