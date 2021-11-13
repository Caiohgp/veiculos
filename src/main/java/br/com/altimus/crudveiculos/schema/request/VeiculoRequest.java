package br.com.altimus.crudveiculos.schema.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeiculoRequest {
    private String nome;
    private LocalDateTime dataDeCadastro;
    private String placa;
    private String renavam;
    private Double valor;
    private Long modelo;
    private List<Long> opcional;
}
