package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.DeckDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TBL004_DECKS")
@AllArgsConstructor
@Data
@Builder
public class Deck extends BaseEntity<DeckDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    @ManyToMany
    @JoinTable(
            name = "TBLAUX007_DECK_TYPE",
            joinColumns = @JoinColumn(name = "deck_uuid"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_type_uuid")
    )
    private List<PokemonType> types;
    @ManyToMany
    @JoinTable(
            name = "TBLAUX008_DECK_CARD",
            joinColumns = @JoinColumn(name = "deck_uuid"),
            inverseJoinColumns = @JoinColumn(name = "card_uuid")
    )
    private List<Card> cards;

    public Deck() {
        super(DeckDTO.class);
    }
}
