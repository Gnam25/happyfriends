package sv.edu.ufg.happyfriends.happyfriends.entity;

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
        name = "sp_add_consulta",
        procedureName = "sp_add_consulta",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_EMP_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_EXP_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_SINTOMAS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_DIAGNOSTICO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_EXAMENES", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_OBSERVACIONES", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_PESO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_TEMPERATURA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_FRECARDIACA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_INSERT_RESPONSE", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_get_historialMedico",
        procedureName = "sp_get_historialMedico",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_EXP_ID", type = Integer.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_update_consulta",
        procedureName = "sp_update_consulta",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_SINTOMAS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_DIAGNOSTICO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_EXAMENES", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_OBSERVACIONES", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_PESO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_TEMPERATURA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_FRECARDIACA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_INSERT_RESPONSE", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_add_tratamiento",
        procedureName = "sp_add_tratamiento",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_TRT_MEDICAMENTO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_TRT_DOSIS", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_TRT_FRECUENCIA", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_TRT_DURACION", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_TRT_FECINICIO", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_INSERT_RESPONSE", type = String.class)
        }
)
@NamedStoredProcedureQuery(
        name = "sp_add_examen_resultado",
        procedureName = "sp_add_examen_resultado",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_CON_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_EXR_RESULTADO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_INSERT_RESPONSE", type = String.class)
        }
)
public class Consulta {

    @Id
    private Integer conId;

    @NotBlank
    @Column(nullable = false)
    private String conFecConsulta;

    @NotBlank
    @Column(nullable = false)
    private String conSintomas;

    @NotBlank
    @Column(nullable = false)
    private String conDiagnostico;

    @NotBlank
    @Column(nullable = false)
    private String conExamenes;

    @NotBlank
    @Column(nullable = false)
    private String conObservaciones;

    @NotBlank
    @Column(nullable = false)
    private String conPeso;

    @NotBlank
    @Column(nullable = false)
    private String conTemperatura;

    @NotBlank
    @Column(nullable = false)
    private String conFrecardiaca;

    @NotBlank
    @Column(nullable = false)
    private Integer empId;

    @NotBlank
    @Column(nullable = false)
    private String empNombre;

    @NotBlank
    @Column(nullable = false)
    private Integer expId;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;

    public Consulta(String conFecConsulta, String conSintomas, String conDiagnostico, String conExamenes, String conObservaciones, String empNombre) {
        this.conFecConsulta = conFecConsulta;
        this.conSintomas = conSintomas;
        this.conDiagnostico = conDiagnostico;
        this.conExamenes = conExamenes;
        this.conObservaciones = conObservaciones;
        this.empNombre = empNombre;
    }
}
