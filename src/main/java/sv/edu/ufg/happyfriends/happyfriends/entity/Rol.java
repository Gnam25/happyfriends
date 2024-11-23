package sv.edu.ufg.happyfriends.happyfriends.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "sp_add_rol",
        procedureName = "sp_add_rol",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ROL_NOMBRE", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ROL_DESCRIPCION", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_INSERT_RESPONSE", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_get_roles",
        procedureName = "sp_get_roles",
        resultSetMappings = "allRolesMap"
)
@SqlResultSetMapping(
        name = "allRolesMap",
        classes = @ConstructorResult(
                targetClass = Rol.class,
                columns = {
                        @ColumnResult(name = "rolId", type = Integer.class),
                        @ColumnResult(name = "rolNombre", type = String.class),
                        @ColumnResult(name = "rolDescripcion", type = String.class)
                }
        )
)
public class Rol {

    @Id
    private Integer rolId;
    private String rolNombre;
    private String rolDescripcion;
    private String usuCorreltivo;
    private Integer empId;
    private String empNombre;
    private Date fecActual;
    private String usuCodigo;

    public Rol(Integer rolId, String rolNombre, String usuCorreltivo, Integer empId, String empNombre) {
        this.rolId = rolId;
        this.rolNombre = rolNombre;
        this.usuCorreltivo = usuCorreltivo;
        this.empId = empId;
        this.empNombre = empNombre;
    }
}
