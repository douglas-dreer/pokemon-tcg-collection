package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.AttackDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TBL002_ATTACKS")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Attack extends BaseEntity<AttackDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "SEQ_ATTACK")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "TBLAUX001_ATTACK_POKEMON_TYPE",
            joinColumns = @JoinColumn(name = "attack_uuid"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_type_uuid")
    )
    private List<PokemonType> cost;
    private int convertedEnergyCost;
    private String damage;
    private String text;
    @ManyToOne
    @JoinColumn(name = "card_uuid")
    private Card card;

    public Attack() {
        super(AttackDTO.class);
    }

    public Attack(List<PokemonType> cost, int convertedEnergyCost, String damage, String text) {
        super(AttackDTO.class);
        this.cost = cost;
        this.convertedEnergyCost = convertedEnergyCost;
        this.damage = damage;
        this.text = text;
    }

    public Attack(UUID uuid, List<String> cost, int convertedEnergyCost, String damage, String text) {
        super(AttackDTO.class);
        this.uuid = uuid;
        this.convertedEnergyCost = convertedEnergyCost;
        this.damage = damage;
        this.text = text;

        this.cost = convertFromStringToModel(cost);
    }

    private List<PokemonType> convertFromStringToModel(List<String> list) {
        return list.stream().map(PokemonType::new).toList();

    }
}
