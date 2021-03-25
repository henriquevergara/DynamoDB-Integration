package br.com.aws.service.sign;

import br.com.aws.dynamodb.model.Card;
import br.com.aws.exception.StandardError;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface CardResourceSign {

    static final String NOTA_DESCRICAO = "Serviço sem autenticação";

    static final String LISTA_OBTIDA_COM_SUCESSO = "Lista obtida com sucesso";

    static final String CLIENTE_OBTIDO_COM_SUCESSO = "Cliente obtido com sucesso";

    static final String SUA_BUSCA_NAO_RETORNOU = "Sua busca não retornou nenhum resultado";

    static final String CLIENTE_REMOVIDO_COM_SUCESSO = "Cliente removido com sucesso";

    static final String MENSAGEM_SALVA_COM_SUCESSO = "Mensagem salva com sucesso!";

    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Salvo com sucesso", response = Card.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 415, message = "Unsupported Media Type", response = StandardError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = StandardError.class),
            @ApiResponse(code = 504, message = "Gateway Timeout", response = StandardError.class) })
    @ApiOperation(value = "Serviço disponível para salvar o card", notes = NOTA_DESCRICAO)
    ResponseEntity<?> createCard(@ApiParam(name = "Card", value = "Representação de uma carta magic", required = true)
                                                Card cardInput);

    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = CLIENTE_REMOVIDO_COM_SUCESSO, response = Card.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 415, message = "Unsupported Media Type", response = StandardError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = StandardError.class),
            @ApiResponse(code = 504, message = "Gateway Timeout", response = StandardError.class) })
    @ApiOperation(value = "Serviço disponível para remover o card", notes = NOTA_DESCRICAO)
    ResponseEntity<?> deleteCardById(String id);

    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = LISTA_OBTIDA_COM_SUCESSO, response = Card.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 415, message = "Unsupported Media Type", response = StandardError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = StandardError.class),
            @ApiResponse(code = 504, message = "Gateway Timeout", response = StandardError.class) })
    @ApiOperation(value = "Serviço disponível para obter card por id", notes = NOTA_DESCRICAO)
    ResponseEntity<?> findCardById(String name);

    @ResponseStatus(HttpStatus.OK)
    @ApiResponses(value = { @ApiResponse(code = 200, message = LISTA_OBTIDA_COM_SUCESSO, response = Card.class),
            @ApiResponse(code = 400, message = "Bad Request", response = StandardError.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = StandardError.class),
            @ApiResponse(code = 403, message = "Forbidden", response = StandardError.class),
            @ApiResponse(code = 404, message = "Not Found", response = StandardError.class),
            @ApiResponse(code = 415, message = "Unsupported Media Type", response = StandardError.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = StandardError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = StandardError.class),
            @ApiResponse(code = 504, message = "Gateway Timeout", response = StandardError.class) })
    @ApiOperation(value = "Serviço disponível para obter lista completa de cards", notes = NOTA_DESCRICAO)
    ResponseEntity<?> listAllCards();

}
