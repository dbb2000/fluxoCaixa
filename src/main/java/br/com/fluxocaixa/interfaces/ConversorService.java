package br.com.fluxocaixa.interfaces;

import java.util.List;

import br.com.fluxocaixa.dto.LancamentoDtoIn;
import br.com.fluxocaixa.dto.LancamentoDtoOut;
import br.com.fluxocaixa.model.LancamentoModel;

public interface ConversorService {

	LancamentoDtoOut modelToDtoOut(LancamentoModel model);
	LancamentoModel dtoInToModel(LancamentoDtoIn dto);
	List<LancamentoDtoOut> modelListToDtoList(List<LancamentoModel> list);
}
