package com.nintendo.tcg.pokemon.sdk.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessagesEnum {
    // GENERIC MESSAGES
    OPERATION_SUCCESS(200, "Operação realizada com sucesso", "Operation carried out successfully"),
    OPERATION_ERROR(500, "Não foi possível realizar a operação", "The operation could not be performed"),
    OPERATION_ERROR_NOT_FOUND_FILE(500, "Não foi possível encontrar o arquivo origem JSON", "Unable to find JSON source file"),
    OPERATION_READ_OR_CONVERTER_ERROR(500, "", "Erro ao ler ou converter arquivo JSON: {}"),

    //POKEMON_SET
    POKEMON_SET_EXPORT_SUCCESS(200, "Pokémon Set exportados com sucesso", "Successfully exported Pokemon sets: {}"),
    POKEMON_SET_EXPORT_ERROR(500,"Erro ao exportar dados", "Error exporting data: {}"),
    POKEMON_SET_NOT_FOUND(404, "Pokémon set não foi encontrado", "Pokemon set not found"),
    POKEMON_SET_FORMAT_INVALID_EXPORT(400, "Formato de entrada não é valido para exportação", "Input format is not valid for export");

    private int code;
    private String ptBR;
    private String enUS;

}
