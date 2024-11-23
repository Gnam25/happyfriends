package sv.edu.ufg.happyfriends.happyfriends.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.edu.ufg.happyfriends.happyfriends.utils.CustomDateDeserializer;

import java.util.Date;
import java.util.List;

//@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tratamiento {

    @NotBlank
    @Column(nullable = false)
    private Integer conId;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;

    private List<TratamientoDetalle> tratamientoDetalle;


    @Getter
    @Setter
    public static class TratamientoDetalle {
        @Id
        private Integer trtId;

        @NotBlank
        @Column(nullable = false)
        private String trtMedicamento;

        @NotBlank
        @Column(nullable = false)
        private String trtDosis;

        @NotBlank
        @Column(nullable = false)
        private String trtFrecuencia;

        @NotBlank
        @Column(nullable = false)
        private String trtDuracion;

        @NotBlank
        @Column(nullable = false)
        @JsonDeserialize(using = CustomDateDeserializer.class)
        private Date trtFecInicio;

    }
}
