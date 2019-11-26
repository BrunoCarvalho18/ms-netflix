package com.netflix.filme.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.netflix.filme.gateway.RetornoJson;

@ControllerAdvice
public class ExcpetionHandlerController {
	
	@ExceptionHandler(FilmeException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ResponseBody
	public RetornoJson process(RuntimeException ex) {
        return new RetornoJson(ex.getMessage());
    }

}
