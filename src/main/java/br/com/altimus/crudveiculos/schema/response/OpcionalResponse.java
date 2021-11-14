package br.com.altimus.crudveiculos.schema.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpcionalResponse {
    private Long id;
    private String nome;
}
