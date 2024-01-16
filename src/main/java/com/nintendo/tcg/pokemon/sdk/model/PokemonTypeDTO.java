package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.PokemonType;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class PokemonTypeDTO extends BaseModel<PokemonType> {
    private UUID uuid;
    @JsonProperty("types")
    private PokemonTypeEnum name;

    public PokemonTypeDTO() {
        super(PokemonType.class);
    }

    public PokemonTypeDTO(String value) {
        super(PokemonType.class);
        this.name = PokemonTypeEnum.findByName(value);
    }
}
