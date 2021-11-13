package br.com.altimus.crudveiculos.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDeCadastro;
    private String placa;
    private String renavam;
    private Double valor;
    @OneToOne(cascade = CascadeType.ALL)
    private Modelo modelo;
    @OneToOne(cascade = CascadeType.ALL)
    private Opcional opcional;

}
