package br.com.aws.resources;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aws.dynamodb.model.User;
import br.com.aws.dynamodb.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity<?> criarUsuario(@RequestBody User req){
		
		try {
			return ResponseEntity.created(new URI("")).body(userRepository.save(req));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
		
	}
	
}
