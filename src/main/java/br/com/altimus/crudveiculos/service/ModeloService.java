package br.com.altimus.crudveiculos.service;

import br.com.altimus.crudveiculos.domain.Modelo;
import br.com.altimus.crudveiculos.repository.ModeloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeloService {
    private final ModeloRepository modeloRepository;

    public List<Modelo> getAll(){
        return modeloRepository.findAll();
    }

    public Modelo findById(Long id){
        return modeloRepository.findById(id).get();
    }

    public Modelo save(Modelo modelo){
        return modeloRepository.save(modelo);
    }

    public Modelo replace(Modelo modelo,Long id){
        Optional<Modelo> modeloToBeReplaced = Optional.ofNullable(findById(id));
        if (modeloToBeReplaced.isPresent()){
            modeloToBeReplaced.get().setNome(modelo.getNome());
            return modeloRepository.save(modeloToBeReplaced.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        modeloRepository.delete(findById(id));
    }

}
