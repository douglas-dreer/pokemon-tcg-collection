package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.SubType;
import com.nintendo.tcg.pokemon.sdk.enums.SubTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class SubTypeDTO extends BaseModel<SubType> {
    private UUID uuid;
    @JsonProperty("subtypes")
    private SubTypesEnum name;

    public SubTypeDTO(UUID uuid, SubTypesEnum name) {
        super(SubType.class);
        this.uuid = uuid;
        this.name = name;
    }

    public SubTypeDTO(SubTypesEnum name) {
        super(SubType.class);
        this.name = name;
    }

    public SubTypeDTO(String name) {
        super(SubType.class);
        this.name = SubTypesEnum.findByName(name);
    }
}
