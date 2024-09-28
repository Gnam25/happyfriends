package sv.edu.ufg.happyfriends.happyfriends.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class HorarioCita {

    private Date hocFecha;
    private String hocHorario;
    private int empId;


}
