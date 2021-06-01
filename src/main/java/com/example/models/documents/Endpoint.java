package com.example.models.documents;

import com.example.models.DTOs.EndpointDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Document(collection="endpoints")
public class Endpoint implements Serializable {

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

    public static Mono<EndpointDTO> toDTO(Endpoint endpoint){
        EndpointDTO endpointDTO = new EndpointDTO();
        BeanUtils.copyProperties(endpoint, endpointDTO);
        return Mono.just(endpointDTO);
    }
}
