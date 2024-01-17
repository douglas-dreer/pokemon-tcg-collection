package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Weakness;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Builder
public class WeaknessDTO extends BaseModel<Weakness> {
    private UUID uuid;
    @JsonProperty("type")
    private PokemonTypeEnum type;
    @JsonProperty("value")
    private String vulnerability;

    public WeaknessDTO(UUID uuid, PokemonTypeEnum type, String vulnerability) {
        super(Weakness.class);
        this.uuid = uuid;
        this.type = type;
        this.vulnerability = vulnerability;
    }

    public WeaknessDTO(PokemonTypeEnum type, String vulnerability) {
        super(Weakness.class);
        this.type = type;
        this.vulnerability = vulnerability;
    }

    public WeaknessDTO(String type, String vulnerability) {
        super(Weakness.class);
        this.type = PokemonTypeEnum.findByName(type);
        this.vulnerability = vulnerability;
    }
}
