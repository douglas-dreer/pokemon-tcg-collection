package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.PokemonSet;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class PokemonSetDTO extends BaseModel<PokemonSet> {
    public PokemonSetDTO() {
        super(PokemonSet.class);
    }
    private UUID uuid;
    @JsonProperty("id")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("series")
    private String series;
    @JsonProperty("printedTotal")
    private int printedTotal;
    @JsonProperty("total")
    private int total;
    @JsonProperty("legalities")
    private LegalityDTO legalities;
    @JsonProperty("images")
    private ImageDTO images;
    @JsonProperty("ptcgoCode")
    private String ptcgoCode;
    @JsonProperty("releaseDate")
    private String releaseDate;
    @JsonProperty("updatedAt")
    private String updatedAt;
}
