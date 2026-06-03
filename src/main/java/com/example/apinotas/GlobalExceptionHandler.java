package com.example.apinotas;


import com.example.apinotas.Excepciones.IdNoEncontradoException;
import com.example.apinotas.Excepciones.TituloRepetidoException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IdNoEncontradoException.class})
    public ProblemDetail IdNoEncontradoHandler(IdNoEncontradoException ex){
        ProblemDetail problemDetail=ProblemDetail.forStatus(401);
        problemDetail.setTitle("Id no existe");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;

    }

    @ExceptionHandler({TituloRepetidoException.class})
    public ProblemDetail TituloRepetidoHandler(TituloRepetidoException ex){
        ProblemDetail problemDetail=ProblemDetail.forStatus(400);
        problemDetail.setTitle("request erroneo, se ingreso un titulo ya existente");
        problemDetail.setDetail(ex.getMessage());
        return problemDetail;

    }
}
