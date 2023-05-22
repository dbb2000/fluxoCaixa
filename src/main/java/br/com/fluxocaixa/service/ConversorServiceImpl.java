package br.com.fluxocaixa.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fluxocaixa.dto.LancamentoDtoIn;
import br.com.fluxocaixa.dto.LancamentoDtoOut;
import br.com.fluxocaixa.interfaces.ConversorService;
import br.com.fluxocaixa.model.LancamentoModel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConversorServiceImpl implements ConversorService {

	private final ObjectMapper objMapper;
	
	@Override
	public LancamentoDtoOut modelToDtoOut(LancamentoModel model) {

		 return objMapper.convertValue(model, LancamentoDtoOut.class);
	}

	@Override
	public LancamentoModel dtoInToModel(LancamentoDtoIn dto) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		objMapper.setDateFormat(df);
		return objMapper.convertValue(dto, LancamentoModel.class);
	}

	@Override
	public List<LancamentoDtoOut> modelListToDtoList(List<LancamentoModel> list) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		objMapper.setDateFormat(df);
		return objMapper.convertValue(list, new TypeReference<List<LancamentoDtoOut>>(){});
	}

}
