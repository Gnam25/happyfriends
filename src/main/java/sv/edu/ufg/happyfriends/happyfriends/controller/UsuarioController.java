package sv.edu.ufg.happyfriends.happyfriends.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sv.edu.ufg.happyfriends.happyfriends.entity.*;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.PostResponseConverter;
import sv.edu.ufg.happyfriends.happyfriends.entityConverters.UsuarioConverter;
import sv.edu.ufg.happyfriends.happyfriends.service.UsuarioService;

@RestController
@RequestMapping("/happyfriends")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/signin")
    public Rol getPermisobyRol(@Valid @RequestBody UsuarioConverter usuario) {
        return usuarioService.validarUsuario(usuario.getUsuEmail(), usuario.getUsuPassword());
    }

    @PostMapping("/nuevoUsuario")
    public PostResponseConverter insertUsuario(@RequestBody Usuario usuario) {
        return usuarioService.insertUsuario(usuario);
    }

}
