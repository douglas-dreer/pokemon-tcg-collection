package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Resistance;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResistanceDTO extends BaseModel<Resistance> {
    private UUID uuid;
    @JsonProperty("type")
    private PokemonTypeEnum type;
    @JsonProperty("value")
    private int effectiveness;
    public ResistanceDTO() {
        super(Resistance.class);
    }
}
