package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Legalities;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LegalitiesDTO extends BaseModel<Legalities> {
    private UUID uuid;
    @JsonProperty("unlimited")
    String unlimited;
    @JsonProperty("expanded")
    String expanded;
}
