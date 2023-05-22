package br.com.fluxocaixa.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fluxocaixa.model.LancamentoModel;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoModel, Long> {

	List<LancamentoModel> findByDataLancamento(Date dataLancamento);
}
