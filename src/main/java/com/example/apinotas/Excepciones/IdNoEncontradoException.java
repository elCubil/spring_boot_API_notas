package com.example.apinotas.Excepciones;

public class IdNoEncontradoException extends RuntimeException{
    public IdNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
