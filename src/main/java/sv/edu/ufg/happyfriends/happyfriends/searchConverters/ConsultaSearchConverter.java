package sv.edu.ufg.happyfriends.happyfriends.searchConverters;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public ConsultaSearchConverter(String conFecConsulta, String conSintomas, String conDiagnostico, String conExamenes,
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
    }
}
