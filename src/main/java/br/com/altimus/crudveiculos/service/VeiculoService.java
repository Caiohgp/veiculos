package br.com.altimus.crudveiculos.service;

import br.com.altimus.crudveiculos.domain.Modelo;
import br.com.altimus.crudveiculos.domain.Opcional;
import br.com.altimus.crudveiculos.domain.Veiculo;
import br.com.altimus.crudveiculos.repository.VeiculoRepository;
import br.com.altimus.crudveiculos.schema.request.VeiculoRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ModeloService modeloService;
    private final OpcionalService opcionalService;

    public List<Veiculo> getAll(){
        return veiculoRepository.findAll();
    }

    public Veiculo findById(Long id){
        return veiculoRepository.findById(id).get();
    }

    public List<Veiculo> findByNome(String nome){
        return veiculoRepository.findByNome(nome);
    }

    public Veiculo save(VeiculoRequest veiculoRequest){

        Veiculo veiculo = new Veiculo();

        veiculo.setNome(veiculoRequest.getNome());
        veiculo.setDataDeCadastro(veiculoRequest.getDataDeCadastro());
        veiculo.setPlaca(veiculoRequest.getPlaca());
        veiculo.setRenavam(veiculoRequest.getRenavam());
        veiculo.setValor(veiculoRequest.getValor());
        veiculo.setOpcional(opcionalService.findByIdList(veiculoRequest.getOpcional()));
        veiculo.setModelo(modeloService.findById(veiculoRequest.getModelo()));

        return veiculoRepository.save(veiculo);
    }

    public Veiculo replace(VeiculoRequest veiculoRequest, Long id){

        Optional<Veiculo> veiculoToBeReplaced = Optional.ofNullable(findById(id));

        if (veiculoToBeReplaced.isPresent()){
            veiculoToBeReplaced.get().setNome(veiculoRequest.getNome());
            veiculoToBeReplaced.get().setModelo(modeloService.findById(veiculoRequest.getModelo()));
            veiculoToBeReplaced.get().setDataDeCadastro(veiculoRequest.getDataDeCadastro());
            veiculoToBeReplaced.get().setOpcional(opcionalService.findByIdList(veiculoRequest.getOpcional()));
            veiculoToBeReplaced.get().setPlaca(veiculoRequest.getPlaca());
            veiculoToBeReplaced.get().setRenavam(veiculoRequest.getRenavam());
            veiculoToBeReplaced.get().setValor(veiculoRequest.getValor());
            return veiculoRepository.save(veiculoToBeReplaced.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        veiculoRepository.delete(findById(id));
    }

}
