package sv.edu.ufg.happyfriends.happyfriends.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExamenResultado {
    @Id
    private Integer exrId;

    @NotBlank
    @Column(nullable = false)
    private Date exrFecHora;

    @NotBlank
    @Column(nullable = false)
    private String exrResultado;

    @NotBlank
    @Column(nullable = false)
    private Integer conId;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;
}
