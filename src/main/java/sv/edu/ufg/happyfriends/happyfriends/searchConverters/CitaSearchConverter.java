package sv.edu.ufg.happyfriends.happyfriends.searchConverters;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
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
        name = "sp_busqueda_cita",
        procedureName = "sp_busqueda_cita",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_fecha", type = Date.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_hora", type = Time.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_propietario", type = String.class)
        }
)
public class CitaSearchConverter {

    private Integer id;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date fecha;
    @JsonDeserialize(using = CustomTimeDeserializer.class)
    private Time hora;
    private String propietario;
    private String veterinario;

    public CitaSearchConverter(Integer id, Date fecha, Time hora, String propietario, String veterinario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.propietario = propietario;
        this.veterinario = veterinario;
    }
}