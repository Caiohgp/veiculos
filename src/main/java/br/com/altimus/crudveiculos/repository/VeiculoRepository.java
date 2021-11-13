package br.com.altimus.crudveiculos.repository;

import br.com.altimus.crudveiculos.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo,Long> {
    List<Veiculo> findByNome(String nome);
}
