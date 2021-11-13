package br.com.altimus.crudveiculos.schema.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponse {
    private String nome;
    private LocalDateTime dataDeCadastro;
    private String placa;
    private String renavam;
    private Double valor;
    private ModeloResponse modelo;
    private List<OpcionalResponse> opcional;
}
