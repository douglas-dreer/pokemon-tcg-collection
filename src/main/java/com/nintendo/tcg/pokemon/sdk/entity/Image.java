package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.ImageDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TBL005_IMAGES")
@AllArgsConstructor
@Data
@Builder
public class Image extends BaseEntity<ImageDTO> {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_uuid")
    private Card card;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String logo;
    private String symbol;
    private String small;
    private String large;

    public Image() {
        super(ImageDTO.class);
    }
}
