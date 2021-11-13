package br.com.altimus.crudveiculos.repository;

import br.com.altimus.crudveiculos.domain.Opcional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionalRepository extends JpaRepository<Opcional,Long> {
}
