package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Image;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageDTO extends BaseModel<Image> {
    private UUID uuid;
    @JsonProperty("symbol")
    String symbol;
    @JsonProperty("logo")
    String logo;
    @JsonProperty("small")
    private String small;
    @JsonProperty("large")
    private String large;
}
