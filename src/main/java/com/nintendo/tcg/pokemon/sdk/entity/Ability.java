package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.AbilityDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL001_ABILITIES")
@AllArgsConstructor
@Data
@Builder
public class Ability extends BaseEntity<AbilityDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
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
}
