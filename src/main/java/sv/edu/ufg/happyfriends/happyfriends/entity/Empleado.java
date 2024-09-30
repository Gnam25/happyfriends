package sv.edu.ufg.happyfriends.happyfriends.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "sp_get_veterinario",
        procedureName = "sp_get_veterinario",
        resultSetMappings = "empleadosMap",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_PUE_ID", type = Integer.class)
        }
)
@SqlResultSetMapping(
        name = "empleadosMap",
        classes = @ConstructorResult(
                targetClass = Empleado.class,
                columns = {
                        @ColumnResult(name = "empId", type = Integer.class),
                        @ColumnResult(name = "empNombre", type = String.class),
                        @ColumnResult(name = "empApellido", type = String.class)
                }
        )
)
public class Empleado {

    @Id
    private Integer empId;

    @NotBlank
    @Column(nullable = false)
    private String empNombre;

    @NotBlank
    @Column(nullable = false)
    private String empApellido;

}
