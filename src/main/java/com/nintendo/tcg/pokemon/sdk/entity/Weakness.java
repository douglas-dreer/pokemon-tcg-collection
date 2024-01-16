package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.WeaknessDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TBL012_WEAKNESSES")
@AllArgsConstructor
@Data
@Builder
public class Weakness extends BaseEntity<WeaknessDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "pokemon_type_uuid", referencedColumnName = "uuid")
    private PokemonType type;
    private String vulnerability;
    @ManyToOne
    @JoinColumn(name = "card_uuid")
    private Card card;

    public Weakness() {
        super(WeaknessDTO.class);
    }
}

