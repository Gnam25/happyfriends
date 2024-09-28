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
        name = "sp_get_tipo_mascota",
        procedureName = "sp_get_tipo_mascota",
        resultSetMappings = "TPMMap"
)
@SqlResultSetMapping(
        name = "TPMMap",
        classes = @ConstructorResult(
                targetClass = TipoMascota.class,
                columns = {
                        @ColumnResult(name = "timId", type = Integer.class),
                        @ColumnResult(name = "timGrupo", type = String.class)
                }
        )
)
public class TipoMascota {
    @Id
    private Integer timId;

    @NotBlank
    @Column(nullable = false)
    private String timCodigo;

    @NotBlank
    @Column(nullable = false)
    private String timGrupo;

    @NotBlank
    @Column(nullable = false)
    private String timDescripcion;

    @NotBlank
    @Column(nullable = false)
    private Date fecActual;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;

    //Un tipo de mascota tiene muchas razas
    @OneToMany(mappedBy = "tipoMascota", cascade = CascadeType.ALL)
    private List<Raza> raza;

}
