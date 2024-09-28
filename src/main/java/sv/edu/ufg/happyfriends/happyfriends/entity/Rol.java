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

    public Rol(Integer rolId, String rolNombre) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
    }
}
