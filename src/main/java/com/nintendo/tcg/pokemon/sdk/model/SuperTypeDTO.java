package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.SuperType;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class SuperTypeDTO extends BaseModel<SuperType> {
    private UUID uuid;
    @JsonProperty("supertype")
    private SuperTypesEnum name;

    public SuperTypeDTO() {
        super(SuperType.class);
    }

    public SuperTypeDTO(String value) {
        super(SuperType.class);
        this.name = SuperTypesEnum.findByName(value);
    }
}
