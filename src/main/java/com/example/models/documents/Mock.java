package com.example.models.documents;

import com.example.models.DTOs.MockDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.Date;


@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection="mocks")
public class Mock implements Serializable {

    @Id
    private String id;
    private String name;
    private String country;
    private String product;
    private String author;
    private String description;
    private String prefix;
    @JsonProperty("creation_date")
    private Date creationDate;
    @JsonProperty("last_update")
    private Date lastUpdate;


    public static Mono<MockDTO> toDTO(Mock mock){
        MockDTO mockDTO = new MockDTO();
        BeanUtils.copyProperties(mock, mockDTO);
        return Mono.just(mockDTO);
    }

}
