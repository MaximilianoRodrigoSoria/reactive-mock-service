package com.example.models.DTOs;

import com.example.models.documents.Mock;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MockDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("country")
    private String country;
    @JsonProperty("product")
    private String product;
    @JsonProperty("author")
    private String author;
    @JsonProperty("description")
    private String description;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("creation_date")
    private Date creationDate;
    @JsonProperty("last_update")
    private Date lastUpdate;


    public static Mock toDocument(MockDTO mockDTO){
        Mock mock = new Mock();
        BeanUtils.copyProperties(mockDTO, mock);
        return mock;
    }
}
