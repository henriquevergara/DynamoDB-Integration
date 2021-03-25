package br.com.aws.service;

import br.com.aws.dynamodb.model.Card;
import br.com.aws.dynamodb.repositories.CardRepository;
import br.com.aws.service.sign.CardResourceSign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public ResponseEntity<?> remove(String id){

        if (cardRepository.findById(id).isPresent()){
            log.info("Card encontrado, realizando a deleção.");
            Card cardDeletado = cardRepository.findById(id).get();
            cardRepository.deleteById(id);
            log.info("Card '" + cardDeletado.getName() + "' deletado.");
            return ResponseEntity.ok().body(cardDeletado);
        }else{
            log.info("Card não encontrado.");
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<?> create(Card card){

        try {
            return ResponseEntity.created(new URI("")).body(cardRepository.save(card));
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }

    public ResponseEntity<?> findAll(){

        log.info("Obtendo lista de informações dos cards na base de dados");
        Iterable<Card> all = cardRepository.findAll();

        List<Card> cards = new ArrayList<>();
        all.forEach(cards::add);

        return ResponseEntity.ok().body(cards);
    }

    public ResponseEntity<?> findById(String id){

        log.info("Buscando card pelo Id no banco de dados.");

        if(cardRepository.findById(id).isPresent()){
            Card cardEncontrado = cardRepository.findById(id).get();
            log.info("Card '" + cardEncontrado.getName() + "' encontrado na base de dados.");
            return ResponseEntity.ok().body(cardEncontrado);
        }else{
            log.info("Card não encontrado.");
            return ResponseEntity.notFound().build();
        }

    }

}
