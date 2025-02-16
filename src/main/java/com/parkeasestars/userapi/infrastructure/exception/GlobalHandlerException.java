package com.parkeasestars.userapi.infrastructure.exception;

import com.parkeasestars.userapi.response.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import org.springframework.validation.FieldError;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiError> handlerConflictException(final ConflictException e, final WebRequest request) {
        String causaErro = (e.getCause() != null) ? e.getCause().getMessage() : "N/A";

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getDescription(false)
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(InvalidUsuarioDataException.class)
    public ResponseEntity<ApiError> handlerInvalidUsuarioDataException(final InvalidUsuarioDataException e, final WebRequest request) {
        String causaErro = (e.getCause() != null) ? e.getCause().getMessage() : "N/A";

        ApiError apiError = new ApiError(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, Object> response = new LinkedHashMap<>(); // Usando LinkedHashMap para garantir a ordem

        // Formatar o timestamp no padrão solicitado
        String formattedTimestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        response.put("timestamp", formattedTimestamp);
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("message", "Erro de validação");
        response.put("path", request.getDescription(false));

        // Captura os erros de validação no BindingResult
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> String.format("Campo '%s': %s", error.getField(), error.getDefaultMessage()))
                .toList(); // Listagem dos erros

        response.put("errors", errors); // Lista com todos os erros encontrados

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
