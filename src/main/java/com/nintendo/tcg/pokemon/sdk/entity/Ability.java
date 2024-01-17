package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.AbilityDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL001_ABILITIES")
@Getter
@Setter
@Builder
public class Ability extends BaseEntity<AbilityDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "SEQ_ABILITY")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    private String name;
    private String text;
    private String type;
    @ManyToOne
    @JoinColumn(name = "card_uuid")
    private Card card;

    public Ability() {
        super(AbilityDTO.class);
    }

    public Ability(UUID uuid, String name, String text, String type) {
        super(AbilityDTO.class);
        this.uuid = uuid;
        this.name = name;
        this.text = text;
        this.type = type;
    }

    public Ability(String name, String text, String type) {
        super(AbilityDTO.class);
        this.name = name;
        this.text = text;
        this.type = type;
    }

    public Ability(Class<AbilityDTO> modelClass, UUID uuid, String name, String text, String type, Card card) {
        super(modelClass);
        this.uuid = uuid;
        this.name = name;
        this.text = text;
        this.type = type;
        this.card = card;
    }

    public Ability(UUID uuid, String name, String text, String type, Card card) {
        super(AbilityDTO.class);
        this.uuid = uuid;
        this.name = name;
        this.text = text;
        this.type = type;
        this.card = card;
    }
}
