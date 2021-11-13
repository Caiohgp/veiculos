package br.com.altimus.crudveiculos.controller;

import br.com.altimus.crudveiculos.domain.Veiculo;
import br.com.altimus.crudveiculos.service.VeiculoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> getAll(){
        return ResponseEntity.ok(veiculoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> findById(@PathVariable Long id){
        return ResponseEntity.ok(veiculoService.findById(id));
    }

    @GetMapping("/veiculo")
    public ResponseEntity<List<Veiculo>> findByName(@RequestParam String nome){
        return ResponseEntity.ok(veiculoService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Veiculo> save(@RequestBody Veiculo veiculo){
        return ResponseEntity.ok(veiculoService.save(veiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> replace(@RequestBody Veiculo veiculo, @PathVariable Long id){
        return new ResponseEntity(veiculoService.replace(veiculo,id),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         veiculoService.delete(id);
    }
}
