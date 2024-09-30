package sv.edu.ufg.happyfriends.happyfriends.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "sp_add_cita",
        procedureName = "sp_add_cita",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CTA_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CTA_FECHORA", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CTA_ESTADO", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "CTA_PROPIETARIO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "EMP_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "FEC_ACTUAL", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "USU_CODIGO", type = String.class)
        }
)
public class Cita {

    @Id
    //@SequenceGenerator(name = "sucursal_id_seq", sequenceName = "sucursal_id_seq", allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sucursal_id_seq")
    private Integer ctaCodigo;

    @NotBlank
    @Column(nullable = false)
    private String ctaFecHora;

    @NotBlank
    @Column(nullable = false)
    private Integer ctaEstado;

    @NotBlank
    @Column(nullable = false)
    private String ctaPropietario;

    @NotBlank
    @Column(nullable = false)
    private Integer empId;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;

}