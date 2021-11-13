package br.com.altimus.crudveiculos.controller;

import br.com.altimus.crudveiculos.domain.Modelo;
import br.com.altimus.crudveiculos.service.ModeloService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    @GetMapping
    public ResponseEntity<List<Modelo>> getAll(){
        return ResponseEntity.ok(modeloService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable Long id){
        return ResponseEntity.ok(modeloService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Modelo> save(@RequestBody Modelo modelo){
        return ResponseEntity.ok(modeloService.save(modelo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> replace(@RequestBody Modelo modelo, @PathVariable Long id){
        return new ResponseEntity(modeloService.replace(modelo,id),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         modeloService.delete(id);
    }
}
