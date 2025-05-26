package com.dam.ApiRestAgenciaViajes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase GlobalExceptionHandler para manejar en el frontend los errores lanzados desde la apliación:
 *
 *     Atrapa errores lanzados desde cualquier controlador (o servicio indirectamente) que usen ResponseStatusException.
 *
 *     Evita que el servidor responda con un error técnico y poco claro.
 *
 *     Devuelve un JSON claro y estructurado con el código y el mensaje del error.
 *
 *     Facilita que el frontend pueda mostrar mensajes de error personalizados a los usuarios.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> handleResponseStatusException(ResponseStatusException ex) {
        Map<String, Object> error = new HashMap<>();
        int statusCode = ex.getStatusCode().value();
        error.put("status", statusCode);

        HttpStatus httpStatus = HttpStatus.resolve(statusCode);
        error.put("error", httpStatus != null ? httpStatus.getReasonPhrase() : "Error");

        error.put("message", ex.getReason() != null ? ex.getReason() : "Error inesperado");

        return new ResponseEntity<>(error, ex.getStatusCode());
    }
}
