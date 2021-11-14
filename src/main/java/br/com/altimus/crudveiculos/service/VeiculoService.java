package br.com.altimus.crudveiculos.service;

import br.com.altimus.crudveiculos.domain.Opcional;
import br.com.altimus.crudveiculos.domain.Veiculo;
import br.com.altimus.crudveiculos.repository.VeiculoRepository;
import br.com.altimus.crudveiculos.schema.request.VeiculoRequest;
import br.com.altimus.crudveiculos.schema.response.ModeloResponse;
import br.com.altimus.crudveiculos.schema.response.OpcionalResponse;
import br.com.altimus.crudveiculos.schema.response.VeiculoResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ModeloService modeloService;
    private final OpcionalService opcionalService;

    public Page<Veiculo> findAll(Pageable pageable){
        return veiculoRepository.findAll(pageable);
    }

    public VeiculoResponse findById(Long id){

        VeiculoResponse veiculoResponse = new VeiculoResponse();

        Optional<Veiculo> findVeiculo = veiculoRepository.findById(id);

        veiculoResponse.setNome(findVeiculo.get().getNome());
        veiculoResponse.setDataDeCadastro(findVeiculo.get().getDataDeCadastro());
        veiculoResponse.setPlaca(findVeiculo.get().getPlaca());
        veiculoResponse.setRenavam(findVeiculo.get().getRenavam());
        veiculoResponse.setValor(findVeiculo.get().getValor());

        ModeloResponse modeloResponse = new ModeloResponse();
        modeloResponse.setId(findVeiculo.get().getModelo().getId());
        modeloResponse.setNome(findVeiculo.get().getModelo().getNome());

        veiculoResponse.setModelo(modeloResponse);

        List<OpcionalResponse> listaParseada = new ArrayList<>();
        for (Opcional objLista : findVeiculo.get().getOpcional()){
            OpcionalResponse objListaResponse = new OpcionalResponse();
            objListaResponse.setId(objLista.getId());
            objListaResponse.setNome(objLista.getNome());

            listaParseada.add(objListaResponse);
        }
        veiculoResponse.setOpcional(listaParseada);

        return veiculoResponse;
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

        Optional<Veiculo> veiculoToBeReplaced = veiculoRepository.findById(id);

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
        veiculoRepository.deleteById(id);
    }

}
