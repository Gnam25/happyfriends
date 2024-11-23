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
        name = "sp_add_usuario",
        procedureName = "sp_add_usuario",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_EMAIL", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_PASSWORD", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_ESTADO", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_EMP_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ARC_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_ROL_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_CODIGO", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_INSERT_RESPONSE", type = String.class)
        }
)
public class Usuario {

        @Id
        private Integer usuId;

        @NotBlank
        @Column(nullable = false)
        private String usuEmail;

        @NotBlank
        @Column(nullable = false)
        private String usuPassword;

        @NotBlank
        @Column(nullable = false)
        private Integer usuEstado;

        @NotBlank
        @Column(nullable = false)
        private Integer empId;

        @NotBlank
        @Column(nullable = false)
        private Integer arcId;

        @NotBlank
        @Column(nullable = false)
        private Integer rolId;

        @NotBlank
        @Column(nullable = false)
        private Date fecCreacion;

        @NotBlank
        @Column(nullable = false)
        private Date fecActual;

        @NotBlank
        @Column(nullable = false)
        private String usuCodigo;
}
