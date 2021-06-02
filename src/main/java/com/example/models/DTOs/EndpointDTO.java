package com.example.models.DTOs;

import com.example.models.documents.Endpoint;
import com.example.models.documents.HttpRequest;
import com.example.models.documents.HttpResponse;
import com.example.models.documents.Mock;
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
public class EndpointDTO implements Serializable {

    @Id
    private String id;
    @JsonProperty("mock_id")
    private String mockId;
    private String name;
    private String author;
    private HttpRequest httpRequest ;
    private HttpResponse httpResponse;
    @JsonProperty("creation_date")
    private Date creationDate;
    @JsonProperty("last_update")
    private Date lastUpdate;


    public static Endpoint toDocument(EndpointDTO endpointDTO){
        Endpoint endpoint = new Endpoint();
        BeanUtils.copyProperties(endpointDTO, endpoint);
        return endpoint;
    }

}
