package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.PokemonSetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TBL001_POKEMON_SET")
@AllArgsConstructor
@Data
@Builder
public class PokemonSet extends BaseEntity<PokemonSetDTO> {
    public PokemonSet() {
        super(PokemonSetDTO.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String code;
    private String name;
    private String series;
    private int total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "legalities_id")
    private Legalities legalities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "images_id")
    private Images images;

    private String ptcgoCode;
    private String releaseDate;
    private String updatedAt;
}
