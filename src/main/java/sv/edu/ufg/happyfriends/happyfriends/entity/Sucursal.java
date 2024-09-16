package sv.edu.ufg.happyfriends.happyfriends.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;*/
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sucursal {
    @Id
    @SequenceGenerator(name = "sucursal_id_seq", sequenceName = "sucursal_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sucursal_id_seq")
    private Integer sucId;

    @NotBlank
    @Column(nullable = false)
    private String sucCodigo;

    @NotBlank
    @Column(nullable = false)
    private String sucNombre;

    @NotBlank
    @Column(nullable = false)
    private String sucDireccion;

    @NotBlank
    @Column(nullable = false)
    private String sucTelefono;

    @NotBlank
    @Column(nullable = false)
    private Date fecActual;

    @NotBlank
    @Column(nullable = false)
    private String usuCodigo;

    /*@Column(nullable = false)
    @DecimalMin(value = "0.00")
    private BigDecimal precio;*/

}