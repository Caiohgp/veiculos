package br.com.altimus.crudveiculos.service;

import br.com.altimus.crudveiculos.domain.Opcional;
import br.com.altimus.crudveiculos.repository.OpcionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OpcionalService {
    private final OpcionalRepository opcionalRepository;

    public List<Opcional> getAll(){
        return opcionalRepository.findAll();
    }

    public Opcional findById(Long id){
        return opcionalRepository.findById(id).get();
    }

    public List<Opcional> findByIdList(List<Long> id){
        return opcionalRepository.findAllById(id);
    }

    public Opcional save(Opcional opcional){
        return opcionalRepository.save(opcional);
    }

    public Opcional replace(Opcional opcional, Long id){
        Optional<Opcional> opcionalToBeReplaced = Optional.ofNullable(findById(id));
        if (opcionalToBeReplaced.isPresent()){
            opcionalToBeReplaced.get().setNome(opcional.getNome());
            return opcionalRepository.save(opcionalToBeReplaced.get());
        }
        throw new RuntimeException();
    }

    public void delete(Long id){
        opcionalRepository.delete(findById(id));
    }

}
