package com.nintendo.tcg.pokemon.sdk.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.model.PokemonTypeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TBL008_POKEMON_TYPES")
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonType extends BaseEntity<PokemonTypeDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private PokemonTypeEnum name;
    public PokemonType() {
        super(PokemonTypeDTO.class);
    }
}
