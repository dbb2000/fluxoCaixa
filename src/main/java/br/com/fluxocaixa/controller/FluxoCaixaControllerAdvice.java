package br.com.fluxocaixa.controller;

import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.fluxocaixa.exceptions.ConversaoException;

@ControllerAdvice
public class FluxoCaixaControllerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lançamento não encontrado.");
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<String> handleInvalidFormatException(InvalidFormatException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Opções Válidas são: CREDITO ou DEBITO");
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleInvalidFormatException(ConstraintViolationException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	@ExceptionHandler(ConversaoException.class)
	public ResponseEntity<String> handleConversaoException(ConversaoException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	}
	
	

}
