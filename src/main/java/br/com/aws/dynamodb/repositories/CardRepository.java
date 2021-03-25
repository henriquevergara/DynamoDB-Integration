package br.com.aws.dynamodb.repositories;

import br.com.aws.dynamodb.model.Card;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CardRepository extends CrudRepository<Card, String>{

}
