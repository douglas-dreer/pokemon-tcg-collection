package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.enums.PokemonTypeEnum;
import com.nintendo.tcg.pokemon.sdk.model.WeaknessDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL012_WEAKNESSES")
@NoArgsConstructor
@Getter
@Setter
public class Weakness extends BaseEntity<WeaknessDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    @ManyToOne
    @JoinColumn(name = "pokemon_type_uuid", referencedColumnName = "uuid")
    private PokemonType type;
    private String vulnerability;
    @ManyToOne
    @JoinColumn(name = "card_uuid")
    private Card card;

    public Weakness(UUID uuid, PokemonType type, String vulnerability) {
        super(WeaknessDTO.class);
        this.uuid = uuid;
        this.type = type;
        this.vulnerability = vulnerability;
    }

    public Weakness(UUID uuid, PokemonTypeEnum type, String vulnerability) {
        super(WeaknessDTO.class);
        this.uuid = uuid;
        this.type = new PokemonType(type);
        this.vulnerability = vulnerability;
    }

    public Weakness(PokemonType type, String vulnerability) {
        super(WeaknessDTO.class);
        this.type = type;
        this.vulnerability = vulnerability;
    }

    public Weakness(PokemonTypeEnum type, String vulnerability) {
        super(WeaknessDTO.class);
        this.type = new PokemonType(type);
        this.vulnerability = vulnerability;
    }

    public Weakness(UUID uuid, PokemonTypeEnum type, String vulnerability, Card card) {
        super(WeaknessDTO.class);
        this.uuid = uuid;
        this.type = new PokemonType(type);
        this.vulnerability = vulnerability;
        this.card = card;
    }
}

