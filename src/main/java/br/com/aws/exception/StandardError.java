package br.com.aws.exception;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private LocalDateTime dateTime;
    private String message;
    private String messageError;
    private Integer code;

    public StandardError(Integer status, LocalDateTime dateTime, String message, String messageError, Integer code) {
        super();
        this.status = status;
        this.dateTime = dateTime;
        this.message = message;
        this.messageError = messageError;
        this.code = code;
    }

}
