package sv.edu.ufg.happyfriends.happyfriends.searchConverters;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.edu.ufg.happyfriends.happyfriends.utils.CustomDateDeserializer;
import sv.edu.ufg.happyfriends.happyfriends.utils.CustomTimeDeserializer;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

@NamedStoredProcedureQuery(
        name = "sp_busqueda_expediente",
        procedureName = "sp_busqueda_expediente",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_ID", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_MAS_NOMBRE", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_PROPIETARIO", type = String.class)
        }
)
public class ExpedienteSearchConverter {

    private String masId;
    private String masNombre;
    private String timGrupo;
    private String razNombre;
    private String masColor;
    private String masPropietario;



    public ExpedienteSearchConverter(String masId, String masNombre, String timGrupo, String razNombre, String masColor, String masPropietario) {
        this.masId = masId;
        this.masNombre = masNombre;
        this.timGrupo = timGrupo;
        this.razNombre = razNombre;
        this.masColor = masColor;
        this.masPropietario = masPropietario;
    }
}