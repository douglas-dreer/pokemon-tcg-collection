package com.nintendo.tcg.pokemon.sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.POKEMON_TYPE_NOT_FOUND;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum SuperTypesEnum {
    ENERGY("Energy"),
    POKEMON("Pokémon"),
    TRAINER("Trainer");

    @JsonValue
    private String superType;

    @JsonCreator
    public static SuperTypesEnum findByName(String name) {
        return Arrays.stream(SuperTypesEnum.values())
                .filter(value -> value.getSuperType().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new BusinessException(POKEMON_TYPE_NOT_FOUND.getMessageLocation("pt-BR")));
    }
}
