package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.model.PokemonSetDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL007_POKEMON_SET")
@AllArgsConstructor
@Data
@Builder
public class PokemonSet extends BaseEntity<PokemonSetDTO> {
    public PokemonSet() {
        super(PokemonSetDTO.class);
    }
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;

    private String code;
    private String name;
    private String series;
    private int total;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "legalities_id")
    private Legality legality;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "images_id")
    private Image image;
    private String ptcgoCode;
    private String releaseDate;
    private String updatedAt;

}
