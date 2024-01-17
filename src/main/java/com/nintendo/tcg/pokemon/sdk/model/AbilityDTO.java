package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Ability;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbilityDTO extends BaseModel<Ability> {
    private UUID uuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;

    public AbilityDTO() {
        super(Ability.class);
    }

    public AbilityDTO(UUID uuid, String name, String text, String type) {
        super(Ability.class);
        this.uuid = uuid;
        this.name = name;
        this.text = text;
        this.type = type;
    }

    public AbilityDTO(String name, String text, String type) {
        super(Ability.class);
        this.name = name;
        this.text = text;
        this.type = type;
    }
}
