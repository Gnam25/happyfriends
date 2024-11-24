package sv.edu.ufg.happyfriends.happyfriends.searchConverters;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.edu.ufg.happyfriends.happyfriends.entity.Tratamiento;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class ConsultaSearchConverter {
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

    @NotBlank
    @Column(nullable = false)
    private String masPeso;

    @NotBlank
    @Column(nullable = false)
    private String masTemperatura;

    @NotBlank
    @Column(nullable = false)
    private String masFreCardiaca;

    private List<TratamientoSearchConverter> tratamientos;

    public ConsultaSearchConverter(Integer conId, String conFecConsulta, String conSintomas, String conDiagnostico, String conExamenes,
                                   String conObservaciones, String empNombre, String masPeso, String masTemperatura, String masFreCardiaca) {
        this.conFecConsulta = conFecConsulta;
        this.conSintomas = conSintomas;
        this.conDiagnostico = conDiagnostico;
        this.conExamenes = conExamenes;
        this.conObservaciones = conObservaciones;
        this.empNombre = empNombre;
        this.masPeso = masPeso;
        this.masTemperatura = masTemperatura;
        this.masFreCardiaca = masFreCardiaca;
        this.conId = conId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaSearchConverter that = (ConsultaSearchConverter) o;
        return Objects.equals(conId, that.conId); // Compara los atributos relevantes
    }
}
