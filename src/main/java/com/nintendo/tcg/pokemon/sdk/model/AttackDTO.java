package com.nintendo.tcg.pokemon.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nintendo.tcg.pokemon.sdk.entity.Attack;
import com.nintendo.tcg.pokemon.sdk.model.common.BaseModel;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
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

    public AttackDTO(UUID uuid, String name, List<String> cost, int convertedEnergyCost, String damage, String text) {
        super(Attack.class);
        this.uuid = uuid;
        this.name = name;
        this.cost = cost;
        this.convertedEnergyCost = convertedEnergyCost;
        this.damage = damage;
        this.text = text;
    }

    public AttackDTO(String name, List<String> cost, int convertedEnergyCost, String damage, String text) {
        super(Attack.class);
        this.name = name;
        this.cost = cost;
        this.convertedEnergyCost = convertedEnergyCost;
        this.damage = damage;
        this.text = text;
    }

}
