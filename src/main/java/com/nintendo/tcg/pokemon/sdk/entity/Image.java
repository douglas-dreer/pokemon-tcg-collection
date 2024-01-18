package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.ImageDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL005_IMAGES")
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Image extends BaseEntity<ImageDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "SEQ_IMAGE")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_uuid")
    private Card card;

    private String logo;
    private String symbol;
    private String small;
    private String large;

    public Image() {
        super(ImageDTO.class);
    }
}
