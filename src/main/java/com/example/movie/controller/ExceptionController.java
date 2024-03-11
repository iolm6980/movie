package com.example.movie.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.Binding;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void methodConstraintViolationException(MethodArgumentNotValidException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String errorMsg = URLEncoder.encode(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        System.out.println("에러메시지" + errorMsg);
        response.sendRedirect(request.getRequestURL() + "?error=true&exception="+errorMsg);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> methodRuntimeException(RuntimeException e, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

