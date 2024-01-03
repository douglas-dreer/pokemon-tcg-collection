package com.nintendo.tcg.pokemon.sdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {
    OK("SUCCESS", "Operation executed successfully"),
    ERROR("ERROR", "The operation could not be performed."),
    INFO("INFORMATION", ""),
    WARNING("WARNING", "");

    private String code;
    private String text;
}