package com.nintendo.tcg.pokemon.sdk.enums;

import com.nintendo.tcg.pokemon.sdk.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

import static com.nintendo.tcg.pokemon.sdk.enums.MessagesEnum.POKEMON_TYPE_NOT_FOUND;

@AllArgsConstructor
@Getter
public enum SubTypesEnum {
    BREAK("BREAK"),
    BABY("Baby"),
    BASIC("Basic"),
    EX("EX"),
    GX("GX"),
    GOLDENROD_GAME_CORNER("Goldenrod Game Corner"),
    ITEM("Item"),
    LEGEND("LEGEND"),
    LEVEL_UP("Level-Up"),
    MEGA("MEGA"),
    POKEMON_TOOL("Pokémon Tool"),
    POKEMON_TOOL_F("Pokémon Tool F"),
    RAPID_STRIKE("Rapid Strike"),
    RESTORED("Restored"),
    ROCKETS_SECRET_MACHINE("Rocket's Secret Machine"),
    SINGLE_STRIKE("Single Strike"),
    SPECIAL("Special"),
    STADIUM("Stadium"),
    STAGE_1("Stage 1"),
    STAGE_2("Stage 2"),
    SUPPORTER("Supporter"),
    TAG_TEAM("TAG TEAM"),
    TECHNICAL_MACHINE("Technical Machine"),
    V("V"),
    VMAX("VMAX");

    private String name;

    public static SubTypesEnum findByName(String name) {
        return Arrays.stream(SubTypesEnum.values())
                .filter(value -> value.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new BusinessException(POKEMON_TYPE_NOT_FOUND.getMessageLocation("pt-BR")));
    }

}
