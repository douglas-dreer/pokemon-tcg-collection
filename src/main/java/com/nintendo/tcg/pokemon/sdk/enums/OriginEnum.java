package com.nintendo.tcg.pokemon.sdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OriginEnum {
    SITE("site"),
    JSON_FILE("JSON file");

    private final String name;

}
