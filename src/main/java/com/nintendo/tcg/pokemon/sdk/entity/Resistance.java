package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.ResistanceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL009_RESISTANCES")
@AllArgsConstructor
@Data
@Builder
public class Resistance extends BaseEntity<ResistanceDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uui;
    @ManyToOne
    @JoinColumn(name = "pokemon_type_uuid", referencedColumnName = "uuid")
    private PokemonType type;
    private int effectiveness;
    @ManyToOne
    @JoinColumn(name = "card_uuid")
    private Card card;

    public Resistance() {
        super(ResistanceDTO.class);
    }
}
