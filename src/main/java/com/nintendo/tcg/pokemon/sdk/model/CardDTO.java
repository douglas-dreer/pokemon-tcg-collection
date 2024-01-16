package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Card;
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
public class CardDTO extends BaseModel<Card> {
    private UUID uuid;
    @JsonProperty("id")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("supertype")
    private SuperTypeDTO superType;
    @JsonProperty("subtypes")
    private List<SubTypeDTO> subTypes;
    @JsonProperty("level")
    private int level;
    @JsonProperty("hp")
    private int hp;
    @JsonProperty("types")
    private List<PokemonTypeDTO> types;
    @JsonProperty("evolvesTo")
    private List<String> evolvesTo;
    @JsonProperty("evolvesFrom")
    private String evolvesFrom;
    @JsonProperty("abilities")
    private List<AbilityDTO> abilities;
    @JsonProperty("attacks")
    private List<AttackDTO> attacks;
    @JsonProperty("weaknesses")
    private List<WeaknessDTO> weaknesses;
    @JsonProperty("resistances")
    private List<ResistanceDTO> resistances;
    @JsonProperty("retreatCost")
    private List<PokemonTypeDTO> retreatCost;
    @JsonProperty("convertedRetreatCost")
    private int convertedRetreatCost;
    @JsonProperty("number")
    private int number;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("rarity")
    private String rarity;
    @JsonProperty("flavorText")
    private String flavorText;
    @JsonProperty("nationalPokedexNumbers")
    private List<Integer> nationalPokedexNumbers;
    @JsonProperty("legalities")
    private LegalityDTO legalities;
    @JsonProperty("images")
    private ImageDTO images;
    public CardDTO() {
        super(Card.class);
    }


}
