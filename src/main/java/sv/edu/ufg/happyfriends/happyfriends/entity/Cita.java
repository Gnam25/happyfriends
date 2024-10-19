package sv.edu.ufg.happyfriends.happyfriends.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.edu.ufg.happyfriends.happyfriends.utils.CustomTimeDeserializer;

import java.sql.Time;
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
@NamedStoredProcedureQuery(
        name = "sp_update_cita",
        procedureName = "sp_update_cita",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_id", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fechahora", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hora", type = Time.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_propietario", type = String.class)
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
    private String ctaHora;

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