package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.LegalityDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL006_LEGALITIES")
@AllArgsConstructor
@Data
@Builder
public class Legality extends BaseEntity<LegalityDTO> {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_uuid")
    private Card card;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    private String unlimited;
    private String expanded;

    public Legality() {
        super(LegalityDTO.class);
    }
}
