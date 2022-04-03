package com.vtoebe.banco811.config;

import com.vtoebe.banco811.exceptions.ErroValidacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GerenciadorErro {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroValidacao> handler(MethodArgumentNotValidException exception){
        List<ErroValidacao> erros = new ArrayList<>();

        List<FieldError> camposErrados = exception.getBindingResult().getFieldErrors();

        camposErrados.forEach(e -> {
            ErroValidacao erroValidacao = new ErroValidacao(
                    e.getField(),
                    messageSource.getMessage(e, LocaleContextHolder.getLocale())
            );
            erros.add(erroValidacao);
        });

        return erros;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public ErroValidacao idNaoExiste(){
        return new ErroValidacao("id", "Usuario não existe");
    }

}
