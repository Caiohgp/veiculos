package br.com.altimus.crudveiculos.service;

import br.com.altimus.crudveiculos.domain.Veiculo;
import br.com.altimus.crudveiculos.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoService {
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAll(){
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> findById(Long id){
        return veiculoRepository.findById(id);
    }

    public List<Veiculo> findByName(String nome){
        return veiculoRepository.findByName();
    }

    public Veiculo save(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

}
