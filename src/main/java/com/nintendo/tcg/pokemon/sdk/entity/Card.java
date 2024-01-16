package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.CardDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TBL003_CARDS")
@Data
@Builder
@AllArgsConstructor
public class Card extends BaseEntity<CardDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    private String code;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "super_type_uuid")
    private SuperType superType;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "TBLAUX003_CARD_SUB_TYPE",
            joinColumns = @JoinColumn(name = "card_uuid"),
            inverseJoinColumns = @JoinColumn(name = "sub_type_uuid")
    )
    private List<SubType> subTypes;
    private int level;
    private int hp;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "TBLAUX004_CARD_TYPE",
            joinColumns = @JoinColumn(name = "card_uuid"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_type_uuid")
    )
    private List<PokemonType> types;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "evolves_from_uuid", nullable = true)
    private Card evolvesFrom;
    @ElementCollection
    @CollectionTable(name = "TBLAUX009_EVOLVES_TO_LIST", joinColumns = @JoinColumn(name = "card_uuid"))
    @Column(name = "evolves_to")
    private List<String> evolvesTo;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ability> abilities;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Attack> attacks;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Weakness> weaknesses;
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resistance> resistances;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "TBLAUX005_CARD_RETREAT_COST",
            joinColumns = @JoinColumn(name = "card_uuid"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_type_uuid")
    )
    private List<PokemonType> retreatCost;
    private int convertedRetreatCost;
    private int number;
    private String artist;
    private String rarity;
    private String flavorText;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "TBLAUX006_CARD_NATIONAL_POKEDEX_NUMBERS", joinColumns = @JoinColumn(name = "card_uuid"))
    @Column(name = "national_pokedex_number")
    private List<Integer> nationalPokedexNumbers;
    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Legality legalities;
    @OneToOne(mappedBy = "card", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image images;

    public Card() {
        super(CardDTO.class);
    }
}
