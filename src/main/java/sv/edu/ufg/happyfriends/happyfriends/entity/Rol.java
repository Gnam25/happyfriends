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
    private Integer empId;
    private String empNombre;

    public Rol(Integer rolId, String rolNombre, String usuCorreltivo, Integer empId, String empNombre) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.usuCorreltivo = usuCorreltivo;
        this.empId = empId;
        this.empNombre = empNombre;
    }
}
