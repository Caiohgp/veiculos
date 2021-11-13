package br.com.altimus.crudveiculos.service;

import br.com.altimus.crudveiculos.domain.Veiculo;
import br.com.altimus.crudveiculos.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeiculoService {
    private final VeiculoRepository veiculoRepository;

    public List<Veiculo> getAll(){
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Long id){
        return veiculoRepository.findById(id).get();
    }

    public List<Veiculo> findByNome(String nome){
        return veiculoRepository.findByNome(nome);
    }

    public Veiculo save(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public Veiculo replace(Veiculo veiculo,Long id){
        Optional<Veiculo> veiculoToBeReplaced = Optional.ofNullable(findById(id));
        if (veiculoToBeReplaced.isPresent()){
            veiculoToBeReplaced.get().setNome(veiculo.getNome());
            veiculoToBeReplaced.get().setModelo(veiculo.getModelo());
            veiculoToBeReplaced.get().setDataDeCadastro(veiculo.getDataDeCadastro());
            veiculoToBeReplaced.get().setOpcional(veiculo.getOpcional());
            veiculoToBeReplaced.get().setPlaca(veiculo.getPlaca());
            veiculoToBeReplaced.get().setRenavam(veiculo.getRenavam());
            veiculoToBeReplaced.get().setValor(veiculo.getValor());
            return veiculoRepository.save(veiculoToBeReplaced.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        veiculoRepository.delete(findById(id));
    }

}
