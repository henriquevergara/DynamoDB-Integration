package br.com.aws.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@DynamoDBTable(tableName = "Card")
public class Card {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    @ApiModelProperty(readOnly = true)
    private String id;

    private String name;

    private String manaCost;

    private List<String> colors;

    private String type;

    private String rarity;

    private String power;

    private String toughness;

    private String imageUrl;

    public Card(){}

}