package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Weakness;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class WeaknessDTO extends BaseModel<Weakness> {
    private UUID uuid;
    @JsonProperty("type")
    private PokemonTypeEnum type;
    @JsonProperty("value")
    private String vulnerability;
    public WeaknessDTO() {
        super(Weakness.class);
    }
}
