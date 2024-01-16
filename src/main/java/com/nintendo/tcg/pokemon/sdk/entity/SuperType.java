package com.nintendo.tcg.pokemon.sdk.entity;

import com.nintendo.tcg.pokemon.sdk.entity.common.BaseEntity;
import com.nintendo.tcg.pokemon.sdk.enums.SuperTypesEnum;
import com.nintendo.tcg.pokemon.sdk.model.SuperTypeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "TBL011_SUPERTYPES")
@AllArgsConstructor
@Data
@Builder
public class SuperType extends BaseEntity<SuperTypeDTO> {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, unique = true)
    private SuperTypesEnum name;


    public SuperType() {
        super(SuperTypeDTO.class);
    }
}


