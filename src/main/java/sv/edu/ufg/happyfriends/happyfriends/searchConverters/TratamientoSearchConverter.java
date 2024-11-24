package sv.edu.ufg.happyfriends.happyfriends.searchConverters;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TratamientoSearchConverter {
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
    private Date trtFecInicio;

    public TratamientoSearchConverter(Integer trtId, String trtMedicamento, String trtDosis, String trtFrecuencia, String trtDuracion, Date trtFecInicio) {
        this.trtId = trtId;
        this.trtMedicamento = trtMedicamento;
        this.trtDosis = trtDosis;
        this.trtFrecuencia = trtFrecuencia;
        this.trtDuracion = trtDuracion;
        this.trtFecInicio = trtFecInicio;
    }
}
