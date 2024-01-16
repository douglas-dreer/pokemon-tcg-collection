package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.enums.SubTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.SubTypeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "TBL010_SUBTYPES")
@AllArgsConstructor
@Data
@Builder
public class SubType extends BaseEntity<SubTypeDTO> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, unique = true)
    private SubTypesEnum name;

    public SubType() {
        super(SubTypeDTO.class);
    }
}
