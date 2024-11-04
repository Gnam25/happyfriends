package sv.edu.ufg.happyfriends.happyfriends.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "sp_add_expediente",
        procedureName = "sp_add_expediente",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_NOMBRE", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_PROPIETARIO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_CORREO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_GENERO", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_COLOR", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_PESO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_TEMPERATURA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_FRECARDIACA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_DIRECCION", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_TELEFONO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_MEDREFERIDO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_RAZ_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_MAS_ID", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_INSERT_RESPONSE", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_update_expediente",
        procedureName = "sp_update_expediente",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_ID", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_NOMBRE", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_PROPIETARIO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_CORREO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_GENERO", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_COLOR", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_PESO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_TEMPERATURA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_FRECARDIACA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_DIRECCION", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_TELEFONO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_MEDREFERIDO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_RAZ_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_UPDATE_RESPONSE", type = String.class)
        }
)
public class Expediente {

    @Id
    //@SequenceGenerator(name = "sucursal_id_seq", sequenceName = "sucursal_id_seq", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sucursal_id_seq")
    private Integer sucId;

    @NotBlank
    @Column(nullable = false)
    private String masId;

    @NotBlank
    @Column(nullable = false)
    private String masNombre;

    @NotBlank
    @Column(nullable = false)
    private String masPropietario;

    @NotBlank
    @Column(nullable = false)
    private String masCorreo;

    @NotBlank
    @Column(nullable = false)
    private Integer masGenero;

    @NotBlank
    @Column(nullable = false)
    private String masColor;

    @NotBlank
    @Column(nullable = false)
    private String masPeso;

    @NotBlank
    @Column(nullable = false)
    private String masTemperatura;

    @NotBlank
    @Column(nullable = false)
    private String masFrecardiaca;

    @NotBlank
    @Column(nullable = false)
    private String masDireccion;

    @NotBlank
    @Column(nullable = false)
    private String masTelefono;

    private String masMedReferido;

    @NotBlank
    @Column(nullable = false)
    private Date fecActual;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;

    @ManyToOne
    @JoinColumn(name = "raza_razId", nullable = false) // Define la columna FK
    private Raza raza;
}
