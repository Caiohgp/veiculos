package br.com.altimus.crudveiculos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeCadastro;
    private String placa;
    private String renavam;
    private Double valor;
    @OneToOne(cascade = CascadeType.ALL)
    private Modelo modelo;
    @OneToOne(cascade = CascadeType.ALL)
    private Opcional opcional;

}
