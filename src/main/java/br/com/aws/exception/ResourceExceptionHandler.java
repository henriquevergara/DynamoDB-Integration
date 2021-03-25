package br.com.aws.exception;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ResourceExceptionHandler  {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<StandardError> httpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {

        log.error("Método Http não suportado");
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
                "Exceção Método Http Não Suportado.", e.getMessage(), 0);

        log.error(err.getMessage());
        log.error("Exceção do tipo MethodArgumentNotValidException");

        e.printStackTrace();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(DynamoDBMappingException.class)
    public ResponseEntity<StandardError> dynamoDBMappingException(DynamoDBMappingException e){
        log.error("Problema no DynamoDB ao mapear.");
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), LocalDateTime.now(),
                "Problema no DynamoDB ao mapear o objeto.", e.getMessage(), 0);

        log.error(err.getMessage());
        log.error("Exceção do tipo DynamoDBMappingException");

        e.printStackTrace();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
