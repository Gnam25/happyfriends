package sv.edu.ufg.happyfriends.happyfriends.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.edu.ufg.happyfriends.happyfriends.utils.CustomDateDeserializer;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HorarioCita {

    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date hocFecha;
    private String hocHorario;
    private int empId;


}
