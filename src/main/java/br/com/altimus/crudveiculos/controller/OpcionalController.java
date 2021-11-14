package br.com.altimus.crudveiculos.controller;

import br.com.altimus.crudveiculos.domain.Opcional;
import br.com.altimus.crudveiculos.service.OpcionalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/opcionais")
public class OpcionalController {

    private final OpcionalService opcionalService;

    @GetMapping
    public ResponseEntity<List<Opcional>> getAll(){
        return ResponseEntity.ok(opcionalService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opcional> findById(@PathVariable Long id){
        return ResponseEntity.ok(opcionalService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Opcional> save(@RequestBody Opcional opcional){
        return ResponseEntity.ok(opcionalService.save(opcional));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opcional> replace(@RequestBody Opcional opcional, @PathVariable Long id){
        return new ResponseEntity(opcionalService.replace(opcional,id),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         opcionalService.delete(id);
    }
}
