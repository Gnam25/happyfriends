package sv.edu.ufg.happyfriends.happyfriends.entityConverters;

import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "sp_validar_usuario",
        procedureName = "sp_validar_usuario",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_EMAIL", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_USU_PASSWORD", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ROL_ID", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_ROL_NOMBRE", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_USU_CORRELATIVO", type = String.class)
        }
)
public class UsuarioConverter {
    private String usuEmail;
    private String usuPassword;

}
