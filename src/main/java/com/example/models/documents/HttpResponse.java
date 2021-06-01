package com.example.models.documents;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class HttpResponse {
    @JsonProperty("status_code")
    private String statusCode;
    private String body;
    private String bodyType;
    private Map<String, Object> headers;
}

