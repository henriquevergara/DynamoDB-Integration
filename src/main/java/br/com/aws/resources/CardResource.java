package br.com.aws.resources;

import br.com.aws.dynamodb.model.Card;
import br.com.aws.dynamodb.repositories.CardRepository;
import br.com.aws.service.CardService;
import br.com.aws.service.sign.CardResourceSign;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Serviço de integração com AWS DynamoDb")
@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/cards")
public class CardResource implements CardResourceSign {

	@Autowired
	private CardRepository cardRepository;

	@Autowired
	private CardService cardService;

	@GetMapping
	public ResponseEntity<?> listAllCards(){
		return cardService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findCardById(@PathVariable("id") String id){
		return cardService.findById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCardById(@PathVariable("id") String id){
		return cardService.remove(id);
	}

	@PostMapping
	public ResponseEntity<?> createCard(@RequestBody Card card){
		return cardService.create(card);
	}
	
}
