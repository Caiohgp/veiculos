package br.com.altimus.crudveiculos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDateTime dataDeCadastro;
    private String placa;
    private String renavam;
    private Double valor;
    @OneToOne(cascade = CascadeType.ALL)
    private Modelo modelo;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Opcional> opcional;

}
