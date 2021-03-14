package br.com.aws.dynamodb.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import br.com.aws.dynamodb.model.User;

@EnableScan
public interface UserRepository extends CrudRepository<User, String>{

}
