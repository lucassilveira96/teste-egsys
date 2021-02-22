package com.egsys.teste.advice

import com.egsys.teste.exception.PessoaNotFoundException
import com.egsys.teste.model.ErrorMessage
import org.springframework.boot.json.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun JsonParseExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception):
            ResponseEntity<ErrorMessage> {
        return ResponseEntity(ErrorMessage("Json Error", exception.message ?: "Invalid Json"), HttpStatus.BAD_REQUEST)
    }
    @ExceptionHandler(PessoaNotFoundException::class)
    fun PessoaNotFoundExceptionHandler(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception):
            ResponseEntity<ErrorMessage>{
        return ResponseEntity(ErrorMessage("Pessoa nao localizada", exception.message !!), HttpStatus.NOT_FOUND)
    }
}