package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.SuperType;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SuperTypeDTO extends BaseModel<SuperType> {
    private UUID uuid;
    @JsonProperty("supertype")
    private SuperTypesEnum name;

    @Builder
    public SuperTypeDTO(UUID uuid, SuperTypesEnum name) {
        super(SuperType.class);
        this.uuid = uuid;
        this.name = name;
    }

    public SuperTypeDTO(SuperTypesEnum name) {
        super(SuperType.class);
        this.name = name;
    }

    public SuperTypeDTO(String superType) {
        super(SuperType.class);
        this.name = SuperTypesEnum.findByName(superType);
    }
}
