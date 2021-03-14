package br.com.aws.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "br.com.aws.dynamodb.repositories")
public class DynamoDBConfig {
	
	@Value("${aws.region}")
	private String region;
	
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		
		return AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.fromName(region)).
				withCredentials(new DefaultAWSCredentialsProviderChain()).build();
		
	}

}
