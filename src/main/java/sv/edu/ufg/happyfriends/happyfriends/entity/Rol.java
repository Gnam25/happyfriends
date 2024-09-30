package sv.edu.ufg.happyfriends.happyfriends.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rol {

    private Integer rolId;
    private String rolNombre;
    private String usuCorreltivo;

    public Rol(Integer rolId, String rolNombre, String usuCorreltivo) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.usuCorreltivo = usuCorreltivo;
    }
}
