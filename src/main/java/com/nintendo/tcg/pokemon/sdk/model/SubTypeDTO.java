package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.SubType;
import com.nintendo.tcg.pokemon.sdk.enums.SubTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class SubTypeDTO extends BaseModel<SubType> {
    private UUID uuid;
    @JsonProperty("subtypes")
    private SubTypesEnum name;
    public SubTypeDTO() {
        super(SubType.class);
    }

    public SubTypeDTO(String value) {
        super(SubType.class);
        this.name = SubTypesEnum.findByName(value);
    }
}
