package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Attack;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
public class AttackDTO extends BaseModel<Attack> {
    private UUID uuid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cost")
    private List<String> cost;
    @JsonProperty("convertedEnergyCost")
    private int convertedEnergyCost;
    @JsonProperty("damage")
    private String damage;
    @JsonProperty("text")
    private String text;
    public AttackDTO() {
        super(Attack.class);
    }

}
