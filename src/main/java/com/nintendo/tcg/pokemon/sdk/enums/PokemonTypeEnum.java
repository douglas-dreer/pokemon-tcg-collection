package com.nintendo.tcg.pokemon.sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.POKEMON_TYPE_NOT_FOUND;

@AllArgsConstructor
@Getter
public enum PokemonTypeEnum {
    COLORLESS("Colorless"),
    DARKNESS("Darkness"),
    DRAGON("Dragon"),
    FAIRY("Fairy"),
    FIGHTING("Fighting"),
    FIRE("Fire"),
    GRASS("Grass"),
    LIGHTNING("Lightning"),
    METAL("Metal"),
    PSYCHIC("Psychic"),
    WATER("Water");

    @JsonValue
    private String type;

    @JsonCreator
    public static PokemonTypeEnum findByName(String name) {
        return Arrays.stream(PokemonTypeEnum.values())
                .filter(value -> value.getType().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new BusinessException(POKEMON_TYPE_NOT_FOUND.getMessageLocation("pt-BR")));
    }

}
