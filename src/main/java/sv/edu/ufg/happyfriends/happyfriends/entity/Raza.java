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
        name = "sp_get_razas",
        procedureName = "sp_get_razas",
        resultSetMappings = "razaMap",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_idmascota", type = Integer.class)
        }
)
@SqlResultSetMapping(
        name = "razaMap",
        classes = @ConstructorResult(
                targetClass = Raza.class,
                columns = {
                        @ColumnResult(name = "razId", type = Integer.class),
                        @ColumnResult(name = "razNombre", type = String.class)
                }
        )
)
public class Raza {

    @Id
    private Integer razId;

    @NotBlank
    @Column(nullable = false)
    private String razCodigo;

    @NotBlank
    @Column(nullable = false)
    private String razNombre;

    @NotBlank
    @Column(nullable = false)
    private String razDescripcion;

    @NotBlank
    @Column(nullable = false)
    private Date fecActual;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;

    @OneToMany(mappedBy = "raza", cascade = CascadeType.ALL)
    private List<Expediente> expediente;

    //Muchas razas pertenecen a un tipo de mascota (especie)
    @ManyToOne
    @JoinColumn(name = "tipoMascota_timId", nullable = false) // Define la columna FK
    private TipoMascota tipoMascota;
}
