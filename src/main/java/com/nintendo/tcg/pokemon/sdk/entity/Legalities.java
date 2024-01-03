package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.LegalitiesDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TBL002_LEGALITIES")
@AllArgsConstructor
@Data
@Builder
public class Legalities extends BaseEntity<LegalitiesDTO> {
    public Legalities() {
        super(LegalitiesDTO.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String unlimited;
    private String expanded;
}
