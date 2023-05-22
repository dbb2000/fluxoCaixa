package br.com.fluxocaixa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fluxocaixa.model.SaldoModel;

@Repository
public interface SaldoRepository extends JpaRepository<SaldoModel, Integer> {

}
