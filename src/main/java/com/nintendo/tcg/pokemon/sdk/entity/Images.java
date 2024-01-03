package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.ImagesDTO;
import com.nintendo.tcg.pokemon.sdk.model.LegalitiesDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TBL003_IMAGES")
@AllArgsConstructor
@Data
@Builder
public class Images extends BaseEntity<ImagesDTO> {
    public Images() {
        super(ImagesDTO.class);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String logo;
    private String symbol;
}
