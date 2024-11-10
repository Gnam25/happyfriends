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
    private Integer expId;
    private Integer masGenero;
    private String masPeso;
    private String masTemperatura;
    private String masFrecardiaca;
    private String masDireccion;
    private String masTelefono;
    private String masMedReferido;
    private String masCorreo;

    public ExpedienteSearchConverter(String masId, String masNombre, String timGrupo, String razNombre, String masColor, String masPropietario, Integer expId, Integer masGenero, String masPeso, String masTemperatura, String masFrecardiaca, String masDireccion, String masTelefono, String masMedReferido, String masCorreo) {
        this.masId = masId;
        this.masNombre = masNombre;
        this.timGrupo = timGrupo;
        this.razNombre = razNombre;
        this.masColor = masColor;
        this.masPropietario = masPropietario;
        this.expId = expId;
        this.masGenero = masGenero;
        this.masPeso = masPeso;
        this.masTemperatura = masTemperatura;
        this.masFrecardiaca = masFrecardiaca;
        this.masDireccion = masDireccion;
        this.masTelefono = masTelefono;
        this.masMedReferido = masMedReferido;
        this.masCorreo = masCorreo;
    }
}