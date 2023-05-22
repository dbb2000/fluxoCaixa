package br.com.fluxocaixa.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.stereotype.Service;

import br.com.fluxocaixa.dto.LancamentoDtoIn;
import br.com.fluxocaixa.interfaces.ValidadorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidadorServiceImpl implements ValidadorService {

	private final Validator validator;
	
	@Override
	public void validarDto(LancamentoDtoIn dto) {
		
    	Set<ConstraintViolation<LancamentoDtoIn>>  violations = validator.validate(dto);
    	if (!violations.isEmpty()) {
    	  throw new ConstraintViolationException(violations);
    	}

	}
}
