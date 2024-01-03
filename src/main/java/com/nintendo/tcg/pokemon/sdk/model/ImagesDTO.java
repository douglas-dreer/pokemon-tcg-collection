package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Images;
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
public class ImagesDTO extends BaseModel<Images> {
    private UUID uuid;
    @JsonProperty("symbol")
    String symbol;
    @JsonProperty("logo")
    String logo;
}
