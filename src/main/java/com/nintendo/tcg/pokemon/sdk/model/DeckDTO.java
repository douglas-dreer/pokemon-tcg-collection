package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Deck;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeckDTO extends BaseModel<Deck> {
    @JsonProperty("types")
    List<PokemonTypeEnum> types;
    @JsonProperty("cards")
    List<CardDTO> cards;
    private UUID uuid;
    @JsonProperty("id")
    private String code;
    @JsonProperty("name")
    private String name;
    public DeckDTO() {
        super(Deck.class);
    }
}
